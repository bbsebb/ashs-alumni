package fr.hoenheimsports.domain;

import fr.hoenheimsports.domain.annotations.UseCase;
import fr.hoenheimsports.domain.api.EditFormerTeammate;
import fr.hoenheimsports.domain.api.commands.ContextDetails;
import fr.hoenheimsports.domain.api.commands.CurrentUser;
import fr.hoenheimsports.domain.api.commands.UpdateFormerTeammateRequest;
import fr.hoenheimsports.domain.exceptions.CurrentUserMissingException;
import fr.hoenheimsports.domain.exceptions.FormerTeammateNotFoundException;
import fr.hoenheimsports.domain.exceptions.SMSHistoryRepositoryException;
import fr.hoenheimsports.domain.models.ContactStatus;
import fr.hoenheimsports.domain.models.FormerTeammate;
import fr.hoenheimsports.domain.models.Phone;
import fr.hoenheimsports.domain.services.FormerTeammateHistoryCreator;
import fr.hoenheimsports.domain.services.HandleSMSValidation;
import fr.hoenheimsports.domain.services.UpdateFormerTeammate;
import fr.hoenheimsports.domain.services.validations.FormerTeammateUniquenessValidationService;
import fr.hoenheimsports.domain.spi.FormerTeammateRepository;

import java.util.Optional;

/**
 * Service de domaine responsable de la mise à jour des anciens coéquipiers.
 * 
 * <p>Ce service implémente l'API {@link EditFormerTeammate} et se concentre
 * uniquement sur la mise à jour des FormerTeammate, notamment la modification
 * du statut de contact suite à des événements du cycle de vie comme la
 * validation par SMS.</p>
 * 
 * <p>Fonctionnalités principales :</p>
 * <ul>
 *   <li><strong>Mise à jour par ID :</strong> Recherche l'entité par identifiant et met à jour son statut</li>
 *   <li><strong>Mise à jour directe :</strong> Met à jour une entité déjà chargée en mémoire</li>
 *   <li><strong>Immutabilité :</strong> Utilise la méthode withContactStatus pour créer une nouvelle instance</li>
 *   <li><strong>Persistance :</strong> Sauvegarde automatiquement les modifications</li>
 * </ul>
 * 
 * <p>Cette classe suit le principe de responsabilité unique en se concentrant
 * exclusivement sur les mises à jour, laissant la gestion de l'historique
 * et la création à d'autres services spécialisés.</p>
 * 
 * @author ASHS Alumni System
 * @since 1.0
 * @see EditFormerTeammate
 * @see FormerTeammate
 * @see ContactStatus
 */
@UseCase
public class FormerTeammateEditor implements EditFormerTeammate {
    
    private final FormerTeammateRepository formerTeammateRepository;
    private final FormerTeammateUniquenessValidationService uniquenessValidationService;
    private final HandleSMSValidation handleSMSValidation;
    private final FormerTeammateHistoryCreator formerTeammateHistoryCreator;
    private final UpdateFormerTeammate updateFormerTeammate;

    /**
     * Constructeur du service de mise à jour des anciens coéquipiers.
     * 
     * @param formerTeammateRepository dépôt pour la persistance des anciens coéquipiers
     * @throws IllegalArgumentException si le paramètre est null
     */
    public FormerTeammateEditor(FormerTeammateRepository formerTeammateRepository, FormerTeammateUniquenessValidationService uniquenessValidationService, HandleSMSValidation handleSMSValidation, FormerTeammateHistoryCreator formerTeammateHistoryCreator, UpdateFormerTeammate updateFormerTeammate) {
        this.formerTeammateRepository = formerTeammateRepository;
        this.uniquenessValidationService = uniquenessValidationService;
        this.handleSMSValidation = handleSMSValidation;
        this.formerTeammateHistoryCreator = formerTeammateHistoryCreator;
        this.updateFormerTeammate = updateFormerTeammate;
    }



