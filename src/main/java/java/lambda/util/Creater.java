package java.lambda.util;


import java.lambda.entity.User;
import java.util.ArrayList;
import java.util.List;

public class Creater {
    private Creater() {
    }


    public static List<User> initUsers(){
        List<User> users = new ArrayList<>();
        users.add(new User(1L,"wangyingjie", 18, (byte) 1, "北京"));
        users.add(new User(2L,"jiaxuanxuan", 18, (byte) 0, "北京"));
        users.add(new User(3L,"jialing", 30, (byte) 0, "上海"));
        users.add(new User(4L,"gaoxiaosong", 10, (byte) 1, "杭州"));
        users.add(new User(5L,"xiaohei", 20, (byte) 1, "北京"));
        users.add(new User(6L,"wanghaha", 40, (byte) 1, "天津"));
        users.add(new User(7L,"gaoyong", 18, (byte) 1, "北京"));
        users.add(new User(8L,"jinpeng", 16, (byte) 1, "北京"));
        users.add(new User(9L,"wangyajie", 15, (byte) 1, "成都"));
        users.add(new User(10L,"wangjianguo", 10, (byte) 1, "南宁"));
        users.add(new User(11L,"zhangdeheng", 14, (byte) 1, "沈阳"));
        users.add(new User(12L,"wangyingjie", 14, (byte) 1, "沈阳"));

        return users;
    }
}
