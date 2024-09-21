package client;

import domain.Person;
import services.interfaces.PersonServicesRemote;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.io.Serializable;
import java.util.List;

public class ClientPersonService implements Serializable {
    public static void main (String[]args){
        System.out.println("starting call to EJB from client");

        try{
            Context jndi = new InitialContext();
            PersonServicesRemote personServicesRemote = (PersonServicesRemote) jndi.lookup("java:global/AMS_SGA_web-REST-1.0/PersonServiceImpl!services.interfaces.PersonService");

            List <Person> people = personServicesRemote.getAllPersons();

            for(Person person : people){
                System.out.println(person);
            }

            System.out.println("Finish call to EJB from client");

        } catch (NamingException e) {
            throw new RuntimeException(e);
        }
    }
}