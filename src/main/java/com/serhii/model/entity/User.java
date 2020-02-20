package com.serhii.model.entity;

import java.util.HashSet;
import java.util.Set;

public class User {
    private int id;
    private String login;
    private String password;
    private Set<Role> roles;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login=" + login +
                '}';
    }

    public static Builder builder() {
        return new User().new Builder();
    }

    public class Builder {
        private Builder() {

        }

        public Builder login(String login) {
            User.this.login = login;
            return this;
        }

        public Builder id(int id) {
            User.this.id = id;
            return this;
        }

        public Builder password(String password) {
            User.this.password = password;
            return this;
        }


        public Builder role(Set<Role> roles) {
            User.this.roles = new HashSet<>(roles);
            return this;
        }

        public User build() {
            return User.this;
        }
    }
}
