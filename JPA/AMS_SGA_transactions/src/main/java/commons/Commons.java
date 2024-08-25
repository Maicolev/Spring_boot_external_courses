package commons;

import domain.Person;

import java.util.List;

import domain.User;
import org.slf4j.Logger;

public class Commons {

    public static void showPeople(List<Person> people, Logger logger) {
        for(Person p: people){
            logger.info("people: " + p);
        }
    }

    public static void showPerson(Person person, Logger logger) {
        logger.info("person: " + person);
    }

    public static void showUsers(List<User> users, Logger logger) {
        for(User u: users){
            logger.info("Usuario: " + u);
        }
    }
}
