package fr.hoenheimsports.formerteammate.infrastructure.services;

import fr.hoenheimsports.formerteammate.domain.spi.GenerateId;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Primary
public class UUIDGenerator implements GenerateId {
    @Override
    public UUID generate() {
        return UUID.randomUUID();
    }
}
