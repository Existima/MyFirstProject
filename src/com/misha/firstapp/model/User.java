package com.misha.firstapp.model;

import java.util.Objects;

public class User {
    private String firstName;
    private String lastName;
    private String logIn;
    private String password;
    private Byte age;
    private byte handsCount;
    private UserType userType;

    public User(String firstName, String lastName, String logIn, String password, Byte age, byte handsCount, UserType userType) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.logIn = logIn;
        this.password = password;
        this.age = age;
        this.handsCount = handsCount;
        this.userType = userType;
    }


    public User() {
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getLogIn() {
        return logIn;
    }

    public String getPassword() {
        return password;
    }

    public Byte getAge() {
        return age;
    }

    public byte getHandsCount() {
        return handsCount;
    }


    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setLogIn(String logIn) {
        this.logIn = logIn;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAge(Byte age) {
        this.age = age;
    }

    public void setHandsCount(byte handsCount) {
        this.handsCount = handsCount;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return handsCount == user.handsCount &&
                Objects.equals(firstName, user.firstName) &&
                Objects.equals(lastName, user.lastName) &&
                Objects.equals(logIn, user.logIn) &&
                Objects.equals(password, user.password) &&
                Objects.equals(age, user.age) &&
                userType == user.userType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, logIn, password, age, handsCount, userType);
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", logIn='" + logIn + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", handsCount=" + handsCount +
                ", userType=" + userType +
                '}';
    }
}