package fr.hoenheimsports.domain.spi.stubs;

import fr.hoenheimsports.domain.spi.IdGenerator;

import java.util.UUID;

public class GenerateIdStub implements IdGenerator {

    @Override
    public UUID generateUUID() {
        return UUID.randomUUID();
    }

    @Override
    public String generateCode(int size) {
        return "AAAAAA";
    }
}
