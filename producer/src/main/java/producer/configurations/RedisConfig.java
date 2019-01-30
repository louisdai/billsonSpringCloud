package producer.configurations;

import com.google.common.collect.Sets;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;

import java.util.Set;

@Configuration
public class RedisConfig {

    @Bean(name = "doc-materiel")
    public JedisCluster docMateriel(
            @Value("${redis.doc-materiel.pool.max-idle}") int maxIdle,
            @Value("${redis.doc-materiel.pool.min-idle}") int minIdle,
            @Value("${redis.doc-materiel.pool.max-total}") int maxTotal,
            @Value("${redis.doc-materiel.pool.max-wait}") int maxWait,
            @Value("${redis.doc-materiel.timeout}") int timeout,
            @Value("${redis.doc-materiel.cluster.nodes}") String nodes
    ) {
        JedisPoolConfig poolCofig = new JedisPoolConfig();
        poolCofig.setMaxIdle(maxIdle);
        poolCofig.setMinIdle(minIdle);
        poolCofig.setMaxTotal(maxTotal);
        poolCofig.setMaxWaitMillis(maxWait);

        Set<HostAndPort> hostAndPorts = Sets.newHashSet();
        for (String node : nodes.split(",")) {
            if (StringUtils.isEmpty(node)) {
                continue;
            }
            node = node.trim();
            String ip = node.split(":")[0];
            int port = Integer.parseInt(node.split(":")[1]);
            hostAndPorts.add(new HostAndPort(ip, port));
        }

        JedisCluster jedisCluster = new JedisCluster(hostAndPorts, timeout, poolCofig);
        return jedisCluster;
    }


    @Bean(name = "recommend-result")
    public JedisCluster recommendResult(
            @Value("${redis.recommend-result.pool.max-idle}") int maxIdle,
            @Value("${redis.recommend-result.pool.min-idle}") int minIdle,
            @Value("${redis.recommend-result.pool.max-total}") int maxTotal,
            @Value("${redis.recommend-result.pool.max-wait}") int maxWait,
            @Value("${redis.recommend-result.timeout}") int timeout,
            @Value("${redis.recommend-result.cluster.nodes}") String nodes
    ) {
        JedisPoolConfig poolCofig = new JedisPoolConfig();
        poolCofig.setMaxIdle(maxIdle);
        poolCofig.setMinIdle(minIdle);
        poolCofig.setMaxTotal(maxTotal);
        poolCofig.setMaxWaitMillis(maxWait);

        Set<HostAndPort> hostAndPorts = Sets.newHashSet();
        for (String node : nodes.split(",")) {
            if (StringUtils.isEmpty(node)) {
                continue;
            }
            node = node.trim();
            String ip = node.split(":")[0];
            int port = Integer.parseInt(node.split(":")[1]);
            hostAndPorts.add(new HostAndPort(ip, port));
        }

        JedisCluster jedisCluster = new JedisCluster(hostAndPorts, timeout, poolCofig);
        return jedisCluster;
    }
}
