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
    @Column(nullable = false)
    private UUID id;

    @Column(nullable = false)
    String firstName;
    @Column(nullable = false)
    String lastName;
    Gender gender;
    String phone;
    String email;
    LocalDate birthDate;
    @ElementCollection
    @Enumerated(EnumType.ORDINAL)
    List<Role> roles;
    ContactStatus status;

    @OneToMany(mappedBy = "formerTeammate", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<SMSHistoryEntity> smsHistory;

}
