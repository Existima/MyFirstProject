package com.misha.firstapp.city;

import java.util.HashMap;
import java.util.Map;

public class City {
    /**
     * Citizens of a city, key is the name, value is age
     */
    private Map<String, Integer> citizens = new HashMap<>();

    public void addCitizen(String name, int age) {
        citizens.put(name, age);
    }

    /**
     * Returns number of citizens in the city
     * @return
     */
    public int getCitizensCount() {
        return 0; //todo
    }

    /**
     * Returns oldest citizen in the city
     * @return the oldest citizen in the City in format where key is name, value is age
     */
    public Map.Entry<String, Integer> getOldestCitizen() {
        return null; //todo
    }

    /**
     * Returns citizens within age groups:
     * CHILDREN age 0-18
     * ADULTS age 18-65
     * RETIREES age 65 - max integer
     * @return returns Map of citizens
     */
    public Map<Group, Map<String, Integer>> getAgeGroups(){
        return null; //todo
    }

    enum Group{
        CHILDREN(0, 18),
        ADULTS(18,65),
        RETIREES(65, Integer.MAX_VALUE);

        private final int minAge;
        private final int maxAge;

        Group(int minAge, int maxAge) {
            this.minAge = minAge;
            this.maxAge = maxAge;
        }
    }
}