package com.misha.firstapp.city;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CityTest {
    @Test
    public void citizenCountTest() {
        //given
        City testCity = new City();
        testCity.addCitizen("Bilbo", 24);
        testCity.addCitizen("Gendalf", 305);
        testCity.addCitizen("Frodo", 3);

        //when
        int citizenCount = testCity.citizensCount();

        //then
        assertEquals(3, citizenCount);
    }

    @Test
    public void oldestCitizenTest() {
        //given
        City testCity = new City();
        testCity.addCitizen("Bilbo", 24);
        testCity.addCitizen("Gendalf", 305);
        testCity.addCitizen("Frodo", 3);

        //when
        Map.Entry<String, Integer> citizen = testCity.getOldestCitizen();

        //then
        assertEquals("Gendalf", citizen.getKey());
        assertEquals(305, citizen.getValue());
    }

    @Test
    public void getAgeGroupsTest() {
        //given
        City testCity = new City();
        testCity.addCitizen("Bilbo", 24);
        testCity.addCitizen("Gendalf", 305);
        testCity.addCitizen("Arven", 295);
        testCity.addCitizen("Frodo", 3);
        testCity.addCitizen("Aragorn", 45);

        //when
        Map<City.Group, Map<String, Integer>> groups = testCity.getAgeGroups();

        //then
        assertEquals(3, groups.size());

        assertEquals(1, groups.get(City.Group.CHILDREN).size());
        assertEquals(2, groups.get(City.Group.ADULTS).size());
        assertEquals(2, groups.get(City.Group.RETIREES).size());

        assertTrue(groups.get(City.Group.CHILDREN).containsKey("Frodo"));
        assertTrue(groups.get(City.Group.ADULTS).containsKey("Bilbo"));
        assertTrue(groups.get(City.Group.ADULTS).containsKey("Aragorn"));
        assertTrue(groups.get(City.Group.RETIREES).containsKey("Gendalf"));
        assertTrue(groups.get(City.Group.RETIREES).containsKey("Arven"));
    }
}