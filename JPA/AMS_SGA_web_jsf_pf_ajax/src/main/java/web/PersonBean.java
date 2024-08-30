package web;

import java.util.List;

import domain.Person;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.primefaces.event.RowEditEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import services.interfaces.PersonService;


@Named("personBean")
@RequestScoped
public class PersonBean {
    private static Logger logger = LoggerFactory.getLogger(PersonBean.class);

    @Inject
    private PersonService personService;

    private Person personSelected;

    List<Person> people;

    public PersonBean() {
        logger.info("PersonBean()");
    }
    @PostConstruct
    public void initialize(){
        logger.info("initialize() - logger");
        this.people = personService.getAllPersons();
        this.personSelected = new Person();
    }

    public void editListener(RowEditEvent event) {
        logger.info("editListener() - logger");
        Person person = (Person) event.getObject();
        personService.updatePerson(person);
    }

    public Person getPersonSelected () {logger.info("getPersonSelected() - logger");return personSelected;}

    public void setPersonSelected(Person personSelected){
        this.personSelected = personSelected;
    }

    public List<Person> getPeople() {
        return people;
    }

    public void setPeople(List<Person> people) {
        this.people = people;
    }

    public void addPerson(){
        logger.info("addPerson() - logger");
        this.personService.addPerson(personSelected);
        this.people.add(personSelected);
        this.personSelected = null;
    }

    public void removePerson(){
        logger.info("removePerson() - logger");
        this.personService.deletePerson(personSelected);
        this.people.remove(this.personSelected);
        this.personSelected = null;
    }

    public void restartPersonSelected(){
        this.personSelected = new Person();
    }


}
