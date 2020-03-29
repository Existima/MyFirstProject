package com.misha.firstapp.model;

public enum UserType {
    ADMIN, WARIENICHEK;

    public static UserType fromNumber(String choosenOption) throws Exception {
        if (choosenOption.equals("1")) {
            return UserType.ADMIN;
        } else if (choosenOption.equals("2")) {
            return UserType.WARIENICHEK;
        } else {
            throw new Exception("Неправильный выбор ");
        }
    }
};