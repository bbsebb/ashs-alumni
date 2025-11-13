package fr.hoenheimsports.app.entities;

import fr.hoenheimsports.domain.models.ContactStatus;
import fr.hoenheimsports.domain.models.Gender;
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
@NoArgsConstructor
@AllArgsConstructor
public class FormerTeammateEntity {
    @Id
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "first_name", nullable = false)
    String firstName;

    @Column(name = "last_name", nullable = false)
    String lastName;

    @Column(name = "gender")
    @Enumerated(EnumType.ORDINAL)
    Gender gender;

    @Column(name = "phone")
    String phone;

    @Column(name = "email")
    String email;

    @Column(name = "birth_date")
    LocalDate birthDate;

    @ElementCollection
    @CollectionTable(name = "former_teammate_entity_roles", joinColumns = @JoinColumn(name = "former_teammate_entity_id"))
    @Column(name = "roles")
    @Enumerated(EnumType.ORDINAL)
    List<Role> roles;

    @Column(name = "status")
    @Enumerated(EnumType.ORDINAL)
    ContactStatus status;

    @Column(name = "code", nullable = false, unique = true)
    String code;


    @OneToMany(mappedBy = "formerTeammate", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<SMSHistoryEntity> smsHistory;

    @OneToMany(mappedBy = "formerTeammate", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<FormerTeammateHistoryEntity> formerTeammateHistory;


}
