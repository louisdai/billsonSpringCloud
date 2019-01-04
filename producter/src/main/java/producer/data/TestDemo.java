package producer.data;

import com.google.common.collect.Lists;
import lombok.Data;

import java.util.List;

@Data
public class TestDemo {

    private int id;
    List<TestDemo> subList = Lists.newArrayList();
}
