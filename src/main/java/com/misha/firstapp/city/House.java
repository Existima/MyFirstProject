package com.misha.firstapp.city;

import java.util.*;

public class House implements Comparable<House> {
    private final String address;
    private final List<Citizen> inhabitants;

    public House(String address) {
        this.address = address;
        this.inhabitants = new LinkedList<>();
    }

    public String getAddress() {
        return address;
    }

    public void addInhabitant(Citizen citizen) {
        if(inhabitants.size() < 4){
            inhabitants.add(citizen);
        }else {
            throw new RuntimeException("Max inhabitants count in this house is reached");
        }
    }

    public List<Citizen> getInhabitants() {
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

    @Override
    public int compareTo(House o) {
       return this.getAddress().compareTo(o.getAddress());
    }
}
