package producer.util;

import org.springframework.util.StringUtils;

import java.io.UnsupportedEncodingException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Jaccard {

    public static void main(String[] args) {
        System.out.println("请输入两个字符串");

//        Scanner sc = new Scanner(System.in);
//        String str1 = sc.nextLine();
//        String str2 = sc.nextLine();

        String str1 = "我是B中b国人!";
        String str2 = "b我不是美国 人!";
        Set<Character> s1 = new HashSet<>();//set元素不可重复
        Set<Character> s2 = new HashSet<>();
        String b_str = "";
        try {
            byte[] tmp = str1.getBytes("ISO-8859-1");
            b_str = new String(tmp, "utf-8");
            System.out.println(b_str.toString());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < b_str.length(); i++) {
            s1.add(b_str.charAt(i));//将string里面的元素一个一个按索引放进set集合
        }
        System.out.println(s1.toString());
        for (int j = 0; j < str2.length(); j++) {
            s2.add(str2.charAt(j));
        }

        float mergeNum = 0;//并集元素个数
        float commonNum = 0;//相同元素个数（交集）

        for (Character ch1 : s1) {
            for (Character ch2 : s2) {
                if (ch1.equals(ch2)) {
                    System.out.println(ch1);
                    commonNum++;
                }
            }
        }

        mergeNum = s1.size() + s2.size() - commonNum;

        float jaccard = commonNum / mergeNum;
        System.out.println(jaccard);
        System.out.println(str2);
        System.out.println(str1);
    }
}
