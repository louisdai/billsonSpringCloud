package producer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@Slf4j
@SpringBootApplication
public class ProducerStarter {

        public static void main(String[] args) {
            log.info("producer is starting...");
            SpringApplication.run(ProducerStarter.class, args);
            log.info("producer is started.");
        }

}
