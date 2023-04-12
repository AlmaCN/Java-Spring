package co.develhope.APISpring.Repositories2.repositories;

import co.develhope.APISpring.Repositories2.entities.ProgrammingLanguage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.Description;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

/**
 * Ho poi creato l'interfaccia ProgrammingLanguageRepository annotandola con RepositoryRestResourse in cui ho
 * specificato un path in cui e accessibile l'informazione, ed una breve descrizione.
 */
@RepositoryRestResource(path = "repo-prog-languages", collectionResourceDescription = @Description("Repository of programming languages"))
public interface ProgrammingLanguageRepository extends JpaRepository<ProgrammingLanguage, Integer> {
}
