package fr.hoenheimsports;

import fr.hoenheimsports.formerteammate.domain.annotations.DomainService;
import fr.hoenheimsports.formerteammate.domain.annotations.Stub;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

@SpringBootApplication(scanBasePackages = "fr.hoenheimsports")
@ComponentScan(basePackages = "fr.hoenheimsports",
        includeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {DomainService.class, Stub.class})}
        //excludeFilters = {@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = {FormerTeammateRepositoryStub.class})}
)
class Application {

    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);
    }


}
