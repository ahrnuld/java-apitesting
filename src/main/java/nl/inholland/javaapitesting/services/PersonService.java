package nl.inholland.javaapitesting.services;

import nl.inholland.javaapitesting.models.Person;

import java.util.List;

public interface PersonService {
    List<Person> getAll();

    Person getById(long id);

    Person add(Person person);

    Person update(Person person, long id);

    void delete(long id);
}
