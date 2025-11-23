package com.bite.springdemo.model;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: YY_ang
 * Date: 2025-08-18
 * Time: 22:15
 */

//在Java中，成员变量（实例变量和类变量）如果不显式初始化，会有默认值。具体默认值取决于变量的类型
public class UserInfo {
    private String name;
    private Integer gender;
    private Integer age;

    public UserInfo() {
    }

    public UserInfo(String name, Integer age, Integer gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "name='" + name + '\'' +
                ", gender=" + gender +
                ", age=" + age +
                '}';
    }
}
