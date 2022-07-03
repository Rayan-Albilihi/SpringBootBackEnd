package com.example.demo.entitiy;

import lombok.*;

@Getter
@Setter
@ToString
public class User {
    private long id;
    private String name;
    private String email;
    private Integer age;


    public User() {
    }

    public User(long id,
                String name,
                String email,
                Integer age) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
    }

    public User(String name,
                String email,
                Integer age) {
        this.name = name;
        this.email = email;
        this.age = age;
    }
}
