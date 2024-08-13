package services;

import domain.Person;

import javax.ejb.Local;
import java.util.List;

@Local
public interface PersonServicesLocal {

    List<Person> getAllPersons();

    Person getPersonById(int id);

    Person addPerson(Person person);

    Person updatePerson(Person person);

    void deletePerson(int id);


}
