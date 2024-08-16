package test;

import domain.Person;
import domain.User;
import jakarta.persistence.*;

import java.util.List;

public class testMain {
    public static void main(String[] args) {
        System.out.println("Hello World");

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersonPersistence");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

       //Person person = findPerson(em, et, 7);
       //Person person = createPerson(em, et, 7);
       //Person person = removePerson(em, et, 89);
       //Person person = updatePerson(em, et, 7);
       //lazyAndEagerAnotations(em);
        Person person = CascadePersist(em, et, 89);
        em.close();

       System.out.println(person.getFirstname() + " " + person.getLastname());

    }

    static Person findPerson(EntityManager em, EntityTransaction et, int id){
        et.begin();
        Person person = em.find(Person.class, Long.parseLong(String.valueOf(id)));
        et.commit();
        return person;
    }

    static Person createPerson(EntityManager em, EntityTransaction et, int id){
        et.begin();
        Person person = new Person(Long.parseLong(String.valueOf(id)),Long.parseLong("76"),"Jhon2", "Urrutia", "34534", "email@email.com");
        em.persist(person);
        et.commit();

        return person;
    }

    static Person removePerson(EntityManager em, EntityTransaction et, int id){
        Person person = findPerson(em, et, id);
        EntityTransaction et2 = em.getTransaction();
        et2.begin();
        em.remove(em.merge(person));
        et2.commit();
        return person;
    }

    static Person updatePerson(EntityManager em, EntityTransaction et, int id){
        Person person = findPerson(em, et, id);
        person.setEmail("emailedit@email.com");
        EntityTransaction et2 = em.getTransaction();
        et2.begin();
        em.merge(person);
        et2.commit();
        return person;
    }

    static void lazyAndEagerAnotations(EntityManager em){
        List<Person> people = em.createNamedQuery("Person.findAll").getResultList();
        for (Person person : people) {
            System.out.println(person.getFirstname() + " " + person.getLastname());
            for (User user : person.getUsers()){
                System.out.println(user.getUsername());
            }
        }
    }

    static Person CascadePersist (EntityManager em, EntityTransaction et, int id){

        et.begin();
        Person person = new Person(Long.parseLong(String.valueOf(id)), Long.parseLong("67"), "Martha", "Zul", "77777", "email2@email.com" );
        User user = new User(Long.parseLong("78"), person,"userMartha", "1234");

        em.persist(user);
        et.commit();

        return person;
    }



}
