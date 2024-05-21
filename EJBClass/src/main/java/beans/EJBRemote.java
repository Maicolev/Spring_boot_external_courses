package beans;

import javax.ejb.Remote;

@Remote
public interface EJBRemote {
    public int add(int a, int b);
}
