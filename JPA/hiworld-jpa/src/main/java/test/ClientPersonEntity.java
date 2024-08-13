package test;

import domain.Person;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ClientPersonEntity {
    static Logger log = LogManager.getRootLogger();

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PersonPersistence");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        Person person1 = new Person(6, "jonh", "doe", 20, "340574");
        log.debug("Object to persist:" + person1);
        entityManager.persist(person1);
        entityManager.getTransaction().commit();
        log.debug("Object persisted:" + person1);
        entityManager.close();
    }
}