package com.serhii.model.dto.userdto;

import com.serhii.model.entity.Role;

import java.util.Set;

public class RegistrationUserDTO {
    private String login;
    private String password;
    private Set<Role> roles;

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public String toString() {
        return "RegistrationUserDTO{" +
                "login='" + login + '\'' +
                ", roles=" + roles +
                '}';
    }
}
