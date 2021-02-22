package com.misha.firstapp.city;

import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CityTest {
    @Test
    public void citizenCountTest() {
        //given
        City testCity = new City();
        Citizen bilbo = new Citizen("Bilbo", 24);
        Citizen gendalf = new Citizen("Gendalf", 305);
        Citizen frodo = new Citizen("Frodo", 3);

        testCity.addCitizen(bilbo);
        testCity.addCitizen(gendalf);
        testCity.addCitizen(frodo);

        //when
        int citizenCount = testCity.getCitizensCount();

        //then
        assertEquals(3, citizenCount);
    }

    @Test
    public void oldestCitizenTest() {
        //given
        City testCity = new City();
        Citizen bilbo = new Citizen("Bilbo", 24);
        Citizen gendalf = new Citizen("Gendalf", 305);
        Citizen frodo = new Citizen("Frodo", 3);

        testCity.addCitizen(bilbo);
        testCity.addCitizen(gendalf);
        testCity.addCitizen(frodo);

        //when
        Citizen citizen = testCity.getOldestCitizen();

        //then
        assertEquals("Gendalf", citizen.getName());
        assertEquals(305, citizen.getAge());
    }

    @Test
    public void getAgeGroupsTest() {
        //given
        Citizen bilbo = new Citizen("Bilbo", 24);
        Citizen gendalf = new Citizen("Gendalf", 305);
        Citizen arven = new Citizen("Arven", 295);
        Citizen frodo = new Citizen("Frodo", 3);
        Citizen aragorn = new Citizen("Aragorn", 45);

        City testCity = new City();
        testCity.addCitizen(bilbo);
        testCity.addCitizen(gendalf);
        testCity.addCitizen(arven);
        testCity.addCitizen(frodo);
        testCity.addCitizen(aragorn);

        //when
        Map<City.Group, List<Citizen>> groups = testCity.getAgeGroups();

        //then
        assertEquals(3, groups.size());

        assertEquals(1, groups.get(City.Group.CHILDREN).size());
        assertEquals(2, groups.get(City.Group.ADULTS).size());
        assertEquals(2, groups.get(City.Group.RETIREES).size());

        assertTrue(groups.get(City.Group.CHILDREN).contains(frodo));
        assertTrue(groups.get(City.Group.ADULTS).contains(bilbo));
        assertTrue(groups.get(City.Group.ADULTS).contains(aragorn));
        assertTrue(groups.get(City.Group.RETIREES).contains(gendalf));
        assertTrue(groups.get(City.Group.RETIREES).contains(arven));
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
    public void compareHouseTest(){
        //given
        House house1 = new House("Mordor 1");
        House house2 = new House("Edoras 2");

        //when
        int result = house1.compareTo(house2);

        //then
        assertTrue(result>0);
    }


    @Test
    public void testLeastPopulatedHouseEqual() {
        //given
        City city = new City();
        House house1 = new House("Mordor 1");
        House house2 = new House("Edoras 2");
        city.addHouse(house1);
        city.addHouse(house2);
        Citizen bilbo = new Citizen("Bilbo", 24);
        Citizen gendalf = new Citizen("Gendalf", 305);

        house1.addInhabitant(bilbo);
        house2.addInhabitant(gendalf);

        //when
        House leastPopulatedHouse = city.getLeastPopulatedHouse();

        //then
        assertEquals(house2, leastPopulatedHouse);
    }

    @Test
    public void testLeastPopulatedHouse() {
        //given
        City city = new City();
        House house1 = new House("Mordor 1");
        House house2 = new House("Edoras 2");
        city.addHouse(house1);
        city.addHouse(house2);
        Citizen bilbo = new Citizen("Bilbo", 24);
        Citizen gendalf = new Citizen("Gendalf", 305);
        Citizen arven = new Citizen("Arven", 295);

        house1.addInhabitant(bilbo);
        house2.addInhabitant(gendalf);
        house2.addInhabitant(arven);

        //when
        House leastPopulatedHouse = city.getLeastPopulatedHouse();

        //then
        assertEquals(house1, leastPopulatedHouse);
    }



    @Test
    public void populatedHousesTest1() {
        //given
        City city = new City();
        House house1 = new House("Mordor 1");
        House house2 = new House("Edoras 2");

        city.addHouse(house1);
        city.addHouse(house2);

        Citizen bilbo = new Citizen("Bilbo", 24);
        Citizen gendalf = new Citizen("Gendalf", 305);
        Citizen arven = new Citizen("Arven", 295);
        Citizen frodo = new Citizen("Frodo", 3);
        Citizen aragorn = new Citizen("Aragorn", 45);

        city.addCitizen(bilbo);
        city.addCitizen(gendalf);
        city.addCitizen(arven);
        city.addCitizen(frodo);
        city.addCitizen(aragorn);

        //when
        city.populateHouses();
        int inhabitantsSum = city.getHouses().stream()
                .map(house -> house.getInhabitants().size())
                .mapToInt(Integer::intValue).sum();

        //then
        assertEquals(city.getCitizensCount(), inhabitantsSum);
        assertEquals(2, house2.getInhabitants().size());
        assertEquals(3, house1.getInhabitants().size());
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
        city.addHouse(house3);
        city.addHouse(house4);
        city.addHouse(house5);

        Citizen bilbo = new Citizen("Bilbo", 24);
        Citizen gendalf = new Citizen("Gendalf", 305);
        Citizen arven = new Citizen("Arven", 295);
        Citizen frodo = new Citizen("Frodo", 3);
        Citizen aragorn = new Citizen("Aragorn", 45);

        city.addCitizen(bilbo);
        city.addCitizen(gendalf);
        city.addCitizen(arven);
        city.addCitizen(frodo);
        city.addCitizen(aragorn);

        //when
        city.populateHouses();
        int inhabitantsSum = city.getHouses().stream()
                .map(house -> house.getInhabitants().size())
                .mapToInt(Integer::intValue).sum();

        //then
        assertEquals(city.getCitizensCount(), inhabitantsSum);
        assertEquals(1, house1.getInhabitants().size());
        assertEquals(1, house2.getInhabitants().size());
        assertEquals(1, house3.getInhabitants().size());
        assertEquals(2, house4.getInhabitants().size());
        assertEquals(0, house5.getInhabitants().size());
    }

    @Test
    public void allChildrenPopulated3() {
        //given
        City city = new City();
        House house1 = new House("Anduin River 1");
        House house2 = new House("Dead Marshes 2");
        House house3 = new House("Edoras 3");
        House house4 = new House("Mines of Moria 4");
        House house5 = new House("Mordor 5");

        city.addHouse(house1);
        city.addHouse(house2);
        city.addHouse(house3);
        city.addHouse(house4);
        city.addHouse(house5);

        Citizen bilbo = new Citizen("Bilbo", 24);
        Citizen gendalf = new Citizen("Gendalf", 305);
        Citizen arven = new Citizen("Arven", 295);
        Citizen frodo = new Citizen("Frodo", 3);
        Citizen pippin = new Citizen("Pippin", 1);
        Citizen aragorn = new Citizen("Aragorn", 45);

        city.addCitizen(bilbo);
        city.addCitizen(gendalf);
        city.addCitizen(arven);
        city.addCitizen(frodo);
        city.addCitizen(pippin);
        city.addCitizen(aragorn);

        //when
        city.populateHouses();
        int inhabitantsSum = city.getHouses().stream()
                .map(house -> house.getInhabitants().size())
                .mapToInt(Integer::intValue).sum();

        //then
        assertEquals(city.getCitizensCount(), inhabitantsSum);
        assertEquals(2, house1.getInhabitants().size());
        assertEquals(2, house2.getInhabitants().size());
        assertEquals(1, house3.getInhabitants().size());
        assertEquals(1, house4.getInhabitants().size());
        assertEquals(0, house5.getInhabitants().size());
    }
}