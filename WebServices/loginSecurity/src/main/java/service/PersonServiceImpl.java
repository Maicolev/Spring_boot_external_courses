package service;

import dao.PersonDao;
import domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonDao personDao;

    @Override
    @Transactional(readOnly = true)
    public List<Person> getAllPersons() {
        return (List<Person>) personDao.findAll();
    }

    @Override
    @Transactional
    public void savePerson(Person person) {
        personDao.save(person);
    }

    @Override
    @Transactional
    public void deletePerson(Person person) {
        personDao.delete(person);
    }

    @Override
    @Transactional(readOnly = true)
    public Person findPerson(Person person) {
        return personDao.findById(person.getId()).orElse(null);
    }
}
