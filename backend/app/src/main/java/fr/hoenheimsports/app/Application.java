package fr.hoenheimsports.app;

import fr.hoenheimsports.domain.annotations.DomainService;
import fr.hoenheimsports.domain.annotations.Stub;
import fr.hoenheimsports.domain.annotations.UseCase;
import fr.hoenheimsports.domain.spi.stubs.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

@Slf4j
@SpringBootApplication(scanBasePackages = "fr.hoenheimsports")
@ComponentScan(basePackages = {"fr.hoenheimsports.domain","fr.hoenheimsports.app"},
        includeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {DomainService.class, Stub.class, UseCase.class})},
        excludeFilters = {@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = {
                FormerTeammateRepositoryStub.class,
                GenerateIdStub.class,
                //SMSSenderStub.class,
                SMSHistoryRepositoryStub.class,
                FormerTeammateHistoryRepositoryStub.class
        })}
)
public class Application {

    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);
    }
}