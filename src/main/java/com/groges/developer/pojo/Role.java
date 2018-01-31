package com.groges.developer.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author:xiewt
 * @Description:
 * @Date:Create in 2018/1/31 15:37
 * @Modify By:
 */
@Data
public class Role implements Serializable {
    private static final long serializableUID = 1L;
    private Long id;
    private String role;        //角色标志 程序中判断使用,如"admin"
    private String description; //角色描述,UI界面显示使用
    private Boolean available = Boolean.FALSE; //是否可用,如果不可用将不会添加给用户

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Role role = (Role) o;

        if (id != null ? !id.equals(role.id) : role.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

}
