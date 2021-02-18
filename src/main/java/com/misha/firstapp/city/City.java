package com.misha.firstapp.city;

import java.util.HashMap;
import java.util.Map;

public class City {

    Map<String, Integer> citizens;

    public City() {
        citizens = new HashMap<String, Integer>();
    }

    public void addCitizen(String name, Integer age) {
        citizens.put(name, age);
    }

    public int citizensCount() {
        return citizens.size();
    }

    public Map.Entry<String, Integer> getOldestCitizen() {
        return citizens.entrySet().stream().max(Map.Entry.comparingByValue()).get();
    }

    //    /**
//     * Citizens of a city, key is the name, value is age
//     */
//    private Map<String, Integer> citizens = new HashMap<>();
//
//    public void addCitizen(String name, int age) {
//        citizens.put(name, age);
//    }
//
//    /**
//     * Returns number of citizens in the city
//     * @return
//     */
//    public int getCitizensCount() {
//        return 0; //todo
//    }
//
//    /**
//     * Returns oldest citizen in the city
//     * @return the oldest citizen in the City in format where key is name, value is age
//     */
//    public Map.Entry<String, Integer> getOldestCitizen() {
//        return null; //todo
//    }
//
    /**
     * Returns citizens within age groups:
     * CHILDREN age 0-18
     * ADULTS age 18-65
     * RETIREES age 65 - max integer
     * @return returns Map of citizens
     */
    public Map<Group, Map<String, Integer>> getAgeGroups() {
        Map<Group, Map<String, Integer>> result = new HashMap<>();
        for (Map.Entry<String, Integer> citizen : citizens.entrySet()) {
            if (citizen.getValue() < 18) {
                if (result.containsKey(Group.CHILDREN)) {
                    result.get(Group.CHILDREN).put(citizen.getKey(), citizen.getValue());
                } else {
                    Map<String, Integer> hashMap = new HashMap<>();
                    hashMap.put(citizen.getKey(), citizen.getValue());
                    result.put(Group.CHILDREN, hashMap);
                }
            }

            else if (citizen.getValue() < 66){
           if (result.containsKey(Group.ADULTS)){
               result.get(Group.ADULTS).put(citizen.getKey(), citizen.getValue());
           }
           else {
               Map<String, Integer> hashMap = new HashMap<>();
               hashMap.put(citizen.getKey(), citizen.getValue());
               result.put(Group.ADULTS, hashMap);
           }
            }

            else {
                if (result.containsKey(Group.RETIREES)){
                    result.get(Group.RETIREES).put(citizen.getKey(), citizen.getValue());
                }
                else {
                    Map<String, Integer> hashMap = new HashMap<>();
                    hashMap.put(citizen.getKey(), citizen.getValue());
                    result.put(Group.RETIREES, hashMap);
                }
            }
        }
        return result;
    }

    enum Group {
        CHILDREN(0, 17),
        ADULTS(18, 65),
        RETIREES(66, Integer.MAX_VALUE);

        private final int minAge;
        private final int maxAge;

        Group(int minAge, int maxAge) {
            this.minAge = minAge;
            this.maxAge = maxAge;
        }
    }
}