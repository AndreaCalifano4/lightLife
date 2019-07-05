package com.example.prova.lightlife;

import java.io.Serializable;

public class User implements Serializable {
    public String id;
    public String surname;
    public String userName;
    public String soul;
    public String email;
    public String password;

    public User(String id, String surname, String userName, String soul, String email, String password) {
        this.id = id;
        this.surname = surname;
        this.userName = userName;
        this.soul = soul;
        this.email = email;
        this.password = password;
    }

}