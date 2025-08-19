package fr.hoenheimsports.formerteammate.infrastructure.entity;

import fr.hoenheimsports.formerteammate.domain.models.ContactStatus;
import fr.hoenheimsports.formerteammate.domain.models.Gender;
import fr.hoenheimsports.formerteammate.domain.models.Role;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
    LocalDate birthDate;
    List<Role> roles;
    ContactStatus status;
}
