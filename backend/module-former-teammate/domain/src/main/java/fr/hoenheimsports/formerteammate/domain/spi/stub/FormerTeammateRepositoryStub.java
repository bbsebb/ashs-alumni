package fr.hoenheimsports.formerteammate.domain.spi.stub;

import fr.hoenheimsports.formerteammate.domain.annotations.Stub;
import fr.hoenheimsports.formerteammate.domain.models.FormerTeammate;
import fr.hoenheimsports.formerteammate.domain.spi.FormerTeammateRepository;

import java.util.ArrayList;
import java.util.List;

@Stub
public class FormerTeammateRepositoryStub implements FormerTeammateRepository {
    List<FormerTeammate> formerTeammates = new ArrayList<>();

    @Override
    public void save(FormerTeammate formerTeammate) {
        formerTeammates.add(formerTeammate);
    }

    // For test purpose
    public List<FormerTeammate> getSavedEntities() {
        return formerTeammates;
    }
}
