package com.misha.firstapp.city;

import java.util.*;

public class City {

    /**
     * Citizens of a city, key is the name, value is age
     */
    private List<Citizen> citizens = new LinkedList<>();
    private List<House> houses = new LinkedList<>();

    public void addCitizen(Citizen citizen) {
        citizens.add(citizen);
    }

    /**
     * this method populates com.misha.firstapp.city.City#houses with inhabitants
     * CHILD must live with at least one ADULT
     * algorithm must use the biggest amount of available houses in order not to overpopulate living house)
     * populate priority according to alphabetical address of the house, addresses starting from A populate first,
     * then move to the next until Z
     * Remember that max inhabitants count is limited to 3
     * Make sure all children populated
     */
    public void populateHouses() {

        List<Citizen> childList = new LinkedList<>();
        List<Citizen> adultList = new LinkedList<>();
        List<Citizen> retireesList = new LinkedList<>();
        for (Citizen citizen : citizens) {
            if (citizen.getAge() < Group.CHILDREN.maxAge && citizen.getAge() > Group.CHILDREN.minAge) {
                childList.add(citizen);
            } else if (citizen.getAge() < Group.ADULTS.maxAge && citizen.getAge() > Group.ADULTS.minAge) {
                adultList.add(citizen);
            } else {
                retireesList.add(citizen);
            }
        }

        for (Citizen c : childList) {
            House houseWithAdult = getLeastPopulatedHouse();
            houseWithAdult.addInhabitant(c);
            houseWithAdult.addInhabitant(adultList.remove(0));
        }

        for (Citizen a : adultList) {
            getLeastPopulatedHouse().addInhabitant(a);
        }

        for (Citizen r : retireesList) {
            getLeastPopulatedHouse().addInhabitant(r);
        }
    }

    public void addHouse(House house) {
        houses.add(house);
    }

    /**
     * resulted set must return houses in its address alphabetical order
     *
     * @return
     */

    public Set<House> getHouses() {
        return new TreeSet<>(houses);
    }

    /**
     * This method must return first least populated house in the city, first means first in alphabetical order
     */
    public House getLeastPopulatedHouse() {

        House h = null;

        for (House house : houses) {
            if (h == null) {
                h = house;
            } else {
                int popResult = h.getInhabitants().size() - house.getInhabitants().size();
                if (popResult == 0) {
                    int alfResult = h.compareTo(house);
                    if (alfResult > 0) {
                        h = house;
                    }
                } else if (popResult > 0) {
                    h = house;
                }
            }
        }
        return h;
/**
 * analogia
 */
//        return houses.stream().
//                min((house1, house2) -> {
//                    int newResult = house1.getInhabitants().size() - house2.getInhabitants().size();
//                    if (newResult == 0) {
//                        return house1.compareTo(house2);
//                    } else {
//                        return newResult;
//                    }
//                }).
//                get();
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
    public Citizen getOldestCitizen() {
        return citizens.stream().max(Comparator.comparing(Citizen::getAge)).get();
    }

    /**
     * Returns citizens within age groups:
     * CHILDREN age 0-18
     * ADULTS age 18-65
     * RETIREES age 65 - max integer
     *
     * @return returns Map of citizens
     */
    public Map<Group, List<Citizen>> getAgeGroups() {
        Map<Group, List<Citizen>> result = new HashMap<>();
        for (Citizen citizen : citizens) {
            if (citizen.getAge() < 18) {
                if (result.containsKey(Group.CHILDREN)) {
                    result.get(Group.CHILDREN).add(citizen);
                } else {
                    List<Citizen> list = new LinkedList<>();
                    list.add(citizen);
                    result.put(Group.CHILDREN, list);
                }
            } else if (citizen.getAge() < 66) {
                if (result.containsKey(Group.ADULTS)) {
                    result.get(Group.ADULTS).add(citizen);
                } else {
                    List<Citizen> list = new LinkedList<>();
                    list.add(citizen);
                    result.put(Group.ADULTS, list);
                }
            } else {
                if (result.containsKey(Group.RETIREES)) {
                    result.get(Group.RETIREES).add(citizen);
                } else {
                    List<Citizen> list = new LinkedList<>();
                    list.add(citizen);
                    result.put(Group.RETIREES, list);
                }
            }
        }
        return result;
    }

    enum Group {
        CHILDREN(0, 17),
        ADULTS(18, 65),
        RETIREES(66, Integer.MAX_VALUE);

        public final int minAge;
        public final int maxAge;

        Group(int minAge, int maxAge) {
            this.minAge = minAge;
            this.maxAge = maxAge;
        }

        public int getMinAge() {
            return minAge;
        }

        public int getMaxAge() {
            return maxAge;
        }
    }
}