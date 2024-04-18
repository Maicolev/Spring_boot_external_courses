package controller;

import utilities.Rectangle;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/mvc2/mvc2")
public class Mvc2Controller extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        HttpSession session = request.getSession();
        session.setAttribute("message", "Please check parameters" );

        if (action.equals("add")){
            Rectangle rectangleRequest = new Rectangle(2,3);
            request.setAttribute("rectangleRequest", rectangleRequest);

            Rectangle rectangleSession = new Rectangle(4,5);
            session.setAttribute("rectangleSession", rectangleSession);

            session.setAttribute("message", "variable have been added" );

        }
        else if (action.equals("list")){
            session.setAttribute("message", "Variable:" );
        }

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/mvc2/indexList.jsp");
        requestDispatcher.forward(request, response);
    }
}
