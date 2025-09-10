package fr.hoenheimsports.domain.spi.stubs;

import fr.hoenheimsports.domain.annotations.Stub;
import fr.hoenheimsports.domain.models.FormerTeammateHistory;
import fr.hoenheimsports.domain.spi.FormerTeammateHistoryRepository;

import java.util.ArrayList;
import java.util.List;

@Stub
public class FormerTeammateHistoryRepositoryStub implements FormerTeammateHistoryRepository {
    private final List<FormerTeammateHistory> savedHistories = new ArrayList<>();

    @Override
    public FormerTeammateHistory save(FormerTeammateHistory formerTeammateHistory) {
        if (formerTeammateHistory != null) {
            savedHistories.add(formerTeammateHistory);
        }
        return formerTeammateHistory;
    }

    // Utility method for testing purposes
    public List<FormerTeammateHistory> getAllSavedHistories() {
        return new ArrayList<>(savedHistories);
    }

    public int getCount() {
        return savedHistories.size();
    }

    public void clear() {
        savedHistories.clear();
    }
}
