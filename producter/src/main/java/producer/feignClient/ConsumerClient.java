package producer.feignClient;

import feign.Headers;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "consumer"
//        , url = "http://127.0.0.1:8099"
)
@Headers("Content-Type:application/json")
public interface ConsumerClient {
    @RequestMapping("/consumer/test2")
    String test2(@RequestBody String request);
}