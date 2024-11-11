package service;


import domain.Person;

import java.util.List;

public interface PersonService {
    public List<Person> getAllPersons();

    public void savePerson(Person person);

    public void deletePerson(Person person);

    public Person findPerson(Person person);
}
