package test;

import beans.EJBRemote;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class TestEJB {

    public static void main(String[] args) {
        System.out.println("Test EJB");
        try{
            //Hashtable env = new Hashtable(2);
            //env.put("java.naming.factory.initial", CNCtxFactory);
            //Context  context = new InitialContext(env);
            //EJBRemote remoteEJB = (EJBRemote) context.lookup("java:global/EJBRemote/EJBRemoteImpl!beans.EJBRemote");

            Context context = new InitialContext();
            EJBRemote remoteEJB = (EJBRemote) context.lookup("java:global/EJBClass/EJBRemoteImpl!beans.EJBRemote");

            int result = remoteEJB.add(6,10);
            System.out.println(result);
        }

        catch (NamingException e) {
            e.printStackTrace(System.out);
            //throw new RuntimeException(e);
        }
    }
}
