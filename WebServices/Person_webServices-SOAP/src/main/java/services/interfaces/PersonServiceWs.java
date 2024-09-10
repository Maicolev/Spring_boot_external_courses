package services.interfaces;

import domain.Person;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;

import java.util.List;

@WebService
public interface PersonServiceWs {

    @WebMethod
    public List<Person> getAllPersons();
}
