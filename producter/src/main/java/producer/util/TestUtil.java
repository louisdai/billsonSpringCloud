package producer.util;

import com.alibaba.fastjson.JSON;
import com.google.common.cache.Cache;
import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import producer.data.TestDemo;

import javax.annotation.PostConstruct;
import java.util.Map;

@Service
public class TestUtil {

    @Autowired
    private Cache<String, Object> localCache;

    @PostConstruct
    public void init() {
        TestDemo td = new TestDemo();
        td.setId(123);
        localCache.put("key", td);
        TestDemo after = (TestDemo) localCache.getIfPresent("key");
        Map<String,TestDemo> map = Maps.newHashMap();
        map.put("key",after);
        System.out.println(JSON.toJSONString(after));
        try {
            Thread.sleep(5000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(localCache.getIfPresent("key"));
        System.out.println(JSON.toJSONString(map));
        System.out.println(JSON.toJSONString(after));
    }

}
