package product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
public class ProducterStarter {

        public static void main(String[] args) {
//            log.info("producter is starting...");
            SpringApplication.run(ProducterStarter.class, args);
//            log.info("producter is started.");
        }

}
