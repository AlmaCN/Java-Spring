package co.exercises.swagger01.configurations;

/**
 * Come prima cosa, ho aggiunto springfox-boot-starter dependecy al pom.xml, successivamente ho modificato il file
 * application.properties ad application.yml in cui ho aggiunto spring.mvc.pathmatch.matching-strategy=ant_path_matcher.
 * Ho poi creato la classe SpringFoxConfig annotandola on Configuration ed EnableSwagger2, ed ho aggiunto il metodo
 * Docket ad esso.
 */

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Tag;
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
                        /**
                         * Ho poi creato delle new Api Info con dei dati "a caso" ed un tag riferito al controller
                         */

                        new ApiInfo("Example API", "Description for example API",
                                "1.0.0",
                                "http://localhost:8080/swagger-ui/",
                                new Contact("Alma", "https://www.linkedin.com/in/alma-caciula-negrea/", "almacaciulanegrea@gmail.com"),
                                "Licence",
                                "http://localhost:8080/swagger-ui/",
                                Collections.emptyList())
                ).tags(
                        new Tag("name-controller", "A GET for name")
                );
    }
}
