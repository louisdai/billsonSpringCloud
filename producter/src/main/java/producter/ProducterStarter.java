package producter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@Slf4j
@SpringBootApplication
public class ProducterStarter {

        public static void main(String[] args) {
            log.info("producter is starting...");
            SpringApplication.run(ProducterStarter.class, args);
            log.info("producter is started.");
        }

}
