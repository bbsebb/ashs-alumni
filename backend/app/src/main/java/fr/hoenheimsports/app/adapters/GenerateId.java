package fr.hoenheimsports.app.adapters;

import fr.hoenheimsports.domain.spi.IdGenerator;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class GenerateId implements IdGenerator {
    @Override
    public UUID generateId() {
        return UUID.randomUUID();
    }
}
