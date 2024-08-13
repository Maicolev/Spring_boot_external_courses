package web;

import domain.Person;
import services.impl.PersonServiceImpl;
import services.interfaces.PersonServicesLocal;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/people")
public class PersonServlet extends HttpServlet {

    //not work -> @injected referce is returned null
    @Inject
    PersonServicesLocal personServicesLocal;

    @Override
    protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("mo--doGet");

        //This line should not go
       //personServicesLocal = new PersonServiceImpl();

        //List <Person> people = new ArrayList<>();
        List <Person> people= personServicesLocal.getAllPersons();
        //personServicesLocal.deletePerson(6);

        System.out.println(people.size());

        //System.out.println("People" + people.get(0).getName());

        request.setAttribute("people", people);
        request.getRequestDispatcher("/personList.jsp").forward(request,response);
    }
}
