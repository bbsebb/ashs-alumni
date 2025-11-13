package fr.hoenheimsports.domain.spi;

import java.util.UUID;


public interface IdGenerator {
    UUID generateUUID();
    String generateCode(int size);
}
