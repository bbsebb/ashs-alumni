package fr.hoenheimsports.app.entities;

import fr.hoenheimsports.domain.models.ContactStatus;
import fr.hoenheimsports.domain.models.HistoryAction;
import fr.hoenheimsports.domain.models.Role;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Setter
@Getter
@Builder
@Entity
@Table(name = "former_teammate_history_entity")
@NoArgsConstructor
@AllArgsConstructor
public class FormerTeammateHistoryEntity {
    @Id
    @Column(name = "id", nullable = false)
    UUID id;

    @Column(name = "former_teammate_id", nullable = false)
    UUID formerTeammateId;

    @Column(name = "phone_at_time")
    String phoneAtTime;

    @Column(name = "email_at_time")
    String emailAtTime;

    @Column(name = "birth_date_at_time")
    LocalDate birthDateAtTime;

    @ElementCollection
    @CollectionTable(
            name = "former_teammate_history_entity_roles_at_time",
            joinColumns = @JoinColumn(name = "former_teammate_history_entity_id")
    )
    @Column(name = "roles_at_time")
    @Enumerated(EnumType.ORDINAL)
    List<Role> rolesAtTime;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "status_at_time", nullable = false)
    ContactStatus statusAtTime;

    @Column(name = "updated_at", nullable = false)
    LocalDate updatedAt;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "history_action", nullable = false)
    HistoryAction historyAction;

    @Column(name = "updated_by", nullable = false)
    String updatedBy;

    @Column(name = "description", nullable = false)
    String description;

    // Relation ManyToOne vers FormerTeammateEntity
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "former_teammate_id", insertable = false, updatable = false)
    private FormerTeammateEntity formerTeammate;
}

