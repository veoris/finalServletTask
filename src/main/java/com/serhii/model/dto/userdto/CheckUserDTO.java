package com.serhii.model.dto.userdto;


public class CheckUserDTO {
    private String login;
    private String password;
    private int teamId;

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
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
        return "CheckUserDTO{" +
                "login='" + login + '\'' +
                "team id='" + teamId + '\'' +
                '}';
    }
}
