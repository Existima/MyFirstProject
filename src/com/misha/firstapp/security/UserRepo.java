package com.misha.firstapp.security;

import com.misha.firstapp.model.User;
import com.misha.firstapp.model.UserType;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class UserRepo {
    public static final UserRepo USER_REPO = new UserRepo(new ArrayList<>());
    private static final String FILE_NAME = "user-library.txt";
    private final Path file = Paths.get(FILE_NAME);

    private List<User> userList;

    private UserRepo(List<User> list) {
        userList = list;
        initialize();
    }

    private void initialize() {
        if (Files.notExists(file)) {
            try {
                Files.createFile(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        reloadFile();
    }

    public User addUser(User user) {
        for(User userFromRepo : userList){
            if(user.getLogIn().equals(userFromRepo.getLogIn())){
                System.out.println("Can't create user, user with the same login already exists");
                return userFromRepo;
            }
        }
        userList.add(user);
        rewriteFile();
        return user;
    }

    public List<User> getAllUsers(){
        return userList;
    }

    public User getUserByLogIn(String logIn) {
        for (User user : userList) {
            if (user.getLogIn().equals(logIn)) {
                return user;
            }
        }
        return null;
    }

    public boolean deleteUser(User пользовательFromRepo) {
        boolean result = userList.remove(пользовательFromRepo);
        rewriteFile();
        return result;
    }

    private void rewriteFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file.toFile(), false))) {
            for (User user : userList) {
                writer.write(user.toString());
                writer.newLine();
            }
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void reloadFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(file.toFile()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                userList.add(parseUser(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private User parseUser(String line) {
        String[] args = line.split(",");
        try {
            return new User(args[0], args[1], args[2], args[3], Byte.parseByte(args[4]), Byte.parseByte(args[5]), UserType.valueOf(args[6]));
        } catch (Exception e) {
            return new User(args[0], args[1], args[2], args[3], Byte.parseByte(args[4]), Byte.parseByte(args[5]), UserType.WARIENICHEK);
        }
    }
}
