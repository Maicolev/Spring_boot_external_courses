import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/servletStatusCodes")
public class StatusCodes extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");

        PrintWriter printWriter = response.getWriter();
        //printWriter.print("Hi");
        String userApproved = "Daniela";
        String passwordApproved = "Dani";
        String userRequest = request.getParameter("user");
        String passwordRequest = request.getParameter("password");

        if (userApproved.equals(userRequest) && passwordApproved.equals(passwordRequest)){
            //response.sendError(HttpServletResponse.SC_OK);
            printWriter.print("<h1>Successful </h1>");
            printWriter.print("User: " + userRequest);
            printWriter.print("Password: " + passwordRequest);
        }
        else {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED,"Incorrect credentials");
        }

    }

}

