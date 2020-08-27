package test;

import java.io.*;

/**
 * @Description:
 * @ProjectName: a-big-dream
 * @Package: nowcoder.dzq
 * @ClassName: TestSerializable
 * @Author: dongzeqi
 * @Date: 2020/8/27 23:32
 * @Version: 1.0
 */
public class SimpleSerial {

    public static void main(String[] args) throws Exception {
        File file = new File("person.out");

        ObjectOutputStream oout = new ObjectOutputStream(new FileOutputStream(file));
        Person person = new Person("John", 101, Gender.MALE);
        oout.writeObject(person);
        oout.close();

        ObjectInputStream oin = new ObjectInputStream(new FileInputStream(file));
        Object newPerson = oin.readObject(); // 没有强制转换到Person类型
        oin.close();
        System.out.println(newPerson);
    }
}
