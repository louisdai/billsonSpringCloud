import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import org.mockito.internal.util.collections.Sets;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class TestC {
    public static void main(String[] args) {
        Set<String> set = Sets.newSet();

        List<String> list = Collections.EMPTY_LIST;
        System.out.println(list.size());
        System.out.println(JSON.toJSONString(set));
        long a = 101;
        long b = 107;
        long c = a^b;

        System.out.println(c);
        System.out.println(Long.bitCount(c));
        List<String> ab = Lists.newArrayList();
        List<String> abc = Lists.newArrayList();
//        abc.addAll(ab);
//        ab.add("1111");
        ab.addAll(abc);
//        func(ab);
        System.out.println(ab);
    }

    public static void func(List<String> ab){
        ab.clear();
        ab.add("222");
    }
}
