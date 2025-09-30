import fr.hoenheimsports.domain.models.*;
import fr.hoenheimsports.domain.spi.stubs.*;
import java.util.*;
import java.time.LocalDate;

public class TestFindAllNotDeleted {
    public static void main(String[] args) {
        // Create history stub and repository stub
        FormerTeammateHistoryRepositoryStub historyStub = new FormerTeammateHistoryRepositoryStub();
        FormerTeammateRepositoryStub repoStub = new FormerTeammateRepositoryStub(historyStub);
        
        // Create some test teammates
        UUID id1 = UUID.randomUUID();
        UUID id2 = UUID.randomUUID();
        UUID id3 = UUID.randomUUID();
        
        FormerTeammate teammate1 = FormerTeammate.builder()
                .id(id1)
                .firstName("John")
                .lastName("Doe")
                .gender(Gender.MALE)
                .status(ContactStatus.VALIDATED)
                .build();
        
        FormerTeammate teammate2 = FormerTeammate.builder()
                .id(id2)
                .firstName("Jane")
                .lastName("Smith")
                .gender(Gender.FEMALE)
                .status(ContactStatus.PENDING)
                .build();
        
        FormerTeammate teammate3 = FormerTeammate.builder()
                .id(id3)
                .firstName("Bob")
                .lastName("Wilson")
                .gender(Gender.MALE)
                .status(ContactStatus.NOT_REQUESTED)
                .build();
        
        // Save teammates
        repoStub.save(teammate1);
        repoStub.save(teammate2);
        repoStub.save(teammate3);
        
        // Verify all teammates are initially returned
        System.out.println("All teammates count: " + repoStub.findAll().size());
        System.out.println("Non-deleted teammates count: " + repoStub.findAllNotDeleted().size());
        
        // Create deletion history for teammate2
        FormerTeammateHistory deletionHistory = FormerTeammateHistory.builder()
                .id(UUID.randomUUID())
                .formerTeammateId(id2)
                .statusAtTime(ContactStatus.PENDING)
                .updatedAt(LocalDate.now())
                .historyAction(HistoryAction.DELETED)
                .updatedBy("test")
                .description("Test deletion")
                .build();
        
        historyStub.save(deletionHistory);
        
        // Verify that only 2 teammates are returned (excluding the deleted one)
        System.out.println("After deletion - All teammates count: " + repoStub.findAll().size());
        System.out.println("After deletion - Non-deleted teammates count: " + repoStub.findAllNotDeleted().size());
        
        // Print names of non-deleted teammates
        repoStub.findAllNotDeleted().forEach(teammate -> 
            System.out.println("Non-deleted: " + teammate.firstName() + " " + teammate.lastName())
        );
        
        System.out.println("Test completed successfully!");
    }
}