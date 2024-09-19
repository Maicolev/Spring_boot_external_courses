package services.impl;

import data.PersonDAO;
import domain.Person;
import jakarta.jws.WebService;
import services.interfaces.PersonService;

import jakarta.ejb.Stateless;
import java.util.List;
import jakarta.inject.Inject;
import services.interfaces.PersonServiceWs;

import jakarta.annotation.security.DeclareRoles;
import jakarta.annotation.security.RolesAllowed;

@Stateless
@WebService (endpointInterface = "services.interfaces.PersonServiceWs")
@DeclareRoles({"ROLE_ADMIN","ROLE_USER"})
@RolesAllowed({"ROLE_ADMIN","ROLE_USER"})
public class PersonServiceImpl implements PersonService, PersonServiceWs {

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
    @RolesAllowed("ROLE_ADMIN")
    public void deletePerson(Person person) {
       personDao.delete(person);
    }
}