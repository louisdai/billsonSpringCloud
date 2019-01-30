package producer.util;

import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.util.JsonFormat;
import producer.protobuf.PersonProtobuf;
import producer.protobuf.Staffbuf;

import java.util.ArrayList;
import java.util.List;

public class ProtobufUtil {
    public static void main(String[] args) {
        simpleDemo();
        complexDemo();

    }

    public static void simpleDemo(){
        //  序列化
        // 创建Person的Builder
        PersonProtobuf.Person.Builder personBuilder =
                PersonProtobuf.Person.newBuilder();
        // 设置Person的属性
        personBuilder.setAge(18);
        personBuilder.setName("张三丰");
        // 创建Person
        PersonProtobuf.Person zhangsanfeng = personBuilder.build();
        // 序列化，byte[]可以被写到磁盘文件，或者通过网络发送出去。
        byte[] data = zhangsanfeng.toByteArray();
        System.out.println("serialization end.");


        // 反序列化，byte[]可以读文件或者读取网络数据构建。
        System.out.println("deserialization begin.");
        try {
            PersonProtobuf.Person person = PersonProtobuf.Person.parseFrom(data);
            System.out.println(person.getAge());
            System.out.println(person.getName());
        } catch (InvalidProtocolBufferException e) {
            e.printStackTrace();
        }

    }

    public static void complexDemo(){
//  序列化
        // 创建Staff的Builder
        Staffbuf.Staff.Builder staffBuilder = Staffbuf.Staff.newBuilder();
        staffBuilder.setId(1);
        staffBuilder.setName("张三丰");
        //staffBuilder.setEmail("zhangsanfeng@wudang.org");

        // 构建嵌套消息PhoneNumber
        List list = new ArrayList();
        Staffbuf.Staff.PhoneNumber.Builder phoneBuilder =
                Staffbuf.Staff.PhoneNumber.newBuilder();
        phoneBuilder.setType(Staffbuf.Staff.PhoneType.TELEPHONE);
        phoneBuilder.setNumber("010-12345678");
        Staffbuf.Staff.PhoneNumber phoneNumber = phoneBuilder.build();
        list.add(phoneNumber);
        phoneBuilder.clear();
        //phoneBuilder.setType(Staffbuf.Staff.PhoneType.MOBILE);
        phoneBuilder.setNumber("13912345678");
        list.add(phoneBuilder.build());

        // 构建Map
        Staffbuf.Staff.Map.Builder mapBuilder = Staffbuf.Staff.Map.newBuilder();
        mapBuilder.setKey("a");
        mapBuilder.setValue(100);

        staffBuilder.addAllPhone(list);
        staffBuilder.setMap(mapBuilder.build());
        Staffbuf.Staff zhangsanfeng = staffBuilder.build();
        // 序列化，byte[]可以被写到磁盘文件，或者通过网络发送出去。
        byte[] data = zhangsanfeng.toByteArray();
        System.out.println("serialization end.");


        // 反序列化，byte[]可以读文件或者读取网络数据构建。
        System.out.println("deserialization begin.");
        Staffbuf.Staff staff = null;
        try {
            staff = Staffbuf.Staff.parseFrom(data);
            System.out.println(staff.getName());
            staff.getPhoneList().forEach( x -> System.out.println(x.toString()));
            System.out.println(staff.getMap().getKey());
            System.out.println(staff.getMap().getValue());
        } catch (InvalidProtocolBufferException e) {
            e.printStackTrace();
        }


        String jsonFormatM = "";
        try {
            jsonFormatM = JsonFormat.printer().print(staff);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(jsonFormatM.toString());
        System.out.println("json数据大小：" + jsonFormatM.getBytes().length);
        System.out.println("=====  转成json对象结束 =====");
    }
}
