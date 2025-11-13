package fr.hoenheimsports.domain.services.validations;

import fr.hoenheimsports.domain.annotations.DomainService;
import fr.hoenheimsports.domain.exceptions.FormerTeammateAlreadyExistsException;
import fr.hoenheimsports.domain.models.Phone;
import fr.hoenheimsports.domain.spi.FormerTeammateRepository;

/**
 * Service de validation de l'unicité des anciens coéquipiers.
 * Centralise la logique de validation d'unicité pour éviter les doublons.
 */
@DomainService
public class FormerTeammateUniquenessValidationService {

    private final FormerTeammateRepository formerTeammateRepository;

    /**
     * Constructeur du service de validation d'unicité.
     * 
     * @param formerTeammateRepository dépôt pour la persistance des anciens coéquipiers
     * @throws IllegalArgumentException si le paramètre est null
     */
    public FormerTeammateUniquenessValidationService(FormerTeammateRepository formerTeammateRepository) {
        this.formerTeammateRepository = formerTeammateRepository;
    }

    /**
     * Valide qu'aucun ancien coéquipier n'existe déjà avec le nom et prénom spécifiés.
     *
     * @param firstName le prénom à vérifier
     * @param lastName le nom à vérifier
     * @throws FormerTeammateAlreadyExistsException si un contact existe déjà avec ces nom et prénom
     */
    public void validateNameUniqueness(String firstName, String lastName) {
        formerTeammateRepository.findByFirstNameIgnoreCaseAndLastNameIgnoreCase(firstName, lastName).ifPresent(formerTeammate -> {
            throw new FormerTeammateAlreadyExistsException(
                    "Le contact existe déjà avec le nom et prénom suivant :  %s %s".formatted(formerTeammate.firstName().toUpperCase(),formerTeammate.lastName().toUpperCase())
            );
        });
    }

    /**
     * Valide qu'aucun ancien coéquipier n'existe déjà avec le numéro de téléphone spécifié.
     *
     * @param phone le numéro de téléphone à vérifier
     * @throws FormerTeammateAlreadyExistsException si un contact existe déjà avec ce numéro
     */
    public void validatePhoneUniqueness(String phone) {
        // Skip validation if phone is null or empty since it's optional
        if (phone == null || phone.trim().isEmpty()) {
            return;
        }
        
        formerTeammateRepository.findByPhone(phone).ifPresent(formerTeammate -> {
            String phoneDisplay = formerTeammate.phone()
                    .map(Phone::toString)
                    .orElse(phone);
            throw new FormerTeammateAlreadyExistsException(
                    "Le contact existe déjà avec le numéro de téléphone : %s".formatted(phoneDisplay)
            );
        });
    }
}