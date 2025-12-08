package fr.hoenheimsports.domain.services;

import fr.hoenheimsports.domain.annotations.DomainService;
import fr.hoenheimsports.domain.api.commands.FormerTeammateModificationRequest;
import fr.hoenheimsports.domain.api.commands.UpdateFormerTeammateRequest;
import fr.hoenheimsports.domain.api.commands.ValidateFormerTeammateRequest;
import fr.hoenheimsports.domain.models.ContactStatus;
import fr.hoenheimsports.domain.models.FormerTeammate;
import fr.hoenheimsports.domain.models.Phone;
import fr.hoenheimsports.domain.services.validations.FormerTeammateUniquenessValidationService;
import fr.hoenheimsports.domain.spi.FormerTeammateRepository;

import java.util.Optional;
import java.util.UUID;

/**
 * Service de mise à jour du statut de contact des anciens coéquipiers.
 * 
 * <p>Cette classe implémente {@link UpdateFormerTeammate} et fournit des fonctionnalités
 * pour mettre à jour le statut de contact des anciens coéquipiers dans le système.
 * Elle gère deux scénarios principaux :</p>
 * 
 * <ul>
 *   <li>Mise à jour par identifiant : recherche l'entité puis met à jour son statut</li>
 *   <li>Mise à jour directe : met à jour une entité déjà chargée en mémoire</li>
 * </ul>
 * 
 * <p>La classe utilise le pattern d'immutabilité du modèle {@code FormerTeammate},
 * créant de nouvelles instances lors des mises à jour plutôt que de modifier
 * les objets existants, garantissant ainsi l'intégrité des données.</p>
 * 
 * <p><strong>Utilisation typique :</strong></p>
 * <pre>{@code
 * // Mise à jour par ID
 * FormerTeammate updated = updater.updateContactStatus(teammateId, ContactStatus.VALIDATED);
 * 
 * // Mise à jour directe
 * FormerTeammate updated = updater.updateContactStatus(teammate, ContactStatus.PENDING);
 * }</pre>
 * 
 * @author Generated Documentation
 * @since 1.0
 * @see UpdateFormerTeammate
 * @see ContactStatus
 * @see FormerTeammate
 */
@DomainService
public class FormerTeammateUpdater implements UpdateFormerTeammate {
    private final FormerTeammateRepository formerTeammateRepository;
    private final FormerTeammateUniquenessValidationService uniquenessValidationService;

    public FormerTeammateUpdater(FormerTeammateRepository formerTeammateRepository, FormerTeammateUniquenessValidationService uniquenessValidationService) {
        this.formerTeammateRepository = formerTeammateRepository;
        this.uniquenessValidationService = uniquenessValidationService;
    }

    /**
     * Met à jour le statut de contact d'un ancien coéquipier.
     *
     * <p>Cette méthode recherche l'ancien coéquipier par son identifiant,
     * met à jour son statut de contact et sauvegarde la modification.
     * Si l'entité n'est pas trouvée, la méthode retourne null.</p>
     *
     * <p>La mise à jour utilise la méthode {@code withContactStatus} qui
     * crée une nouvelle instance immutable de FormerTeammate avec le
     * nouveau statut, préservant l'intégrité des données.</p>
     *
     * @param formerTeammateId l'identifiant de l'ancien coéquipier à mettre à jour
     * @param newStatus le nouveau statut de contact à appliquer
     * @return l'ancien coéquipier avec le statut mis à jour, ou null si non trouvé
     */
    @Override
    public FormerTeammate updateContactStatus(UUID formerTeammateId, ContactStatus newStatus) {
        return formerTeammateRepository.findById(formerTeammateId)
                .map(formerTeammate -> updateContactStatus(formerTeammate, newStatus))
                .orElse(null);
    }

    /**
     * Met à jour un ancien coéquipier avec un nouveau statut de contact.
     *
     * <p>Cette méthode met à jour directement une entité FormerTeammate
     * déjà chargée en mémoire en modifiant son statut de contact et
     * en sauvegardant immédiatement la modification.</p>
     *
     * <p>Cette approche est optimale quand l'entité est déjà disponible
     * et évite une requête supplémentaire de recherche en base de données.</p>
     *
     * @param formerTeammate l'ancien coéquipier à mettre à jour
     * @param newStatus le nouveau statut de contact à appliquer
     * @return l'ancien coéquipier avec le statut mis à jour et sauvegardé
     */
    @Override
    public FormerTeammate updateContactStatus(FormerTeammate formerTeammate, ContactStatus newStatus) {
        var updatedFormerTeammate = formerTeammate.withContactStatus(newStatus);
        return formerTeammateRepository.save(updatedFormerTeammate);
    }



