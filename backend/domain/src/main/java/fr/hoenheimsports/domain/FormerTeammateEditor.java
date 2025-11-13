package fr.hoenheimsports.domain;

import fr.hoenheimsports.domain.annotations.UseCase;
import fr.hoenheimsports.domain.api.EditFormerTeammate;
import fr.hoenheimsports.domain.api.commands.ContextDetails;
import fr.hoenheimsports.domain.api.commands.CurrentUser;
import fr.hoenheimsports.domain.api.commands.UpdateFormerTeammateRequest;
import fr.hoenheimsports.domain.exceptions.CurrentUserMissingException;
import fr.hoenheimsports.domain.exceptions.FormerTeammateNotFoundException;
import fr.hoenheimsports.domain.models.ContactStatus;
import fr.hoenheimsports.domain.models.FormerTeammate;
import fr.hoenheimsports.domain.services.FormerTeammateHistoryCreator;
import fr.hoenheimsports.domain.services.HandleSMSValidation;
import fr.hoenheimsports.domain.services.UpdateFormerTeammate;
import fr.hoenheimsports.domain.spi.FormerTeammateRepository;

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
    private final HandleSMSValidation handleSMSValidation;
    private final FormerTeammateHistoryCreator formerTeammateHistoryCreator;
    private final UpdateFormerTeammate updateFormerTeammate;

    /**
     * Constructeur du service de mise à jour des anciens coéquipiers.
     * 
     * @param formerTeammateRepository dépôt pour la persistance des anciens coéquipiers
     * @throws IllegalArgumentException si le paramètre est null
     */
    public FormerTeammateEditor(FormerTeammateRepository formerTeammateRepository, HandleSMSValidation handleSMSValidation, FormerTeammateHistoryCreator formerTeammateHistoryCreator, UpdateFormerTeammate updateFormerTeammate) {
        this.formerTeammateRepository = formerTeammateRepository;
        this.handleSMSValidation = handleSMSValidation;
        this.formerTeammateHistoryCreator = formerTeammateHistoryCreator;
        this.updateFormerTeammate = updateFormerTeammate;
    }



    @Override
    public FormerTeammate editFormerTeammate(UpdateFormerTeammateRequest updateFormerTeammateRequest, ContextDetails context) {
        //Cela vérifie aussi la présence d'un currentUser dans le contexte.
        if(!context.hasRole("USER") && !context.hasRole("ADMIN")) {
            throw new CurrentUserMissingException("Vous n'avez pas les autorisations requises");
        }
        //TODO il faudrait normalement pouvoir éditer que sur des FormerTeammate actif. Pour l'instant j'utilise des requètes SQL
        // Il faudrait mieux faire un service pour cela
        var oldFormerTeammate = formerTeammateRepository.findById(updateFormerTeammateRequest.formerTeammateId()).orElseThrow(() -> new FormerTeammateNotFoundException("L'entité Contact à modifier n'a pas été trouvée"));


        
        // Mise à jour de l'entité
        var updatedFormerTeammate = updateFormerTeammate.updateFormerTeammate(oldFormerTeammate,updateFormerTeammateRequest);
        if(oldFormerTeammate.equals(updatedFormerTeammate)) {
            return oldFormerTeammate;
        }
        var updatedBy = context.currentUser().map(CurrentUser::username).orElseThrow(() -> new IllegalStateException("ERREUR CRITIQUE : currentUser absent malgré la vérification hasRole. Vérifiez que la validation de sécurité n'a pas été supprimée."));;
        formerTeammateHistoryCreator.createHistoryForUpdate(updatedFormerTeammate,updatedBy,"Mise à jour des informations du contact");

        boolean isPhoneUpdated = !updatedFormerTeammate.phone().equals(oldFormerTeammate.phone());
        if(updatedFormerTeammate.phone().isEmpty() && isPhoneUpdated) {
            updatedFormerTeammate = updateFormerTeammate.updateContactStatus(updatedFormerTeammate, ContactStatus.UNREACHABLE);
            formerTeammateHistoryCreator.createHistoryForUpdate(updatedFormerTeammate,updatedBy,"Transition du status vers → INJOIGNABLE : Échec de l'envoi du SMS. " +
            "Le numéro de téléphone fourni est invalide ou absent.");

        }
        if(updatedFormerTeammate.phone().isPresent() && isPhoneUpdated) {
            updatedFormerTeammate = handleSMSValidation.handleValidationBySMS(updatedFormerTeammate, context.currentUser().orElseThrow().username());
        }

        return updatedFormerTeammate;
    }


}