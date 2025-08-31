package fr.hoenheimsports.app;

import fr.hoenheimsports.domain.annotations.DomainService;
import fr.hoenheimsports.domain.annotations.Stub;
import fr.hoenheimsports.domain.spi.stubs.FormerTeammateRepositoryStub;
import fr.hoenheimsports.domain.spi.stubs.GenerateIdStub;
import fr.hoenheimsports.domain.spi.stubs.SMSSenderStub;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

@SpringBootApplication(scanBasePackages = "fr.hoenheimsports")
@ComponentScan(basePackages = {"fr.hoenheimsports.domain","fr.hoenheimsports.app"},
        includeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {DomainService.class, Stub.class})},
        excludeFilters = {@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = {FormerTeammateRepositoryStub.class, GenerateIdStub.class})}
)
public class Application {

    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);
    }
}