import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/ShoppingCart")
public class ShoppingCart extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String itemName = request.getParameter("itemName");
        HttpSession session = request.getSession();
        boolean existeItem = false;
        List<String> items =  (List<String>) session.getAttribute("items");

        if(items == null){
            items = new ArrayList<String>();
            session.setAttribute("items", items);
        }

        if (items.isEmpty()){
            items.add(itemName);
        }
        else{
                for (int i = 0; i<items.size(); i++){
                    if (items.get(i).equalsIgnoreCase(itemName)){
                       existeItem = true;
                    }
                }
                if (existeItem == false){
                    items.add(itemName);
                }
            }

        if (items.size()>0){
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.print("<html>");
            out.print("<head>");
            out.print("<title>Shopping cart items</title>");
            out.print("</head>");
            out.print("<body>");
            out.print("<h1>Shopping cart items:</h1>");
            out.println("<h2> Welcome back, Total items: " + items.size() + "</h2>");

            for (int i = 0; i<items.size(); i++){
                out.println("<li>" + items.get(i) + "</li>");
            }
            out.print("</body>");

        }
    }
}
