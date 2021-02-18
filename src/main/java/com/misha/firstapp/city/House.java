package com.misha.firstapp.city;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class House {
    private final String address;
    private final Map<String, Integer> inhabitants;

    public House(String address) {
        this.address = address;
        this.inhabitants = new HashMap<>();
    }

    public void addInhabitant(String name, int age) {
        if(inhabitants.size() < 3){
            inhabitants.put(name, age);
        }else {
            throw new RuntimeException("Max inhabitants count in this house is reached");
        }
    }

    public Map<String, Integer> getInhabitants() {
        return inhabitants;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof House)) {
            return false;
        }
        House house = (House) o;
        return Objects.equals(address, house.address) &&
                Objects.equals(inhabitants, house.inhabitants);
    }

    @Override
    public int hashCode() {
        return Objects.hash(address, inhabitants);
    }

    @Override
    public String toString() {
        return "House{" +
                "address='" + address + '\'' +
                ", inhabitants=" + inhabitants +
                '}';
    }
}
