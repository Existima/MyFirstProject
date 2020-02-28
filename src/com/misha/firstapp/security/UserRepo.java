package com.misha.firstapp.security;

import com.misha.firstapp.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepo {
    private static final UserRepo USER_REPO = new UserRepo();

    private List<User> userList = new ArrayList();

    private UserRepo() {

    }


    public void addUser(User user) {
        userList.add(user);
    }

    public User getUserByLogIn(String logIn) {
        for (User user : userList) {
            if (user.getLogIn().equals(logIn)) {
                return user;
            }
        }
        return null;
    }

    public static UserRepo getUserRepo() {
        return USER_REPO;
    }
}
