package producer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@EnableAutoConfiguration
@Slf4j
@EnableFeignClients
@EnableCircuitBreaker
@EnableHystrixDashboard
@EnableDiscoveryClient
@SpringBootApplication
public class ProducerStarter {

        public static void main(String[] args) {
            log.info("producer is starting...");
            SpringApplication.run(ProducerStarter.class, args);
            log.info("producer is started.");
        }

}
