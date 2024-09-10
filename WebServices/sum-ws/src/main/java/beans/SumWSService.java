package beans;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;

@WebService
public interface SumWSService {

    @WebMethod
    public int sum(int a, int b);
}
