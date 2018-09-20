package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HelloController {

    @Autowired
    IHelloService helloService;

    @RequestMapping(value = "/hello")
    public String hi(@RequestParam String name) {
        return helloService.hello(name);
    }
}
