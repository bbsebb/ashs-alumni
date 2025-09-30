package fr.hoenheimsports.domain.services;

import fr.hoenheimsports.domain.annotations.DomainService;
import fr.hoenheimsports.domain.models.ContactStatus;
import fr.hoenheimsports.domain.models.FormerTeammate;
import fr.hoenheimsports.domain.spi.FormerTeammateRepository;

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
