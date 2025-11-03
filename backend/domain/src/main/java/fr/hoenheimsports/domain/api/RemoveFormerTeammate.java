package fr.hoenheimsports.domain.api;

import fr.hoenheimsports.domain.api.commands.ContextDetails;

import java.util.UUID;

public interface RemoveFormerTeammate {
    void removeFormerTeammate(UUID formerTeammateId, ContextDetails context);
}