    @Override
    public FormerTeammate editFormerTeammate(UpdateFormerTeammateRequest updateFormerTeammateRequest, ContextDetails context) {
        //Cela vérifie aussi la présence d'un currentUser dans le contexte.
        if(!context.hasRole("USER")) {
            throw new CurrentUserMissingException("Vous n'avez pas les autorisations requises");
        }

        var oldFormerTeammate = formerTeammateRepository.findById(updateFormerTeammateRequest.formerTeammateId()).orElseThrow(() -> new FormerTeammateNotFoundException("L'entité Contact à modifier n'a pas été trouvée"));

        if (!hasAnyFieldChanged(oldFormerTeammate, updateFormerTeammateRequest)) {
            return oldFormerTeammate;
        }
        
        // Mise à jour de l'entité
        var updatedFormerTeammate = updateFormerTeammate(oldFormerTeammate,updateFormerTeammateRequest);
        var updatedBy = context.currentUser().map(CurrentUser::username).orElseThrow(() -> new IllegalStateException("ERREUR CRITIQUE : currentUser absent malgré la vérification hasRole. Vérifiez que la validation de sécurité n'a pas été supprimée."));;
        formerTeammateHistoryCreator.createHistoryForUpdate(oldFormerTeammate,updatedBy,"Mise à jour des informations du contact");

        boolean isPhoneUpdated = !updatedFormerTeammate.phone().equals(oldFormerTeammate.phone());
        if(updatedFormerTeammate.phone().isEmpty() && isPhoneUpdated) {
            formerTeammateHistoryCreator.createHistoryForUpdate(oldFormerTeammate,updatedBy,"Transition du status vers → INJOIGNABLE : Échec de l'envoi du SMS. " +
            "Le numéro de téléphone fourni est invalide ou absent.");
            updatedFormerTeammate = updateFormerTeammate.updateContactStatus(updatedFormerTeammate, ContactStatus.UNREACHABLE);
        }
        if(updatedFormerTeammate.phone().isPresent() && isPhoneUpdated) {
            updatedFormerTeammate = handleSMSValidation.handleSMSValidation(updatedFormerTeammate, context.currentUser().orElseThrow().username());
        }

        return updatedFormerTeammate;
    }

    private FormerTeammate updateFormerTeammate(FormerTeammate oldFormerTeammate, UpdateFormerTeammateRequest updateFormerTeammateRequest) {


        //Si le nom ou le prénom ont été modifié, on vérifie leur unicité
        if(!oldFormerTeammate.firstName().equalsIgnoreCase(updateFormerTeammateRequest.newFirstName()) || !oldFormerTeammate.lastName().equalsIgnoreCase(updateFormerTeammateRequest.newLastName())) {
            uniquenessValidationService.validateNameUniqueness(updateFormerTeammateRequest.newFirstName(), updateFormerTeammateRequest.newLastName());
        }
        // Le téléphone étant masqué pour l'utilisateur, s'il n'y a pas de changement, on doit reprendre le numéro non masqué existant en base de donnée.
        String newPhone;
        if(hasPhoneChanged(oldFormerTeammate, updateFormerTeammateRequest)) {
            uniquenessValidationService.validatePhoneUniqueness(updateFormerTeammateRequest.newPhone());
            newPhone = updateFormerTeammateRequest.newPhone();
        } else {
            newPhone = oldFormerTeammate.phone().map(Phone::getRawValue).orElse(null);
        }
        var updatedFormerTeammate = FormerTeammate.builder()
                .id(oldFormerTeammate.id())
                .gender(updateFormerTeammateRequest.newGender())
                .firstName(updateFormerTeammateRequest.newFirstName())
                .lastName(updateFormerTeammateRequest.newLastName())
                .phone(newPhone)
                .email(updateFormerTeammateRequest.newEmail())
                .birthDate(updateFormerTeammateRequest.newBirthDate())
                .roles(updateFormerTeammateRequest.roles())
                .status(oldFormerTeammate.status())
                .build();


        return formerTeammateRepository.save(updatedFormerTeammate);
    }

    private boolean hasAnyFieldChanged(FormerTeammate old, UpdateFormerTeammateRequest update) {
        return !old.firstName().equalsIgnoreCase(update.newFirstName())
                || !old.lastName().equalsIgnoreCase(update.newLastName())
                || !old.gender().equals(update.newGender())
                || hasPhoneChanged(old, update)
                || !old.email().equals(Optional.ofNullable(update.newEmail()))
                || !old.birthDate().equals(Optional.ofNullable(update.newBirthDate()))
                || !old.roles().equals(update.roles());
    }

    /**
     * Détermine si le numéro de téléphone a changé entre l'ancien et le nouveau contact.
     * Un téléphone avec des asterisques renvoie false.
     *
     * @param oldFormerTeammate l'ancien contact
     * @param updateRequest la requête de mise à jour contenant le nouveau numéro
     * @return true si le numéro de téléphone a changé, false sinon
     */
    private boolean hasPhoneChanged(FormerTeammate oldFormerTeammate, UpdateFormerTeammateRequest updateRequest) {
        String newPhone = updateRequest.newPhone();
        Optional<Phone> oldPhone = oldFormerTeammate.phone();

        // Les deux sont vides/null : pas de changement
        if (newPhone == null && oldPhone.isEmpty()) {
            return false;
        }

        // L'un est présent et l'autre non : changement
        if (newPhone == null || oldPhone.isEmpty()) {
            return true;
        }

        //Le téléphone étant masqué pour l'utilisateur, l'envoie d'un numéro avec un astérisque signifie qu'il n'a pas été modifié.
        if (newPhone.contains("*")) {
            return false;
        }

        String oldMaskedPhoneStr = oldPhone.get().toString();
        String oldUnmaskedPhoneStr = oldPhone.get().getRawValue();
        // Les deux sont présents : comparer les valeurs
        return !oldMaskedPhoneStr.equals(newPhone) && !oldUnmaskedPhoneStr.equals(newPhone);
    }
}