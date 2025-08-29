package fr.hoenheimsports.domain.spi;

import java.util.UUID;


public interface IdGenerator {
    UUID generateId();
}
