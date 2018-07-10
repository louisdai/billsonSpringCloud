package producer.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/producer")
public class ProducerController {

    @RequestMapping(value = "test1", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    public String test1(@RequestParam String request) {
        return "TEST1 SUCCESS" + request;
    }
}
