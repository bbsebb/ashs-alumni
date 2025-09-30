package fr.hoenheimsports.domain.spi.stubs;

import fr.hoenheimsports.domain.models.FormerTeammate;
import fr.hoenheimsports.domain.models.FormerTeammateHistory;
import fr.hoenheimsports.domain.models.Phone;
import fr.hoenheimsports.domain.models.HistoryAction;
import fr.hoenheimsports.domain.spi.FormerTeammateRepository;

import java.util.*;
import java.util.stream.Collectors;

public class FormerTeammateRepositoryStub implements FormerTeammateRepository {
    
    private final Map<UUID, FormerTeammate> storage = new HashMap<>();
    private final FormerTeammateHistoryRepositoryStub historyStub;
    
    public FormerTeammateRepositoryStub(FormerTeammateHistoryRepositoryStub historyStub) {
        this.historyStub = historyStub;
    }
    
    public FormerTeammateRepositoryStub() {
        this.historyStub = new FormerTeammateHistoryRepositoryStub();
    }
    
    @Override
    public FormerTeammate save(FormerTeammate formerTeammate) {
        storage.put(formerTeammate.id(), formerTeammate);
        return formerTeammate;
    }

    @Override
    public List<FormerTeammate> findAll() {
        return new ArrayList<>(storage.values());
    }

    @Override
    public List<FormerTeammate> findAllNotDeleted() {
        // Get all teammate IDs that have a DELETED history action
        Set<UUID> deletedTeammateIds = historyStub.getAllSavedHistories().stream()
                .filter(history -> history.historyAction() == HistoryAction.DELETED)
                .map(FormerTeammateHistory::formerTeammateId)
                .collect(Collectors.toSet());
        
        // Return all teammates whose IDs are NOT in the deleted set
        return storage.values().stream()
                .filter(teammate -> !deletedTeammateIds.contains(teammate.id()))
                .collect(Collectors.toList());
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

    @Override
    public Optional<FormerTeammate> findByFirstNameAndLastName(String firstName, String lastName) {
        return storage.values().stream().filter(formerTeammate -> formerTeammate.firstName().equals(firstName) && formerTeammate.lastName().equals(lastName)).findFirst();
    }

    @Override
    public Optional<FormerTeammate> findByPhone(String phoneString) {
        var phone = new Phone(phoneString);
        return storage.values().stream()
                .filter(formerTeammate -> hasMatchingPhone(formerTeammate, phone))
                .findFirst();
    }

    private boolean hasMatchingPhone(FormerTeammate formerTeammate, Phone targetPhone) {
        return formerTeammate.phone()
                .map(phone -> phone.equals(targetPhone))
                .orElse(false);
    }



}
