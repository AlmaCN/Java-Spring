package co.exercises.swagger02.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class SpringFoxConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build().apiInfo(
                        new ApiInfo("Math API",
                                "An API about divisions",
                                "1.0.0",
                                "https://en.wikipedia.org/wiki/Division_(mathematics)",
                                new Contact("Alma",
                                        "http://linkedin.it",
                                        "almacaciulanegrea@gmail.com"),
                                "Division",
                                "https://en.wikipedia.org/wiki/Division_(mathematics)",
                                Collections.emptyList())
                );
    }
}
