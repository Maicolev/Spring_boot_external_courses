package beans;

import javax.ejb.Stateless;

@Stateless
public class EJBRemoteImpl implements EJBRemote {

    @Override
    public int add(int a, int b) {
        System.out.println("Adding " + a + " and " + b);
        return a + b;
    }
}
