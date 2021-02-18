package com.misha.firstapp.city;

import org.junit.jupiter.api.Test;

import java.util.Iterator;
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
        int citizenCount = testCity.getCitizensCount();

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

    @Test
    public void addHousesTest() {
        //given
        City city = new City();
        House house1 = new House("Mordor 1");
        House house2 = new House("Edoras 2");

        //when
        city.addHouse(house1);
        city.addHouse(house2);

        //then
        Iterator<House> houseIterator = city.getHouses().iterator();
        assertEquals(2, city.getHouses().size());
        assertEquals(house2, houseIterator.next());
        assertEquals(house1, houseIterator.next());
    }

    @Test
    public void testLeastPopulatedHouse() {
        //given
        City city = new City();
        House house1 = new House("Mordor 1");
        House house2 = new House("Edoras 2");
        city.addHouse(house1);
        city.addHouse(house2);
        house1.addInhabitant("Bilbo", 24);
        house2.addInhabitant("Gendalf", 305);

        //when
        House leastPopulatedHouse = city.getLeastPopulatedHouse();

        //then
        assertEquals(house2, leastPopulatedHouse);
    }



    @Test
    public void populatedHousesTest1() {
        //given
        City city = new City();
        House house1 = new House("Mordor 1");
        House house2 = new House("Edoras 2");

        city.addHouse(house1);
        city.addHouse(house2);

        city.addCitizen("Frodo", 3);
        city.addCitizen("Bilbo", 24);
        city.addCitizen("Gendalf", 305);
        city.addCitizen("Arven", 295);
        city.addCitizen("Aragorn", 45);

        //when
        city.populateHouses();
        int inhabitantsSum = city.getHouses().stream()
                .map(house -> house.getInhabitants().size())
                .mapToInt(Integer::intValue).sum();

        //then
        assertEquals(city.getCitizensCount(), inhabitantsSum);
        assertEquals(3, house2.getInhabitants().size());
        assertEquals(2, house1.getInhabitants().size());
    }

    @Test
    public void populatedHousesTest2() {
        //given
        City city = new City();
        House house1 = new House("Anduin River 1");
        House house2 = new House("Dead Marshes 2");
        House house3 = new House("Edoras 3");
        House house4 = new House("Mines of Moria 4");
        House house5 = new House("Mordor 5");

        city.addHouse(house1);
        city.addHouse(house2);

        city.addCitizen("Frodo", 3);
        city.addCitizen("Bilbo", 24);
        city.addCitizen("Gendalf", 305);
        city.addCitizen("Arven", 295);
        city.addCitizen("Aragorn", 45);

        //when
        city.populateHouses();
        int inhabitantsSum = city.getHouses().stream()
                .map(house -> house.getInhabitants().size())
                .mapToInt(Integer::intValue).sum();

        //then
        assertEquals(city.getCitizensCount(), inhabitantsSum);
        assertEquals(2, house1.getInhabitants().size());
        assertEquals(1, house2.getInhabitants().size());
        assertEquals(1, house3.getInhabitants().size());
        assertEquals(1, house4.getInhabitants().size());
        assertEquals(0, house5.getInhabitants().size());
    }
}