    @Override
    public FormerTeammate updateFormerTeammate(FormerTeammate oldFormerTeammate, UpdateFormerTeammateRequest updateFormerTeammateRequest) {
        var updatedEntity = this.prepareUpdatedEntity(oldFormerTeammate, updateFormerTeammateRequest);
        return formerTeammateRepository.save(updatedEntity);
    }

    @Override
    public FormerTeammate updateFormerTeammate(FormerTeammate oldFormerTeammate, ValidateFormerTeammateRequest updateFormerTeammateRequest) {
        var updatedEntity = this.prepareUpdatedEntity(oldFormerTeammate, updateFormerTeammateRequest)
                .withContactKcUserId(updateFormerTeammateRequest.kcUserID());
        return formerTeammateRepository.save(updatedEntity);
    }


    private FormerTeammate prepareUpdatedEntity(FormerTeammate oldFormerTeammate, FormerTeammateModificationRequest updateFormerTeammateRequest) {
        if (!hasAnyFieldChanged(oldFormerTeammate, updateFormerTeammateRequest)) {
            return oldFormerTeammate;
        }


        // Le téléphone étant masqué pour l'utilisateur, s'il n'y a pas de changement, on doit reprendre le numéro non masqué existant en base de donnée.
        String newPhone = hasPhoneChanged(oldFormerTeammate, updateFormerTeammateRequest)
                ? updateFormerTeammateRequest.newPhone()
                : oldFormerTeammate.phone().map(Phone::getRawValue).orElse(null);

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
                .code(oldFormerTeammate.code())
                .build();

        // Si le nom ou le prénom ont été modifiés, on vérifie leur unicité
        boolean nameChanged = !oldFormerTeammate.firstName().equalsIgnoreCase(updatedFormerTeammate.firstName())
                || !oldFormerTeammate.lastName().equalsIgnoreCase(updatedFormerTeammate.lastName());

        //Si le nom ou le prénom ont été modifié, on vérifie leur unicité
        if(nameChanged) {
            uniquenessValidationService.validateNameUniqueness(updatedFormerTeammate.firstName(), updatedFormerTeammate.lastName());
        }
        if(hasPhoneChanged(oldFormerTeammate, updateFormerTeammateRequest)) {
            uniquenessValidationService.validatePhoneUniqueness(updatedFormerTeammate.phone().map(Phone::getRawValue).orElse(null));
        }
        return updatedFormerTeammate;
    }

    private boolean hasAnyFieldChanged(FormerTeammate old, FormerTeammateModificationRequest update) {

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
    private boolean hasPhoneChanged(FormerTeammate oldFormerTeammate, FormerTeammateModificationRequest updateRequest) {
        String newPhone = updateRequest.newPhone();
        Optional<Phone> oldPhone = oldFormerTeammate.phone();

        // Les deux sont vides/null : pas de changement
        if (newPhone == null && oldPhone.isEmpty()) {
            return false;
        }


        // L'un est présent et l'autre non : changement
        if ((newPhone == null || newPhone.isBlank()) && oldPhone.isPresent()) {
            return true;
        }

        if (!newPhone.isBlank() && oldPhone.isEmpty()) {
            return true;
        }

        //Le téléphone étant masqué pour l'utilisateur, l'envoie d'un numéro avec un astérisque signifie qu'il n'a pas été modifié.
        if (newPhone.contains("*")) {
            return false;
        }

        String oldMaskedPhoneStr = oldPhone.map(Phone::toString).orElse("");
        String oldUnmaskedPhoneStr = oldPhone.map(Phone::getRawValue).orElse("");
        // Les deux sont présents : comparer les valeurs
        return !oldMaskedPhoneStr.equals(newPhone) && !oldUnmaskedPhoneStr.equals(newPhone);
    }
}
