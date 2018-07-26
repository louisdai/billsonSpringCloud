package consumer.controller;

import consumer.service.TestService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/consumer")
@Api(description = "消费者服务Controller")
public class ConsumerController {

    @Autowired
    TestService ts;

    @ApiOperation(value = "consumerTest1")
    @ApiImplicitParam(name = "type", value = "类型(0:男生(默认), 1:女生)", defaultValue = "0", dataType = "int", paramType = "query")
    @RequestMapping(value = "test1", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    public Map<String, Object> test1(@RequestBody String request) {
        System.out.println("consumer success");
        Map<String,Object> result = new HashMap<String,Object>();
        result.put("producer",ts.test1());
        return result;
//        return "TEST1 SUCCESS " + request;
    }
    @RequestMapping(value = "test2", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    public String test2(@RequestBody String request){
        System.out.println("consumer test2 ...");
        return "test2";
    }
}
