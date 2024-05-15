package nl.inholland.javaapitesting.repositories;

import nl.inholland.javaapitesting.models.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {
}
