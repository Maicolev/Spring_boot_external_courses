package services.impl;

import data.PersonDAO;
import domain.Person;
import services.interfaces.PersonService;

import jakarta.ejb.Stateless;
import java.util.List;
import jakarta.inject.Inject;

@Stateless
public class PersonServiceImpl implements PersonService {

    @Inject
    private PersonDAO personDao;

    @Override
    public List<Person> getAllPersons() {
        return personDao.findAll();
    }

    @Override
    public Person getPersonById(Person person) {
        return personDao.findById(person);
    }

    @Override
    public void addPerson(Person person) {
         personDao.save(person);
    }

    @Override
    public void updatePerson(Person person) {
        personDao.update(person);
    }

    @Override
    public void deletePerson(Person person) {
       personDao.delete(person);
    }
}