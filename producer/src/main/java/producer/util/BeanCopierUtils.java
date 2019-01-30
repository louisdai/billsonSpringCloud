package producer.util;

import com.google.common.collect.Lists;
import org.springframework.cglib.beans.BeanCopier;
import producer.data.TestDemo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BeanCopierUtils {

    public static Map<String, BeanCopier> beanCopierMap = new HashMap<String, BeanCopier>();

    public static void copyProperties(Object source, Object target) {

        String beanKey = generateKey(source.getClass(), target.getClass());

        BeanCopier copier = null;

        if (!beanCopierMap.containsKey(beanKey)) {
            copier = BeanCopier.create(source.getClass(), target.getClass(), false);
            beanCopierMap.put(beanKey, copier);
        } else {
            copier = beanCopierMap.get(beanKey);
        }
        copier.copy(source, target, null);
    }

    private static String generateKey(Class<?> class1, Class<?> class2) {
        return class1.toString() + class2.toString();
    }

    public static void main(String[] args) {
        TestDemo td = new TestDemo();
        TestDemo std = new TestDemo();
        std.setId("0");
        List<TestDemo> slist = Lists.newArrayList();
        slist.add(std);
        td.setId("1");
        td.setSubList(slist);
        TestDemo ctd = new TestDemo();
        copyProperties(td, ctd);
        ctd.setId("2");
        List<TestDemo> cslist = Lists.newArrayList();
        TestDemo cstd = new TestDemo();
        cstd.setId("3");
        cslist.add(cstd);
        ctd.getSubList().add(cstd);
        ctd.setSubList(cslist);
        System.out.println(td.toString());
        System.out.println(ctd.toString());
    }

}


