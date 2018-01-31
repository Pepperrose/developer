package com.groges.developer.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author:xiewt
 * @Description: 用户实体类
 * @Date:Create in 2018/1/31 15:32
 * @Modify By:
 */
@Data
public class User implements Serializable {
    private static final long serializableUID = 1L;
    private Long id;            //用户ID
    private String username;    //用户名
    private String password;    //密码
    private String salt;        //盐值
    private Boolean locked = Boolean.FALSE; //是否锁定

    //剩余字段之后再加入

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != null ? !id.equals(user.id) : user.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
