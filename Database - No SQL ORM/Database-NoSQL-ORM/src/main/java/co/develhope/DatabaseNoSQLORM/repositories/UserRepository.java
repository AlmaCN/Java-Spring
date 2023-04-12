package co.develhope.DatabaseNoSQLORM.repositories;

import co.develhope.DatabaseNoSQLORM.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
}
