package com.javaserver.server.users.UserDto;

import java.io.Serializable;

public class UserDto implements Serializable {
    final Long ID;
    final String User;
    final String Name;
    final String LastName;

    public UserDto(Long Id, String user, String name, String Lastname) {
        ID = Id;
        User = user;
        Name = name;
        LastName = Lastname;
    }

    public Long getID() {
        return ID;
    }

    public String getUser() {
        return User;
    }

    public String getName() {
        return Name;
    }

    public String getLastName() {
        return LastName;
    }
}
