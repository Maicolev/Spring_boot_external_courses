import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/servlet")
public class Servlet extends HttpServlet{

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String user = request.getParameter("user");
        String password = request.getParameter("password");
        String technologies[] = request.getParameterValues("technologies");
        String gender = request.getParameter("radioGender");
        String occupation = request.getParameter("occupation");
        String favoriteMusic[] = request.getParameterValues("favoriteMusic");
        String comments = request.getParameter("comments");

        out.print("<html>");
        out.print("<head>");
        out.print("<title>Resultado Servlet</title>");
        out.print("</head>");
        out.print("<body>");
        out.print("<h1>Parametros procesados por el Servlet:</h1>");
        out.print("<table border='1'>");

        out.print("<tr>");
        out.print("<td>");
        out.print("User");
        out.print("</td>");
        out.print("<td>");
        out.print(user);
        out.print("</td>");
        out.print("</tr>");

        out.print("<tr>");
        out.print("<td>");
        out.print("Password");
        out.print("</td>");
        out.print("<td>");
        out.print(password);
        out.print("</td>");
        out.print("</tr>");

        out.print("<tr>");
        out.print("<td>");
        out.print("Technologies");
        out.print("</td>");
        out.print("<td>");

        for (String technologie : technologies) {
            out.print(technologie);
            out.print(" / ");
        }

        out.print("</td>");
        out.print("</tr>");

        out.print("<tr>");
        out.print("<td>");
        out.print("Gender");
        out.print("</td>");
        out.print("<td>");
        out.print(gender);
        out.print("</td>");
        out.print("</tr>");

        out.print("<tr>");
        out.print("<td>");
        out.print("Occupation");
        out.print("</td>");
        out.print("<td>");
        out.print(occupation);
        out.print("</td>");
        out.print("</tr>");

        out.print("<tr>");
        out.print("<td>");
        out.print("Favorite music");
        out.print("</td>");
        out.print("<td>");

        if (favoriteMusic != null) {
            for (String m : favoriteMusic) {
                out.print(m);
                out.print(" / ");
            }
        }
        else{
            out.print("Value empty");
        }

        out.print("</td>");
        out.print("</tr>");

        out.print("<tr>");
        out.print("<td>");
        out.print("Comments");
        out.print("</td>");
        out.print("<td>");
        out.print(comments);
        out.print("</td>");
        out.print("</tr>");

        out.print("</table>");
        out.print("</body>");
        out.print("</html>");
    }
}

