package web;

import domain.User;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import services.interfaces.UserServices;

import java.io.IOException;
import java.util.List;

@WebServlet("/users")
public class UserServlet extends HttpServlet {

    @Inject
    UserServices userServices;

    @Override
    protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List <User> users= userServices.getAllUsers();

        System.out.println("Total users: " + users.size());

        request.setAttribute("users", users);
        request.getRequestDispatcher("/userList.jsp").forward(request,response);
    }
}
