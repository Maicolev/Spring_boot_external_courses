package test;

import domain.Person;
import jakarta.persistence.*;

public class testMain {
    public static void main(String[] args) {
        System.out.println("Hello World");

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersonPersistence");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

       //Person person = findPerson(em, et, 7);
       //Person person = createPerson(em, et, 7);
       //Person person = removePerson(em, et, 7);
        Person person = updatePerson(em, et, 7);

        em.close();

       System.out.println(person.getFirstname() + " " + person.getLastname());

    }

    static Person findPerson(EntityManager em, EntityTransaction et, int id){
        et.begin();
        Person person = em.find(Person.class, Long.parseLong("7"));
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
}
