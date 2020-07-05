package javava.lambda.entity;

import lombok.Data;

@Data
public class User {
    private Long id;
    private String name;
    private Integer age;
    private Byte sex;
    private String address;

    public User() {
    }

    public User(Long id, String name, Integer age, Byte sex, String address) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.address = address;
    }
}
