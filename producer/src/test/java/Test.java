import com.google.common.collect.Lists;

import java.util.HashMap;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        System.out.println( TYPE.BLUE instanceof TYPE );
        List<String>  itemList = Lists.newArrayList();
        List<String>  retList = Lists.newArrayList();
        for(int i = 0;i<6;i++){
            itemList.add("org"+i);
            retList.add("ret"+i);
        }

        for(int i = 0;i< itemList.size();i++){
            int idx = retList.indexOf(itemList.get(i));
            if(idx != -1){
                itemList.set(i,retList.get(idx));
            }
        }
    }
}
