package data;

import domain.Person;

import jakarta.ejb.Stateless;
import jakarta.persistence.*;
import java.util.List;

@Stateless
public class PersonDAOImpl implements PersonDAO {
    @PersistenceContext(unitName = "PersonPersistence")
    EntityManager em;

    @Override
    public List<Person> findAll() {
        return em.createNamedQuery("Person.findAll", Person.class).getResultList();
    }

    @Override
    public Person findById(Person person) {
        return em.find(Person.class, person.getId());
    }

    @Override
    public Person findPersonByEmail(Person person) {
        Query query = em.createQuery(
                "from Person p where p.email =: email"
        );
        query.setParameter("email", person.getEmail());

        return (Person) query.getSingleResult();
    }

    @Override
    public void save(Person person) {
        em.persist(person);
    }

    @Override
    public void delete(Person person) {
        em.remove(em.merge(person));
    }

    @Override
    public void update(Person person) {em.merge(person);
    }
}
