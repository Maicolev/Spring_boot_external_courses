import domain.Person;
import services.interfaces.PersonServicesRemote;

import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class PersonServiceImpl implements PersonServicesRemote {

    @Override
    public List<Person> getAllPersons() {

        Person p1 = new Person(1,"Rosa", "Petalo", 18, "Columbia", 123456);
        Person p2 = new Person(2,"Melba", "Del carmen", 18, "EEUU", 123456);
        Person p3 = new Person(3,"Jorgina", "Jose", 18, "APM", 123456);
        Person p4 = new Person(4,"Candela", "Cristina", 18, "Rost", 123456);
        Person p5 = new Person(5,"Petalo", "Danny", 18, "Nueva Zelanda", 123456);
        Person p6 = new Person(6,"Sandra", "Josh", 18, "NY", 123456);

        List <Person> list= new ArrayList<>();
        list.add(p1);
        list.add(p2);
        list.add(p3);
        list.add(p4);
        list.add(p5);
        list.add(p6);

        return list;
    }

    @Override
    public Person getPersonById(int id) {
        return null;
    }

    @Override
    public Person addPerson(Person person) {
        return null;
    }

    @Override
    public Person updatePerson(Person person) {
        return null;
    }

    @Override
    public void deletePerson(int id) {
    }
}