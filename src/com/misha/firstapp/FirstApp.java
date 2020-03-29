package com.misha.firstapp;

import com.misha.firstapp.model.User;
import com.misha.firstapp.security.AuthorizationService;
import com.misha.firstapp.security.UserRepo;
import com.misha.firstapp.userinterface.AdminMenu;

import java.util.Scanner;

import static com.misha.firstapp.model.UserType.ADMIN;
import static com.misha.firstapp.model.UserType.WARIENICHEK;
import static com.misha.firstapp.security.UserRepo.USER_REPO;

public class FirstApp {
    private static UserRepo userRepo = USER_REPO;
    private static AuthorizationService authorizationService = new AuthorizationService(userRepo);
    private static AdminMenu adminMenu = new AdminMenu(userRepo);

    public static void main(String[] args) {
        if (userRepo.getUserByLogIn("lizka") == null) {
            User admin = new User("liza", "lastname", "lizka", "1111", (byte) 2, (byte) 2, ADMIN);
            userRepo.addUser(admin);
        }

        if (userRepo.getUserByLogIn("biba") == null) {
            User biba = new User("biba", "lastname", "biba", "1112", (byte) 2, (byte) 2, WARIENICHEK);
            userRepo.addUser(biba);
        }

        System.out.println("login");
        Scanner ssscanner = new Scanner(System.in);
        String logIn = ssscanner.nextLine();
        System.out.println("password");
        String passwordArray = ssscanner.nextLine();

        User authorizedUser = authorizationService.authorize(logIn, passwordArray);
        if (authorizedUser == null) {
            System.out.println("Oshybka autoricacii");
        } else {
            System.out.println("Welcome dear, " + authorizedUser.getFirstName());
            if (authorizedUser.getUserType() == ADMIN) {
                adminMenu.showMenu();
                String option = ssscanner.nextLine();
                adminMenu.showSubMenu(option);
            }
        }


    }
}


