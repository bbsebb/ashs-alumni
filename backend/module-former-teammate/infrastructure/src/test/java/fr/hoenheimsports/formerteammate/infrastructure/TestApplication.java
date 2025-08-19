package fr.hoenheimsports.formerteammate.infrastructure;

import fr.hoenheimsports.formerteammate.domain.annotations.DomainService;
import fr.hoenheimsports.formerteammate.domain.annotations.Stub;
import fr.hoenheimsports.formerteammate.domain.spi.stub.FormerTeammateRepositoryStub;
import fr.hoenheimsports.formerteammate.domain.spi.stub.UUIDGeneratorStub;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

@SpringBootApplication
@ComponentScan(basePackages = "fr.hoenheimsports",
        includeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {DomainService.class, Stub.class})},
        excludeFilters = {@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = {UUIDGeneratorStub.class, FormerTeammateRepositoryStub.class})}
)
public class TestApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestApplication.class, args);
    }
}