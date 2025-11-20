package fr.hoenheimsports.app.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.UUID;

@Setter
@Getter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "uk_participant_first_last_name",
                        columnNames = {"firstName", "lastName"}
                )
        }
)
public class Participant {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotBlank
    @Column(nullable = false)
    String firstname;
    @NotBlank
    @Column(nullable = false)
    String lastname;
    @Email
    @NotBlank
    @Column(nullable = false)
    String email;
    String comments;
    @Column(nullable = false, unique = true)
    UUID kcId;
    Boolean hasVegetarianOption;
}
