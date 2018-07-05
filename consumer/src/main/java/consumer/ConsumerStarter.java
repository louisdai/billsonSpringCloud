package consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@Slf4j
@SpringBootApplication
public class ConsumerStarter {
    public static void main(String[] args) {
            log.info("consumer is starting...");
        SpringApplication.run(ConsumerStarter.class, args);
            log.info("consumer is started.");
    }
}
