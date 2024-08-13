package services.interfaces;

import domain.Person;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface PersonServicesRemote {

    public List<Person> getAllPersons();

    public Person getPersonById(int id);

    public Person addPerson(Person person);

    public Person updatePerson(Person person);

    public void deletePerson(int id);

}
