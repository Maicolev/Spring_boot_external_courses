package ClientWSTest;

import clientWS.service.Person;
import clientWS.service.PersonServiceImplService;
import clientWS.service.PersonServiceWs;
import jakarta.xml.ws.BindingProvider;

import java.util.List;

public class PersonWSTest {
   public static void main(String[] args) {
       PersonServiceWs personServiceWS = new PersonServiceImplService().getPersonServiceImplPort();

       ((BindingProvider)personServiceWS).getRequestContext().put(BindingProvider.USERNAME_PROPERTY, "admin");
       ((BindingProvider)personServiceWS).getRequestContext().put(BindingProvider.PASSWORD_PROPERTY, "admin");

       System.out.println("list method on ws");
       for (Person person : personServiceWS.getAllPersons()) {
           System.out.println(person.getFirstname() + " " + person.getLastname());
       }
   }

}
