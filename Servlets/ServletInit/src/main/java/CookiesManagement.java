
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/CookiesManagement")
public class CookiesManagement extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        boolean exist = false;
        String user = request.getParameter("user");
        Cookie[] cookies = request.getCookies();

        for (Cookie cookie: cookies) {
            if (cookie.getValue().equals(user)){
                exist = true;
            }
        }

        if(exist == false){
            Cookie cookie = new Cookie("user", user);
            response.addCookie(cookie);
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.print("<html>");
            out.print("<head>");
            out.print("<title>Cookies result</title>");
            out.print("</head>");
            out.print("<body>");
            out.print("<h1>Cookies processed:</h1>");
            out.print("Welcome new client");
        }
        else {
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.print("<html>");
            out.print("<head>");
            out.print("<title>Cookies result</title>");
            out.print("</head>");
            out.print("<body>");
            out.print("<h1>Cookies processed:</h1>");
            out.print("Welcome back, client: " + user);
        }
    }
}
