import lombok.Data;

@Data
public class Child extends Parent{

    private int b = 30;

    private String a="ccc" ;

    public void setA(String a){
        this.a =a;
    }

    public String getA(){
        return this.a;
    }
}
