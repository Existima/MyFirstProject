package com.misha.firstapp.security;

import com.misha.firstapp.model.User;

public class AuthorizationService {
    private final UserRepo userRepo;

    public AuthorizationService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }





    public User authorize(String login, String password) {
        User userThatWeGotFromRepo = userRepo.getUserByLogIn(login);
        if (userThatWeGotFromRepo != null && userThatWeGotFromRepo.getPassword().equals(password)) {
            return userThatWeGotFromRepo;
        } else {
            return null;

        }

    }


}
