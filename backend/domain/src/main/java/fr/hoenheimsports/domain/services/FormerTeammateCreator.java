package fr.hoenheimsports.domain.services;

import fr.hoenheimsports.domain.annotations.DomainService;
import fr.hoenheimsports.domain.api.commands.ContextDetails;
import fr.hoenheimsports.domain.api.commands.FormerTeammateRegistrationRequest;
import fr.hoenheimsports.domain.exceptions.FormerTeammateAlreadyExistsException;
import fr.hoenheimsports.domain.models.ContactStatus;
import fr.hoenheimsports.domain.models.FormerTeammate;
import fr.hoenheimsports.domain.services.validations.FormerTeammateUniquenessValidationService;
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
    private final FormerTeammateUniquenessValidationService uniquenessValidationService;

    /**
     * Constructeur du service de création des anciens coéquipiers.
     * 
     * @param idGenerator générateur d'identifiants uniques pour les nouvelles entités
     * @param formerTeammateRepository dépôt pour la persistance des anciens coéquipiers
     * @param uniquenessValidationService service de validation d'unicité
     * @throws IllegalArgumentException si l'un des paramètres est null
     */
    public FormerTeammateCreator(IdGenerator idGenerator, FormerTeammateRepository formerTeammateRepository, 
                                FormerTeammateUniquenessValidationService uniquenessValidationService) {
        this.idGenerator = idGenerator;
        this.formerTeammateRepository = formerTeammateRepository;
        this.uniquenessValidationService = uniquenessValidationService;
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
    public FormerTeammate createFormerTeammate(FormerTeammateRegistrationRequest command, ContextDetails context) {
        uniquenessValidationService.validateNameUniqueness(command.firstName(), command.lastName());
        uniquenessValidationService.validatePhoneUniqueness(command.phone());

        var uuid = idGenerator.generateId();
        var initialStatus = command.phone() != null? ContactStatus.SUBMITTED : ContactStatus.UNREACHABLE;
        
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

}