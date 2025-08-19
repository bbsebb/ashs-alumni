package fr.hoenheimsports.formerteammate.infrastructure.services;

import fr.hoenheimsports.formerteammate.domain.spi.GenerateId;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UUIDGenerator implements GenerateId {

    @Override
    public UUID generate() {
        System.out.println("UUIDGenerator implementation is used");
        return UUID.randomUUID();
    }
}
