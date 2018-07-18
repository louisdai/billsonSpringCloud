package consumer.service;

import consumer.feignClient.ProducerClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("test-service")
public class TestService {

    @Autowired
    private ProducerClient producerClient;

    public String test1(){
        return producerClient.test1("Feign CONSUMER");
    }
}
