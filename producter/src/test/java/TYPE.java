import java.util.HashMap;
import java.util.Map;

public enum TYPE {
    BLUE("11",0), APPLE("22",1), HELLO("33",2), KAKA("55",3), KAKAKA("77",10);
    private int n;
    private String k;
    TYPE(String k,int i) {
        this.k = k;
        this.n=i;
    }

    public int getV(){
        return n;
    }
    public String getK(){
        return k;
    }

    public static void main(String[] args) {
        Map<TYPE,String> rule = new HashMap<>();
        rule.put(TYPE.BLUE,"ccc");
        System.out.println(rule.get(TYPE.BLUE));
        System.out.println(rule.get(TYPE.APPLE));
    }
}
