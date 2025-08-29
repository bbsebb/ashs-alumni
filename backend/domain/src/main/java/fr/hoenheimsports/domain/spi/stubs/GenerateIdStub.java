package fr.hoenheimsports.domain.spi.stubs;

import fr.hoenheimsports.domain.spi.IdGenerator;

import java.util.UUID;

public class GenerateIdStub implements IdGenerator {

    @Override
    public UUID generateId() {
        return UUID.randomUUID();
    }
}
