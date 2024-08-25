package web;

import domain.Person;
import services.interfaces.PersonServicesLocal;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/people")
public class PersonServlet extends HttpServlet {

    @Inject
    PersonServicesLocal personServicesLocal;

    @Override
    protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("mo--doGet");

        List <Person> people= personServicesLocal.getAllPersons();

        System.out.println(people.size());

        request.setAttribute("people", people);
        request.getRequestDispatcher("/personList.jsp").forward(request,response);
    }
}
