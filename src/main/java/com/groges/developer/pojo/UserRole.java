package com.groges.developer.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author:xiewt
 * @Description:
 * @Date:Create in 2018/1/31 15:44
 * @Modify By:
 */
@Data
public class UserRole implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long userId;
    private Long roleId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserRole userRole = (UserRole) o;

        if (roleId != null ? !roleId.equals(userRole.roleId) : userRole.roleId != null) return false;
        if (userId != null ? !userId.equals(userRole.userId) : userRole.userId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId != null ? userId.hashCode() : 0;
        result = 31 * result + (roleId != null ? roleId.hashCode() : 0);
        return result;
    }
}
