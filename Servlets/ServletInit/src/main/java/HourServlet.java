import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/Hour")
public class HourServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.setHeader("refresh", "1");

        Date date = new Date();
        SimpleDateFormat formater = new SimpleDateFormat("HH:mm:ss");
        String formatDate = formater.format(date);

        PrintWriter out = response.getWriter();
        out.print("Real hour:" + formatDate);
        out.close();

    }
}
