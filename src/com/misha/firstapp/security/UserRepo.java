package com.misha.firstapp.security;

import com.misha.firstapp.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepo {
    private static final UserRepo USER_REPO = new UserRepo(new ArrayList<>());

    private List<User> userList;

    private UserRepo(List<User> list) {
        userList = list;
    }


    public User addUser(User user) {
        userList.add(user);
        return user;
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

    public boolean deleteUser(User пользовательFromRepo) {
        return userList.remove(пользовательFromRepo);
    }
    }
