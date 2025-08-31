package fr.hoenheimsports.app.entities;

import fr.hoenheimsports.domain.models.SMSStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.util.UUID;

@Setter
@Getter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "sms_history")
public class SMSHistoryEntity {
    @Id
    @Column(nullable = false)
    private UUID id;

    @Column(name = "former_teammate_id", nullable = false)
    private UUID formerTeammateId;

    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @Column(nullable = false)
    private String message;

    @Enumerated(EnumType.ORDINAL)
    @Column(nullable = false)
    private SMSStatus status;

    @Column(name = "sent_at", nullable = false)
    private Instant sentAt;

    @Column(name = "updated_at")
    private Instant updatedAt;

    @Column(name = "external_id")
    private String externalId;

    @Column(name = "error_message")
    private String errorMessage;

    // Relation ManyToOne vers FormerTeammateEntity
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "former_teammate_id", insertable = false, updatable = false)
    private FormerTeammateEntity formerTeammate;
}
