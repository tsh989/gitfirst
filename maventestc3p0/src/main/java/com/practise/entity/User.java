package com.practise.entity;

/**
 * @Auther: tsh
 * @program: tianshuo
 * @Description: User类
 * @Date: 2020/7/10 13:28
 **/
public class User {
    /**username*/
    private String username;
    /**password*/
    private String password;
    /**email*/
    private String email;
    /**phone*/
    private String phone;
    /**register_time*/
    private String register_time;
    /**modify_time*/
    private String modify_time;
    private Integer flag=0;

    public User() {
    }

    public User(String username) {
        this.username = username;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(String username, String password, String email, String phone) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone = phone;
    }

    public User(String username, String password, String email, String phone, String register_time, String modify_time) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.register_time = register_time;
        this.modify_time = modify_time;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRegister_time() {
        return register_time;
    }

    public void setRegister_time(String register_time) {
        this.register_time = register_time;
    }

    public String getModify_time() {
        return modify_time;
    }

    public void setModify_time(String modify_time) {
        this.modify_time = modify_time;
    }

    public void set(String username,String password,String email,String phone,
                    String register_time,String modify_time){
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.register_time = register_time;
        this.modify_time = modify_time;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", phone=" + phone +
                ", register_time='" + register_time + '\'' +
                ", modify_time='" + modify_time + '\'' +
                '}';
    }
}
