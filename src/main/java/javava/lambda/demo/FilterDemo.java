package javava.lambda.demo;


import javava.lambda.entity.User;
import javava.lambda.util.Creater;
import java.util.List;
import java.util.stream.Collectors;

public class FilterDemo {
    public static void main(String[] args) {
        List<User> users = Creater.initUsers();

        //过滤年龄大于18且是女性的用户
        List<User> collect = users.stream()
                .filter(u -> u.getAge() > 18 && u.getSex() == 0)
                .collect(Collectors.toList());
        //打印
        collect.stream().forEach(u -> System.out.println(u.getName()));
    }
}
