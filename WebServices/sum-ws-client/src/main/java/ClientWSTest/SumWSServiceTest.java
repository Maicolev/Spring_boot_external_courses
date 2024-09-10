package ClientWSTest;

import clientWS.service.SumWSService;
import clientWS.service.SumWSServiceImplService;

public class SumWSServiceTest {
    public static void main(String[] args) {
        SumWSService sumWSService = new SumWSServiceImplService().getSumWSServiceImplPort();
        System.out.println("Starting sum service");
        int x = 6;
        int y = 3;
        int result = sumWSService.sum(x, y);
        System.out.println("Result: " + result);
        System.out.println("End sum service");
    }
}