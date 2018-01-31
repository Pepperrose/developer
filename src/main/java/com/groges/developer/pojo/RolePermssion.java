package com.groges.developer.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author:xiewt
 * @Description:
 * @Date:Create in 2018/1/31 15:46
 * @Modify By:
 */
@Data
public class RolePermssion implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long roleId;
    private Long permissionId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RolePermssion that = (RolePermssion) o;

        if (permissionId != null ? !permissionId.equals(that.permissionId) : that.permissionId != null) return false;
        if (roleId != null ? !roleId.equals(that.roleId) : that.roleId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = roleId != null ? roleId.hashCode() : 0;
        result = 31 * result + (permissionId != null ? permissionId.hashCode() : 0);
        return result;
    }
}
