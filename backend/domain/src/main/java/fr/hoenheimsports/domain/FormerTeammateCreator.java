package fr.hoenheimsports.domain;

import fr.hoenheimsports.domain.annotations.DomainService;
import fr.hoenheimsports.domain.api.CreateFormerTeammate;
import fr.hoenheimsports.domain.api.commands.ContextCommand;
import fr.hoenheimsports.domain.api.commands.FormerTeammateRegistrationCommand;
import fr.hoenheimsports.domain.exceptions.FormerTeammateAlreadyExistsException;
import fr.hoenheimsports.domain.models.ContactStatus;
import fr.hoenheimsports.domain.models.FormerTeammate;
import fr.hoenheimsports.domain.models.Phone;
import fr.hoenheimsports.domain.spi.FormerTeammateRepository;
import fr.hoenheimsports.domain.spi.IdGenerator;

/**
 * Service de domaine responsable de la création des anciens coéquipiers.
 * 
 * <p>Ce service implémente l'API {@link CreateFormerTeammate} et se concentre
 * uniquement sur la création initiale d'un FormerTeammate avec le statut SUBMITTED.
 * Il effectue toutes les validations nécessaires avant la création :</p>
 * 
 * <ul>
 *   <li><strong>Unicité du nom/prénom :</strong> Vérifie qu'aucun contact n'existe déjà avec ces informations</li>
 *   <li><strong>Unicité du téléphone :</strong> Vérifie qu'aucun contact n'utilise déjà ce numéro</li>
 *   <li><strong>Génération d'ID :</strong> Génère un identifiant unique pour la nouvelle entité</li>
 * </ul>
 * 
 * <p>Cette classe suit le principe de responsabilité unique en se concentrant
 * exclusivement sur la création, laissant la gestion de l'historique et des
 * mises à jour à d'autres services spécialisés.</p>
 * 
 * @author ASHS Alumni System
 * @since 1.0
 * @see CreateFormerTeammate
 * @see FormerTeammate
 */
@DomainService
public class FormerTeammateCreator implements CreateFormerTeammate {
    
    private final IdGenerator idGenerator;
    private final FormerTeammateRepository formerTeammateRepository;

    /**
     * Constructeur du service de création des anciens coéquipiers.
     * 
     * @param idGenerator générateur d'identifiants uniques pour les nouvelles entités
     * @param formerTeammateRepository dépôt pour la persistance des anciens coéquipiers
     * @throws IllegalArgumentException si l'un des paramètres est null
     */
    public FormerTeammateCreator(IdGenerator idGenerator, FormerTeammateRepository formerTeammateRepository) {
        this.idGenerator = idGenerator;
        this.formerTeammateRepository = formerTeammateRepository;
    }

    /**
     * Crée un nouvel ancien coéquipier avec le statut initial SUBMITTED.
     *
     * <p>Cette méthode effectue les étapes suivantes :</p>
     * <ol>
     *   <li>Validation de l'unicité du nom et prénom</li>
     *   <li>Validation de l'unicité du numéro de téléphone</li>
     *   <li>Génération d'un identifiant unique</li>
     *   <li>Construction de l'entité FormerTeammate</li>
     *   <li>Persistance en base de données</li>
     * </ol>
     *
     * @param command les données de l'ancien coéquipier à créer
     * @param context le contexte d'exécution contenant l'utilisateur courant
     * @return l'ancien coéquipier créé et sauvegardé
     * @throws fr.hoenheimsports.domain.exceptions.MissingRequiredFieldException si des champs obligatoires sont manquants
     * @throws fr.hoenheimsports.domain.exceptions.InvalidPhoneNumberException si le format du téléphone est invalide
     * @throws FormerTeammateAlreadyExistsException si le contact existe déjà
     */
    @Override
    public FormerTeammate createFormerTeammate(FormerTeammateRegistrationCommand command, ContextCommand context) {
        validateNameUniqueness(command.firstName(), command.lastName());
        validatePhoneUniqueness(command.phone());
        
        var uuid = idGenerator.generateId();
        var initialStatus = ContactStatus.SUBMITTED;
        
        // Création de l'entité
        var formerTeammate = FormerTeammate.builder()
                .id(uuid)
                .gender(command.gender())
                .firstName(command.firstName())
                .lastName(command.lastName())
                .phone(command.phone())
                .email(command.email())
                .birthDate(command.birthDate())
                .roles(command.roles())
                .status(initialStatus)
                .build();

        return formerTeammateRepository.save(formerTeammate);
    }

    /**
     * Valide qu'aucun ancien coéquipier n'existe déjà avec le nom et prénom spécifiés.
     *
     * @param firstName le prénom à vérifier
     * @param lastName le nom à vérifier
     * @throws FormerTeammateAlreadyExistsException si un contact existe déjà avec ces nom et prénom
     */
    private void validateNameUniqueness(String firstName, String lastName) {
        formerTeammateRepository.findByFirstNameAndLastName(firstName, lastName).ifPresent(formerTeammate -> {
            throw new FormerTeammateAlreadyExistsException(
                    "Le contact existe déjà; id: %s".formatted(formerTeammate.id())
            );
        });
    }

    /**
     * Valide qu'aucun ancien coéquipier n'existe déjà avec le numéro de téléphone spécifié.
     *
     * @param phone le numéro de téléphone à vérifier
     * @throws FormerTeammateAlreadyExistsException si un contact existe déjà avec ce numéro
     */
    private void validatePhoneUniqueness(String phone) {
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