package controller;

import utilities.Rectangle;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/mvc1")
public class Mvc1Controller extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Hi");
        String variableTest1 = "Getting from mvc1 controller by request";
        request.setAttribute("variableTest1", variableTest1);

        String variableTest2 = "Gretting from mvc1 controller by session";
        HttpSession session = request.getSession();
        session.setAttribute("variableTest2", variableTest2);

        Rectangle rectangle = new Rectangle();
        rectangle.setBase(3);
        rectangle.setHeight(7);
        request.setAttribute("rectangle", rectangle);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/mvc1/index.jsp");
        requestDispatcher.forward(request, response);
    }

}
