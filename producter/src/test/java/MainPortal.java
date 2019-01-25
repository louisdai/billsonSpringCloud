import com.alibaba.fastjson.JSON;

public class MainPortal {
    public static void main(String[] args) {
        Parent p = new Parent();
        Child c = new Child();
        System.out.println(JSON.toJSONString(c));
    }
}
