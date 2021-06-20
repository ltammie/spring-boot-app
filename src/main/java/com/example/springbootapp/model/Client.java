package com.example.springbootapp.model;

import java.util.Date;

public class Client {
    private Long clientId;

    private String name;

    private String surname;

    private Date birthday;

    public Client() {
    }

    public Client(Long clientId, String name, String surname, Date birthday) {
        this.clientId = clientId;
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Client{" +
                "clientId=" + clientId +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}
