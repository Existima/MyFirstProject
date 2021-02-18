package com.misha.firstapp.city;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class City {

    /**
     * Citizens of a city, key is the name, value is age
     */
    private Map<String, Integer> citizens = new HashMap<>();
    private List<House> houses = new LinkedList<>();

    public void addCitizen(String name, int age) {
        citizens.put(name, age);
    }

    /**
     * this method populates com.misha.firstapp.city.City#houses with inhabitants
     * CHILD must live with at least one ADULT
     * algorithm must use the biggest amount of available houses in order not to overpopulate living house)
     * populate priority according to alphabetical address of the house, addresses starting from A populate first,
     * then move to the next until Z
     * Remember that max inhabitants count is limited to 3
     */
    public void populateHouses() {
        //todo
    }

    public void addHouse(House house) {
        //todo
    }

    /**
     * resulted set must return houses in its address alphabetical order
     *
     * @return
     */
    public Set<House> getHouses() {
        return null;//todo
    }

    /**
     * This method must return first least populated house in the city, first means first in alphabetical order
     */
    public House getLeastPopulatedHouse(){
        return null; //todo
    }

    /**
     * Returns number of citizens in the city
     *
     * @return
     */
    public int getCitizensCount() {
        return citizens.size();
    }

    /**
     * Returns oldest citizen in the city
     *
     * @return the oldest citizen in the City in format where key is name, value is age
     */
    public Map.Entry<String, Integer> getOldestCitizen() {
        return citizens.entrySet().stream().max(Map.Entry.comparingByValue()).get();
    }

    /**
     * Returns citizens within age groups:
     * CHILDREN age 0-18
     * ADULTS age 18-65
     * RETIREES age 65 - max integer
     *
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
            } else if (citizen.getValue() < 66) {
                if (result.containsKey(Group.ADULTS)) {
                    result.get(Group.ADULTS).put(citizen.getKey(), citizen.getValue());
                } else {
                    Map<String, Integer> hashMap = new HashMap<>();
                    hashMap.put(citizen.getKey(), citizen.getValue());
                    result.put(Group.ADULTS, hashMap);
                }
            } else {
                if (result.containsKey(Group.RETIREES)) {
                    result.get(Group.RETIREES).put(citizen.getKey(), citizen.getValue());
                } else {
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