package fr.hoenheimsports.domain;

import fr.hoenheimsports.domain.annotations.DomainService;
import fr.hoenheimsports.domain.api.UpdateFormerTeammate;
import fr.hoenheimsports.domain.models.ContactStatus;
import fr.hoenheimsports.domain.models.FormerTeammate;
import fr.hoenheimsports.domain.spi.FormerTeammateRepository;

import java.util.UUID;

/**
 * Service de domaine responsable de la mise à jour des anciens coéquipiers.
 * 
 * <p>Ce service implémente l'API {@link UpdateFormerTeammate} et se concentre
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
 * @see UpdateFormerTeammate
 * @see FormerTeammate
 * @see ContactStatus
 */
@DomainService
public class FormerTeammateUpdater implements UpdateFormerTeammate {
    
    private final FormerTeammateRepository formerTeammateRepository;

    /**
     * Constructeur du service de mise à jour des anciens coéquipiers.
     * 
     * @param formerTeammateRepository dépôt pour la persistance des anciens coéquipiers
     * @throws IllegalArgumentException si le paramètre est null
     */
    public FormerTeammateUpdater(FormerTeammateRepository formerTeammateRepository) {
        this.formerTeammateRepository = formerTeammateRepository;
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
}