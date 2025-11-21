package fr.hoenheimsports.app.adapters;

import fr.hoenheimsports.domain.spi.IdGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.UUID;

@Component
@Slf4j
public class GenerateId implements IdGenerator {
    @Override
    public UUID generateUUID() {
        var uuid = UUID.randomUUID();
        log.info("Generated UUID {}", uuid);
        return uuid;
    }

    @Override
    public String generateCode(int size) {
        log.info("Generating code of size {}", size);
        if (size <= 0) {
            return "";
        }

        StringBuilder code = new StringBuilder(size);
        Random random = new Random();

        for (int i = 0; i < size; i++) {
            char letter = (char) ('A' + random.nextInt(26));
            code.append(letter);
        }
        log.info("Generated code {}", code);
        return code.toString();
    }
}
