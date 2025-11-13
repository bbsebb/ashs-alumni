package fr.hoenheimsports.app.adapters;

import fr.hoenheimsports.domain.spi.IdGenerator;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.UUID;

@Component
public class GenerateId implements IdGenerator {
    @Override
    public UUID generateUUID() {
        return UUID.randomUUID();
    }

    @Override
    public String generateCode(int size) {
        if (size <= 0) {
            return "";
        }

        StringBuilder code = new StringBuilder(size);
        Random random = new Random();

        for (int i = 0; i < size; i++) {
            char letter = (char) ('A' + random.nextInt(26));
            code.append(letter);
        }

        return code.toString();
    }
}
