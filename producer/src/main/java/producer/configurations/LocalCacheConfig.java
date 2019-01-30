package producer.configurations;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

@Configuration
public class LocalCacheConfig {

    @Bean
    public Cache<String, Object> createCache(@Value("${cache.expire-after-write-seconds}") int expireAfterWrite,
                                             @Value("${cache.max-capacity}") int maxSize,
                                             @Value("${cache.init-capacity}") int initSize) {
        return CacheBuilder.newBuilder()
                .expireAfterWrite(expireAfterWrite, TimeUnit.SECONDS)
                .initialCapacity(initSize)
                .maximumSize(maxSize)
                .recordStats()
                .build();
    }
}
