package consumer.config;

import feign.Feign;
import okhttp3.ConnectionPool;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.cloud.netflix.feign.FeignAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

@Configuration
@ConditionalOnClass(Feign.class)
@AutoConfigureBefore(FeignAutoConfiguration.class)
public class FeignOkHttpConfig {

    @Bean
    public okhttp3.OkHttpClient okHttpClient(
            @Value("${okhttp.pool.read-timeout:200}") int rTimeout,
            @Value("${okhttp.pool.connect-timeout:100}") int conTimeout,
            @Value("${okhttp.pool.write-timeout:200}") int wTimeout,
            @Value("${okhttp.pool.max-idle:1000}") int maxIdle
    ){
        return new okhttp3.OkHttpClient.Builder()
                .readTimeout(rTimeout, TimeUnit.MILLISECONDS)
                .connectTimeout(conTimeout, TimeUnit.MILLISECONDS)
                .writeTimeout(wTimeout, TimeUnit.MILLISECONDS)
                .connectionPool(new ConnectionPool(maxIdle, 60, TimeUnit.SECONDS))
                // .addInterceptor();
                .build();
    }

}
