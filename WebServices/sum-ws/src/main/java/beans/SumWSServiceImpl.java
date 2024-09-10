package beans;

import jakarta.ejb.Stateless;
import jakarta.jws.WebService;

@Stateless
@WebService(endpointInterface = "beans.SumWSService")
public class SumWSServiceImpl implements SumWSService {

    @Override
    public int sum(int a, int b) {
        return a+b;
    }
}
