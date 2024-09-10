package ClientWSTest;

import clientWS.service.Person;
import clientWS.service.PersonServiceImplService;
import clientWS.service.PersonServiceWs;

public class PersonWSTest {
   public static void main(String[] args) {
       PersonServiceWs personServiceWS = new PersonServiceImplService().getPersonServiceImplPort();
       for (Person person : personServiceWS.getAllPersons()) {
           System.out.println(person.getFirstname() + " " + person.getLastname());
       }
   }

}
