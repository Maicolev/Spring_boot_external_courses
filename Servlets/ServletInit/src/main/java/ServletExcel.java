import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/ExcelGenerator")
public class ServletExcel extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws IOException {

        //response type
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment;filename=exampleExcel.xls");

        //caché management
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-control", "no-store");
        response.setDateHeader("Expires", -1);

        //response
        PrintWriter out = response.getWriter();
        out.println("\tValues");
        out.println("\t1");
        out.println("\t2");
        out.println("Total\t=SUMA(B2:B3)");
        out.close();

    }



}
