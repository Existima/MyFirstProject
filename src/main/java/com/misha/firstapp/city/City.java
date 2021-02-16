package com.misha.firstapp.city;

import java.util.HashMap;
import java.util.Map;

public class City {
    private Map<String, Integer> citizens = new HashMap();

    public void addCitizen(String name, int age) {
        citizens.put(name, age);
    }

    public int getCitizensCount() {
        return citizens.size();
    }

    public Map.Entry<String, Integer> getOldestCitizen() {
        return null;
    }
}