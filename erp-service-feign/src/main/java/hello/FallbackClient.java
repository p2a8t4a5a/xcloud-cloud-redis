package hello;

import org.springframework.web.bind.annotation.RequestParam;

public class FallbackClient implements IHelloService {

    @Override
    public String hello(String name) {
        return "oops";
    }
}
