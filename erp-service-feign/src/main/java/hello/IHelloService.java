package hello;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "hello-service", fallback=FallbackClient.class)
public interface IHelloService {

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    String hello(@RequestParam(value = "name") String name);
}

