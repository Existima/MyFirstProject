package com.misha.firstapp.city;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CityTest {
    @Test
    public void citizenCountTest() {
        //given
        City testCity = new City();
        testCity.addCitizen("Bilbo", 24);
        testCity.addCitizen("Gendalf", 305);
        testCity.addCitizen("Frodo", 3);

        //when
        int citizenCount = testCity.getCitizensCount();

        //then
        assertEquals(3, citizenCount);
    }
}