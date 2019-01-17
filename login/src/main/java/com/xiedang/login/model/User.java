package com.xiedang.login.model;

/**
 *
 * @author xiedang
 * @date 2016/12/9
 */
public class User implements java.io.Serializable {
    private static final long serialVersionUID = 19940306L;
    private Integer userId;
    private  String username;
    private String passwd;

    public User(Integer userId,String passwd, String username) {
        this.userId = userId;
        this.passwd = passwd;
        this.username = username;
    }

    public User() {
    }

    public User(String username, String passwd) {
        this.username = username;
        this.passwd = passwd;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }


    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", passwd='" + passwd + '\'' +
                '}';
    }
}
