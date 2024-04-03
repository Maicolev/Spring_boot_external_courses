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
import java.util.ArrayList;
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
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        String message = "";
        Client client = createClient(req);

        if (action.equals("remove")){
            message = conection.removeClient(client);
            req.setAttribute("message", message);
            doGet(req,resp);
        }
        else if(action.equals("add")){
            message = conection.addClient(client);
            req.setAttribute("message", message);
            //resp.sendRedirect("client");
            doGet(req,resp);
        }
        else if(action.equals("updateInit")){

            req.setAttribute("id", req.getParameter("idClientUpdate"));
            req.setAttribute("name", client.getName());
            req.setAttribute("lastName", client.getLastName());
            req.setAttribute("mail", client.getEmail());
            req.setAttribute("phone", client.getPhoneNumber());
            req.setAttribute("salary", client.getSalary());

            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/Views/updateClient.jsp");
            requestDispatcher.forward(req, resp);
        }
        else if(action.equals("updateEnd")){

            client.setId(Integer.parseInt(req.getParameter("id")));

            message = conection.updateClient(client);
            req.setAttribute("message", message);
            doGet(req,resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
       // if(action.equals("list")){
            List<Client> list = conection.listClient();
            req.setAttribute("clientList", list);

            req.setAttribute("totalSalary", getTotalSalary());
            req.setAttribute("totalClients", getTotalClients());

            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/Views/clientList.jsp");
            requestDispatcher.forward(req, resp);
     //   }
    }

    public List <Client> listClients(){return conection.listClient();}

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

    public Client createClient(HttpServletRequest req){

        String idUp = req.getParameter("idClientUpdate");
        String idRe = req.getParameter("idClientRemove");

        if (idRe == null && idUp == null){
            int    id;
            String name = req.getParameter("name");
            String lastName = req.getParameter("lastName");
            String email = req.getParameter("mail");
            String phone = req.getParameter("phone");
            double salary = Double.parseDouble(req.getParameter("salary"));

            //get max id
            List <Client> clients = conection.listClient();
            id = (clients.isEmpty()) ? 1 : clients.get(clients.size()-1).getId() +1;

            Client client = new Client(id, name, lastName, email, phone, salary);
            return client;
        }
        else if (idRe != null){
            return conection.findClientById(idRe);
        }
        else if (idUp != null) {
            return conection.findClientById(idUp);
        }
        return null;
    }
}
