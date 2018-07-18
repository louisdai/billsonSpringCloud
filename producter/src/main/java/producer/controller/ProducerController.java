package producer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import producer.feignClient.ConsumerClient;

@RestController
@RequestMapping("/producer")
public class ProducerController {

    @Autowired
    ConsumerClient consumerClient;

    @RequestMapping(value = "test1", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    public String test1(@RequestBody String request) {
        System.out.println("success");
        return "TEST1 SUCCESS " + request;
    }


    @RequestMapping(value = "test2",method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    public String test2(@RequestBody String request){
        System.out.println("producer test2 ...");
        return consumerClient.test2(request);
    }
}
