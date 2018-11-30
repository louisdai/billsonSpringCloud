package producer.configurations;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

import java.util.Set;

@Configuration
@RefreshScope
@ConfigurationProperties("dynamic")
@Data
public class DynamicProperties {

    private boolean debug = false;

    private String name;

    private Set<String> ignoredNBAChannelPOIs;

    private Set<String> ignoredGJZQChannelPOIs;

    private Set<String> ignoredYuleChannelPOIs;

    private Set<String> ignoredCaijingChannelPOIs;

    private Set<String> ignoredKejiChannelPOIs;

    private Set<String> ignoredTiyuChannelPOIs;

    private Set<String> ignoredJiajuChannelPOIs;

    /** 负反馈部分文章源不过滤 */
    private Set<String> feedbackWhiteSet;
}
