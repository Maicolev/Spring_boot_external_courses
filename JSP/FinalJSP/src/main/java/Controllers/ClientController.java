package Controllers;

import Conection.Conection;
import Models.Client;
import com.mongodb.client.MongoCursor;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * List clients
 * Calculate total salary
 * Calculate total clients
 * add client
 * remove client
 * edit client (puede ser la misma que agregar pero con datos llenos)
 */
@WebServlet("/client")
public class ClientController extends HttpServlet {

    Conection conection = new Conection();

    /**
     * This method process remove client
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        String message = "";
        Client client = (Client) req.getAttribute("client");
        //Client client = new Client(666, "Namesss", "LastNameee", "Email", "34567", 100000);

        if (action.equals("remove")){
            message = conection.removeClient(client);
            req.setAttribute("message", message);
        }
        else if(action.equals("add")){
            message = conection.addClient(client);
            req.setAttribute("message", message);
        }
        else if(action.equals("update")){
            message = conection.updateClient(client);
            req.setAttribute("message", message);
        }
        else if(action.equals("list")){
            //System.out.println("list in");

            List<Client> list = conection.listClient();
            req.setAttribute("clientList", list);

            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/Views/clientList.jsp");
            requestDispatcher.forward(req, resp);

            //System.out.println("total Salary is:" + getTotalSalary());
            //System.out.println("total clients are:" + getTotalClients());
        }
    }

    public List <Client> listClients(){
        return conection.listClient();
    }

    public double getTotalSalary(){
        double totalSalary = 0;
        for( Client client : listClients() ){
            totalSalary += client.getSalary();
        }
        return totalSalary;
    }

    public int getTotalClients(){
        return listClients().size();
    }
}
