package Controllers;

import Conection.Conection;
import Models.Client;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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

        //req.getParameter("id");
        Client client = new Client(666, "NameEdit", "LastNameee", "Email", "34567", "100000");

        System.out.print("doget method");

        if (action.equals("remove")){
            conection.removeClient(client);
        }
        else if(action.equals("add")){
            //Client client = new Client(666, "Nameee", "LastNameee", "Email", "34567", "100000");
            conection.addClient(client);
        }
        else if(action.equals("update")){
            conection.updateClient(client);
        }
        else if(action.equals("list")){
            conection.listClient();
        }
    }
}
