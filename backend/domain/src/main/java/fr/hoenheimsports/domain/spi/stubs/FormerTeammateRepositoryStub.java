package fr.hoenheimsports.domain.spi.stubs;

import fr.hoenheimsports.domain.models.FormerTeammate;
import fr.hoenheimsports.domain.spi.FormerTeammateRepository;

import java.util.*;

public class FormerTeammateRepositoryStub implements FormerTeammateRepository {
    
    private final Map<UUID, FormerTeammate> storage = new HashMap<>();
    
    @Override
    public void save(FormerTeammate formerTeammate) {
        storage.put(formerTeammate.id(), formerTeammate);
    }

    @Override
    public List<FormerTeammate> findAll() {
        return new ArrayList<>(storage.values());
    }

    @Override
    public void deleteAll() {
        storage.clear();
    }

    @Override
    public Optional<FormerTeammate> findById(UUID id) {
        return Optional.ofNullable(storage.get(id));
    }

    @Override
    public void deleteById(UUID id) {
        storage.remove(id);
    }
}
