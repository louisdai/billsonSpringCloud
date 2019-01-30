package producer.data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@ConfigurationProperties(prefix = "swagger")
@Component
public class SwaggerConfigProperties implements Serializable {
    /**
     * 是否开启Swagger
     */
    private boolean enable = false;
    /**
     * 要扫描的包
     */
    private String packageScan;
    /**
     * 标题
     */
    private String title;

    /**
     * 版本信息
     */
    private String version;

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public String getPackageScan() {
        return packageScan;
    }

    public void setPackageScan(String packageScan) {
        this.packageScan = packageScan;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}

