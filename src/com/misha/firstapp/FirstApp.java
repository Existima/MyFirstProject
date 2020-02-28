package com.misha.firstapp;

import com.misha.firstapp.model.User;
import com.misha.firstapp.model.UserType;
import com.misha.firstapp.security.AuthorizationService;
import com.misha.firstapp.security.UserRepo;

import java.util.Scanner;

public class FirstApp {
    private static UserRepo userRepo = UserRepo.getUserRepo();
    private static AuthorizationService authorizationService = new AuthorizationService(userRepo);

    public static void main(String[] args) {

        User admin = new User("liza", "lastname", "lizka", "1111", (byte) 2, (byte) 2, UserType.ADMIN);


//        System.out.println("\n firstName:" + admin.getFirstName() + "\n last name:" + admin.getLastName() + "\n age: "
//                + admin.getAge() + "\n hands count:" + admin.getHandsCount() + "\n login: " + admin.getLogIn()
//                + "\n password: " + admin.getPassword() );
        userRepo.addUser(admin);

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
        }


    }

    // Object adminObject = admin;

    // System.out.println("admin is of type" + adminObject.getClass());
    //System.out.println("admin is of type user" + (adminObject instanceof User));
    //System.out.println("admin is of type object" + (adminObject instanceof Object));
    //System.out.println("admin is of type integer" + (adminObject instanceof Integer));
    //System.out.println("admin is adminObject: " + adminObject.equals(admin));
    //System.out.println("" + admin);
}


