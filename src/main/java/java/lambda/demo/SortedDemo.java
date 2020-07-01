package java.lambda.demo;


import java.lambda.entity.User;
import java.lambda.util.Creater;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortedDemo {
    public static void main(String[] args) {
        List<User> users = Creater.initUsers();

        //找出以wang开头的用户，并年龄倒叙排序
        List<User> list = users.stream()
                .filter(u -> u.getName().startsWith("wang")) //找出名字以 wang 开头的用户
                .sorted(Comparator.comparing(User::getAge).reversed()) //按照年龄倒序排序 reversed() 倒序
                .collect(Collectors.toList()); //转化为list

        //打印
        list.stream().forEach(u -> System.out.println(u.getName() + "_" + u.getAge()));
    }
}
