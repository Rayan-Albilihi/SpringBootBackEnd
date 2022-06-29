package com.example.demo.firstProj;

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

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Integer getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "user{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                '}';
    }
}
