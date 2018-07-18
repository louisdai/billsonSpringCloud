package consumer.feignClient;

import feign.Headers;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "producer"
//        , url = "http://127.0.0.1:8099"
)

@Headers("Content-Type:application/json")
public interface ProducerClient {
    @RequestMapping("/producer/test1")
    String test1(@RequestBody String request);
}

