package fr.hoenheimsports.formerteammate.domain.spi.stub;

import fr.hoenheimsports.formerteammate.domain.annotations.Stub;
import fr.hoenheimsports.formerteammate.domain.models.ContactStatus;
import fr.hoenheimsports.formerteammate.domain.models.FormerTeammate;
import fr.hoenheimsports.formerteammate.domain.models.Gender;
import fr.hoenheimsports.formerteammate.domain.models.Role;
import fr.hoenheimsports.formerteammate.domain.spi.FormerTeammateRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Stub
public class FormerTeammateRepositoryStub implements FormerTeammateRepository {
    private final List<FormerTeammate> formerTeammates = new ArrayList<>();
    
    {
        // Initialize with coherent sample data
        formerTeammates.add(FormerTeammate.builder()
            .id(UUID.fromString("550e8400-e29b-41d4-a716-446655440001"))
            .firstName("Jean")
            .lastName("Dupont")
            .gender(Gender.M)
            .phone("06 12 34 56 78")
            .birthDate(LocalDate.of(1985, 3, 15))
            .roles(List.of(Role.PLAYER, Role.COACH))
            .status(ContactStatus.VALIDATED)
            .build());
            
        formerTeammates.add(FormerTeammate.builder()
            .id(UUID.fromString("550e8400-e29b-41d4-a716-446655440002"))
            .firstName("Marie")
            .lastName("Martin")
            .gender(Gender.F)
            .phone("06 98 76 54 32")
            .birthDate(LocalDate.of(1990, 7, 22))
            .roles(List.of(Role.PRESIDENT))
            .status(ContactStatus.PENDING)
            .build());
            
        formerTeammates.add(FormerTeammate.builder()
            .id(UUID.fromString("550e8400-e29b-41d4-a716-446655440003"))
            .firstName("Pierre")
            .lastName("Leroy")
            .gender(Gender.M)
            .birthDate(LocalDate.of(1978, 11, 8))
            .roles(List.of(Role.ASSISTANT, Role.PLAYER))
            .status(ContactStatus.SUBMITTED)
            .build());
            
        formerTeammates.add(FormerTeammate.builder()
            .id(UUID.fromString("550e8400-e29b-41d4-a716-446655440004"))
            .firstName("Sophie")
            .lastName("Dubois")
            .gender(Gender.F)
            .phone("07 11 22 33 44")
            .birthDate(LocalDate.of(1992, 5, 12))
            .roles(List.of(Role.PLAYER))
            .status(ContactStatus.NOT_REQUESTED)
            .build());
            
        formerTeammates.add(FormerTeammate.builder()
            .id(UUID.fromString("550e8400-e29b-41d4-a716-446655440005"))
            .firstName("Michel")
            .lastName("Bernard")
            .gender(Gender.M)
            .phone("06 55 77 88 99")
            .birthDate(LocalDate.of(1972, 1, 30))
            .roles(List.of(Role.COACH))
            .status(ContactStatus.UNREACHABLE)
            .build());
    }

    @Override
    public void save(FormerTeammate formerTeammate) {
        formerTeammates.add(formerTeammate);
    }

    @Override
    public List<FormerTeammate> findAll() {
        return new ArrayList<>(formerTeammates);
    }

    // For test purpose
    public List<FormerTeammate> getSavedEntities() {
        return formerTeammates;
    }

    public void clear() {
        formerTeammates.clear();
    }


}
