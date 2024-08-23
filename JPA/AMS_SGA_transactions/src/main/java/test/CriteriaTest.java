package test;

import java.util.List;
import java.util.ArrayList;

import commons.Commons;
import domain.Person;
import jakarta.persistence.*;
import jakarta.persistence.criteria.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class CriteriaTest {

    private static Logger logger = LoggerFactory.getLogger(CriteriaTest.class);

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PersonPersistence");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        CriteriaBuilder criteriaBuilder = null;
        CriteriaQuery <Person> criteriaQuery = null;
        Root<Person> personRoot = null;
        TypedQuery <Person> personTypedQuery = null;
        Person person = null;
        List<Person> people = null;

        // Query used in criteria
        // 1. Select for all persons

        //Step 1. The entity manager object create criteriaBuilder instance
        criteriaBuilder = entityManager.getCriteriaBuilder();

        //Step 2. Create criteriaQuery object
        criteriaQuery = criteriaBuilder.createQuery(Person.class);

        //Step 3. Create the root object to query
        personRoot = criteriaQuery.from(Person.class);

        //Step 4. Included select to root
        criteriaQuery.select(personRoot);

        //Step 5. Create the typseSafe query
        personTypedQuery = entityManager.createQuery(criteriaQuery);

        //Step 6. Execute select
        people = personTypedQuery.getResultList();
        Commons.showPeople(people, logger);

        // 2. Select person with id = 66
        logger.info("\n 2. Select person with id = 66");
        criteriaBuilder = entityManager.getCriteriaBuilder();
        criteriaQuery = criteriaBuilder.createQuery(Person.class);
        personRoot = criteriaQuery.from(Person.class);
        criteriaQuery.select(personRoot).where(criteriaBuilder.equal(personRoot.get("id"), 66));
        person = entityManager.createQuery(criteriaQuery).getSingleResult();
        logger.info("Person" + person);

        // 2.b Select person with id = 66 -- using Predicate
        logger.info("\n 2.b Select person with id = 66 -- using Predicate");
        criteriaBuilder = entityManager.getCriteriaBuilder();
        criteriaQuery = criteriaBuilder.createQuery(Person.class);
        personRoot = criteriaQuery.from(Person.class);
        criteriaQuery.select(personRoot);

        //The predicate class allows for manu dynamic criteria
        List <Predicate> criteria = new ArrayList<Predicate>();

        //Check if we have criteria to add
        Integer parameter = 66;
        ParameterExpression <Integer> parameterExpression = criteriaBuilder.parameter(Integer.class, "id");
        criteria.add(criteriaBuilder.equal(personRoot.get("id"), parameter));

        // Criteria is added
        if(criteria.isEmpty()){
            throw new RuntimeException("Any criteria");
        }
        else if(criteria.size() == 1){
            criteriaQuery.where(criteria.get(0));
        }
        else{
            criteriaQuery.where(criteriaBuilder.and(criteria.toArray(new Predicate[0])));
        }

        personTypedQuery = entityManager.createQuery(criteriaQuery);
        personTypedQuery.setParameter("id", parameter);

        //execute query
        people = personTypedQuery.getResultList();
        logger.info("Person" + people);

    }
}
