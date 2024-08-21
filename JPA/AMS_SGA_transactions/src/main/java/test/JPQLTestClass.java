package test;

import java.util.Iterator;
import java.util.List;

import domain.Person;
import domain.User;
import jakarta.persistence.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JPQLTestClass {
    private static Logger logger = LoggerFactory.getLogger(JPQLTestClass.class);

    public static void main (String[] args) {

        String jpql = null;
        Query query = null;
        List<Person> people = null;
        Person person = null;
        Iterator iterator = null;
        Object[] registry = null;
        List<String> names = null;
        List<User> users = null;

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersonPersistence");
        EntityManager em = emf.createEntityManager();

        //1. Select all objects to person type
        logger.info("\n1. Select all objects to person type");
        jpql = "select p from Person p";
        people = em.createQuery(jpql).getResultList();
        //showPeople( people );

        //2. Select to person with id = 66
        logger.info("\nSelect to person with id = 66");
        jpql = "select p from Person p where p.id = 66";
        person = (Person) em.createQuery(jpql).getSingleResult();
        //logger.info("Person con id 1: " + person);

        //3. Select to person for firstname
        logger.info("\n3. Select to person for firstname");
        jpql = "select p from Person p where p.firstname = 'Jhon'";
        people = em.createQuery(jpql).getResultList();
        //showPeople(people);

        //4. Select to individual data, array (registry) is add to object type for three columns
        logger.info("\n4. Select to individual data, array (registry) is add to object type for three columns");
        jpql = "select p.firstname as Firstname, p.lastname as Lastname, p.email as Email from Person p";
        iterator = em.createQuery(jpql).getResultList().iterator();
        while(iterator.hasNext()){
            registry = (Object[]) iterator.next();
            String firstname = (String) registry[0];
            String lastname = (String) registry[1];
            String email = (String) registry[2];
            //logger.info("firstname:" + firstname + ", lastname:" + lastname + ", email:" + email) ;
        }

        //5. Get person object and id, array is create to object type with two columns
        logger.info("\n5. Get person object and id, array is create to object type with two columns");
        jpql = "select p, p.id from Person p";
        iterator = em.createQuery(jpql).getResultList().iterator();
        while(iterator.hasNext()){
            registry = (Object[]) iterator.next();
            person = (Person) registry[0];
            Long id = (Long) registry[1];
            logger.info("Person object:" + person);
            logger.info("id person:" + registry[1] );
        }

        //6. Select to all people
        System.out.println("\n6. Select to all people");
        jpql = "select new domain.Person( p.id ) from Person p";
        people = em.createQuery(jpql).getResultList();
        //showPeople(people);

        //7. Select minimun and maximun id
        System.out.println("\n7. Select minimun and maximun id)");
        jpql = "select min(p.id) as MinId, max(p.id) as MaxId, count(p.id) as Contador from Person p";
        iterator = em.createQuery(jpql).getResultList().iterator();
        while(iterator.hasNext()){
            registry = (Object[]) iterator.next();
            Long idMin = (Long) registry[0];
            Long idMax = (Long) registry[1];
            Long count = (Long) registry[2];
            //logger.info("idMin:" + idMin + ", idMax:" + idMax + ", count:" + count);
        }

        //8. Select differnt first names
        logger.info("\n8. Select differnt first names");
        jpql = "select count(distinct p.firstname) from Person p";
        Long contador = (Long) em.createQuery(jpql).getSingleResult();
        //logger.info("no. de people con firstname distinto:" + contador);

        //9. Concat and convert complete name to uppercase
        logger.info("\n9. Concat and convert complete name to uppercase");
        jpql = "select CONCAT(p.firstname, ' ', p.lastname) as Firstname from Person p";
        names = em.createQuery(jpql).getResultList();
        for(String fullname: names){
            //logger.info(fullname);
        }

        //10. Get person object with equals id to parameter
        logger.info("\n10. Get person object with equals id to parameter");
        int id = 66;
        jpql = "select p from Person p where p.id = :id";
        query = em.createQuery(jpql);
        query.setParameter("id", id);
        person = (Person) query.getSingleResult();
        //logger.info("Person:" + person);

        //11. Get people to contain the letter a in the first name, regardless of whether it is uppercase or lowercase
        logger.info("\n11. Get people to contain the letter a in the first name, regardless of whether it is uppercase or lowercase");
        jpql = "select p from Person p where upper(p.firstname) like upper(:parametro)";
        String parametroString = "%a%";//es el caracter que utilizamos para el like
        query = em.createQuery(jpql);
        query.setParameter("parametro", parametroString);
        people = query.getResultList();
        //showPeople(people);

        //12. between use
        logger.info("\n12. between use");
        jpql = "select p from Person p where p.id between 1 and 10";
        people = em.createQuery(jpql).getResultList();
        //showPeople(people);

        //13. order by use
        logger.info("\n13. order by use");
        jpql = "select p from Person p where p.id > 1 order by p.firstname desc, p.lastname desc";
        people = em.createQuery(jpql).getResultList();
        //showPeople(people);

        //14. subquery use
        logger.info("\n14. subquery use");
        jpql = "select p from Person p where p.id in (select min(p1.id) from Person p1)";
        people = em.createQuery(jpql).getResultList();
        //showPeople(people);

        //15.join use with lazy loading
        logger.info("\n15.join use with lazy loading");
        jpql = "select u from User u join u.person p";
        users = em.createQuery(jpql).getResultList();
        //showUsers(users);

        //16.left join use with eager loading
        logger.info("16.left join use with eager loading");
        jpql = "select u from User u left join fetch u.person";
        users = em.createQuery(jpql).getResultList();
        showUsers(users);
    }


    private static void showPeople(List<Person> people) {
        for(Person p: people){
            logger.info("People: " + p);
        }
    }

    private static void showUsers(List<User> users) {
        for(User u: users){
            logger.info("Usuario: " + u);
        }
    }
}
