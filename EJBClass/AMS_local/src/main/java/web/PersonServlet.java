package web;

import domain.Person;
import services.PersonServiceImpl;
import services.PersonServicesLocal;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/people")
public class PersonServlet extends HttpServlet {

    //not work -> @injected referce is returned null
    //@Inject
    PersonServicesLocal personServicesLocal;

    @Override
    protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //This line should not go
        personServicesLocal = new PersonServiceImpl();

        //List <Person> people = new ArrayList<>();
        List<Person> people = personServicesLocal.getAllPersons();
        personServicesLocal.deletePerson(6);

        //System.out.println("People" + people.get(0).getName());

        request.setAttribute("people", people);
        request.getRequestDispatcher("/personList.jsp").forward(request,response);
    }
}
