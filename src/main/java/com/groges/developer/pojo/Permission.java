package com.groges.developer.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author:xiewt
 * @Description:
 * @Date:Create in 2018/1/31 15:40
 * @Modify By:
 */
@Data
public class Permission implements Serializable {
    private static final long serializableUID = 1L;
    private Long id;
    private String permission;  //权限标识 程序中判断使用,如"user:create"
    private String description; //权限描述,UI界面显示使用
    private Boolean available = Boolean.FALSE; //是否可用,如果不可用将不会添加给用户

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Permission role = (Permission) o;

        if (id != null ? !id.equals(role.id) : role.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
