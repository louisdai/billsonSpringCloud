import lombok.Data;

@Data
public class Parent {

    private long a = 10;

    private long getA(){
        return a;
    }

    private void setA(long a){
        this.a = a;
    }
}
