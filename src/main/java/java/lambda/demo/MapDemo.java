package java.lambda.demo;



import java.lambda.entity.User;
import java.lambda.util.Creater;
import java.util.List;
import java.util.stream.Collectors;

public class MapDemo {
    public static void main(String[] args) {
        List<User> users = Creater.initUsers();

        /**
         * 取出所有用户的名字并去重
         */
        List<String> userNames = users.stream()
                .map(User::getName)//取出用户名   User::getName  和  u —> u.getName() 一样
                .distinct()//去重
                .collect(Collectors.toList());
        //打印
        userNames.stream().forEach(System.out::println);


        System.out.println("-------------------------");


        /**
         * 取出所有用户的名字，去重，并转换成大写
         */
        List<String> userUpperCaseNames = users.stream()
                .map(User::getName)//取出用户名
                .distinct()//去重
                .map(String::toUpperCase)//转换成大写
                .collect(Collectors.toList());
        //打印
        userUpperCaseNames.stream().forEach(System.out::println);


        System.out.println("-------------------------");

        /**
         * 取出每个名字的长度
         */
        List<Integer> userNameLengths = users.stream()
                .map(User::getName)//取出用户名
                .map(String::length)//取名字的长度
                .collect(Collectors.toList());

        //打印
        userNameLengths.stream().forEach(System.out::println);


        System.out.println("-------------------------");

        /**
         * 给每个人的年龄增加1，并将姓名 修改为 姓名+id
         */

        List<User> collect = users.stream()
                .map(u -> {
                    u.setAge(u.getAge() + 1);
                    u.setName(u.getName() + u.getId());
                    return u;
                })  // u 是参数  {} 中的是函数体
                .collect(Collectors.toList());

        //peek和map的区别
        /*List<User> collect2 = users.stream()
                .peek(user -> {
                    user.setAge(user.getAge() + 1);
                    user.setName(user.getName() + user.getId());
                })//使用peek 可以不用return
                .collect(Collectors.toList());*/
        //打印
        collect.stream().forEach(u -> System.out.println(u.getId() + "_" + u.getName() + "_" + u.getAge()));
    }
}
