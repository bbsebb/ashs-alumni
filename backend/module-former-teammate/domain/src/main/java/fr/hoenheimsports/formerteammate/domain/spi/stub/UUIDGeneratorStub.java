package fr.hoenheimsports.formerteammate.domain.spi.stub;

import fr.hoenheimsports.formerteammate.domain.annotations.Stub;
import fr.hoenheimsports.formerteammate.domain.spi.GenerateId;

import java.util.UUID;

@Stub
public class UUIDGeneratorStub implements GenerateId {
    @Override
    public UUID generate() {
        return UUID.randomUUID();
    }
}
