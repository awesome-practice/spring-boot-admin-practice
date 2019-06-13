package com.practice.springbootadmin.client.config.external;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author Luo Bao Ding
 * @since 2018/6/23
 */
@Component
public class RoleProperty {
    @Value("${role:admin default}")
    private String role;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
