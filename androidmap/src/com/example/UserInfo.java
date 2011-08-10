package com.example;

/**
 * Created by IntelliJ IDEA.
 * User: sunqipeng
 * Date: 11-8-9
 * Time: 下午3:00
 * To change this template use File | Settings | File Templates.
 */
public class UserInfo {
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;
    private int age;
}
