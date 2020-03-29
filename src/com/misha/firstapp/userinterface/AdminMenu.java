package com.misha.firstapp.userinterface;

import com.misha.firstapp.model.User;
import com.misha.firstapp.model.UserType;
import com.misha.firstapp.security.UserRepo;

import java.util.Scanner;

import static com.misha.firstapp.model.UserType.WARIENICHEK;

public class AdminMenu {
    private final UserRepo библиотекаНомер1;

    public AdminMenu(UserRepo библиотекаНомер1) {
        this.библиотекаНомер1 = библиотекаНомер1;
    }

    public void showMenu() {
        System.out.println("Choose option:");
        System.out.println("1) Create new user");
        System.out.println("2) Find user option");
        System.out.println("3) Update user ");
        System.out.println("4) Delete user");
    }

    public void showSubMenu(String option) {
        switch (option) {
            case "1":
                createUserMenu();
                break;
            case "2":
                findUserMenu();
                break;
            case "3":
                updateUserMenu();
                break;
            case "4":
                deleteUser();
        }
    }

    private void deleteUser() {
        System.out.println("Enter login: ");
        Scanner sscanner = new Scanner(System.in);
        String login = sscanner.nextLine();
        User пользовательFromRepo = библиотекаНомер1.getUserByLogIn(login);
        System.out.println("Удаляю пользователя: " + пользовательFromRepo.getFirstName());
        boolean удалено = библиотекаНомер1.deleteUser(пользовательFromRepo);
        if (удалено) {
            System.out.println("Пользователь " + пользовательFromRepo.getFirstName() + " уничтожен!");
        } else {
            System.out.println("Не могу уничтожить ((((");
        }

    }

    private void updateUserMenu() {
        Scanner sscaner = new Scanner(System.in);
        System.out.println("Введи логин пользователя для изминений: ");
        String login = sscaner.nextLine();
        User пользовательFromRepo = библиотекаНомер1.getUserByLogIn(login);
        System.out.println("Меняем пароль (****)");
        String пароль = sscaner.nextLine();
        пользовательFromRepo.setPassword(пароль);
        System.out.println("Новое имя (" + пользовательFromRepo.getFirstName() + "):");
        String имя = sscaner.nextLine();
        пользовательFromRepo.setFirstName(имя);
        библиотекаНомер1.addUser(пользовательFromRepo);
    }

    private void findUserMenu() {
        System.out.println("Enter login: ");
        Scanner sscanner = new Scanner(System.in);
        String login = sscanner.nextLine();
        User пользовательFromRepo = библиотекаНомер1.getUserByLogIn(login);
        System.out.println("Найден польззователь: ");
        System.out.println(пользовательFromRepo);
    }

    private void createUserMenu() {
        Scanner sscanner = new Scanner(System.in);

        System.out.println("Придумай себе логин: ");
        String login = sscanner.nextLine();

        System.out.println("Придумай пароль: ");
        String password = sscanner.nextLine();

        System.out.println("Укажи своё имя: ");
        String firstName = sscanner.nextLine();

        System.out.println("Укажи фамилию: ");
        String lastName = sscanner.nextLine();

        System.out.println("Укажи свой возраст: ");
        String age = sscanner.nextLine();

        System.out.println("Сколько у тебя рук? ");
        String handsCount = sscanner.nextLine();

        System.out.println("Выбери права доступа:");
        System.out.println("1) Admin");
        System.out.println("2) Вареничек");
        String userTypeString = sscanner.nextLine();
        UserType userType;
        try {
            userType = UserType.fromNumber(userTypeString);
        } catch (Exception e) {
            userType = WARIENICHEK;
        }

        User newUser1 = new User(firstName, lastName, login, password, Byte.valueOf(age), Byte.valueOf(handsCount), userType);
        библиотекаНомер1.addUser(newUser1);


        System.out.println("Создан новый ппользователь: " + newUser1);
    }
}
