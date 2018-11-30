package producer.controller;

import com.google.common.collect.Maps;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import producer.feignClient.ConsumerClient;
import redis.clients.jedis.JedisCluster;

import java.util.Map;

@RestController
@RequestMapping("/producer")
@Api(description = "提供者服务主入口")
public class ProducerController {

    @Autowired
    ConsumerClient consumerClient;

    @Qualifier("doc-materiel")
    @Autowired
    JedisCluster jedisCluster;

    @RequestMapping(value = "test1", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    public String test1(@RequestBody String request) {
        System.out.println("success");
        return "TEST1 SUCCESS " + request;
    }


    @RequestMapping(value = "test2", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    public String test2(@RequestBody String request) {
        System.out.println("producer test2 ...");
//        return consumerClient.test2(request);
        return "";
    }
    @ApiOperation(value = "展示接口")
    @RequestMapping(value = "display", method = RequestMethod.GET)
    public Map<String,Object> displayAnything(String request){
        Map<String,Object> result = Maps.newHashMap();
        result.put("redisTest",jedisCluster.get("feed_DJV5JCTR0529ELQM"));
        return result;
    }
}
