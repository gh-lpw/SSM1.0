import org.junit.Test;
import org.springframework.http.HttpHeaders;

import javax.servlet.http.*;

public class Test01 {

    @Test
    public void test(){
        Integer a =  100;
        Integer b =  100;
        System.out.println(a == b);

        System.out.println("Integer.valueOf(200) = " + Integer.valueOf(200));

        Integer c =  200;
        Integer d =  200;
        System.out.println(c == d);

        Integer e =  200;
        int f =  200;
        System.out.println(e == f);

        HttpHeaders headers = new HttpHeaders();
        System.err.println(headers);
    }
}
