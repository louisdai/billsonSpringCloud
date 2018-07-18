package consumer.controller;

import consumer.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/consumer")
public class ConsumerController {

    @Autowired
    TestService ts;

    @RequestMapping(value = "test1", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    public String test1(@RequestBody String request) {
        System.out.println("consumer success");
        return ts.test1();
//        return "TEST1 SUCCESS " + request;
    }
    @RequestMapping(value = "test2", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    public String test2(@RequestBody String request){
        System.out.println("consumer test2 ...");
        return "test2";
    }
}
