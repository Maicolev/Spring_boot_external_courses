package data;

import domain.Person;

import java.util.List;

public interface PersonDAO {
    public List<Person> findAll();

    public Person findById(Person person);

    Person findPersonByEmail(Person person);

    public void save(Person person);

    public void delete(Person person);

    public void update(Person person);

}
