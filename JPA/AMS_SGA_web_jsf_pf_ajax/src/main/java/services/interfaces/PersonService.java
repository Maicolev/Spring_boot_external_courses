package services.interfaces;

import domain.Person;

import jakarta.ejb.Local;
import java.util.List;

@Local
public interface PersonService {

    List<Person> getAllPersons();

    Person getPersonById(Person person);

    void addPerson(Person person);

    void updatePerson(Person person);

    void deletePerson(Person person);

}
