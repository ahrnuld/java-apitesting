package nl.inholland.javaapitesting.services;

import nl.inholland.javaapitesting.models.Person;
import nl.inholland.javaapitesting.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceJpa implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public List<Person> getAll() {
        return (List<Person>) personRepository.findAll();
    }

    @Override
    public Person getById(long id) {
        return personRepository.findById(id).orElse(null);
    }

    @Override
    public Person add(Person person) {
        return personRepository.save(person);
    }

    @Override
    public Person update(Person updated, long id) {
        Person existing = getById(id);

        existing.setFirstName(updated.getFirstName());
        existing.setLastName(updated.getLastName());

        return personRepository.save(existing);
    }

    @Override
    public void delete(long id) {
        personRepository.deleteById(id);
    }
}
