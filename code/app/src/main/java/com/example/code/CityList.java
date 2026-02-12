package com.example.code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This is a class that keeps a list of city objects
 */
public class CityList {
    private List<City> cities = new ArrayList<>();

    /**
     * This adds a city to the list if the city does not exist
     * @param city
     * This is a candidate city to add
     */
    public void add(City city) {
        if (cities.contains(city)) {
            throw new IllegalArgumentException();
        }
        cities.add(city);
    }

    /**
     * This returns a sorted list of cities
     * @return
     * Return the sorted list
     */
    public List<City> getCities() {
        List<City> list = cities;
        Collections.sort(list);
        return list;
    }
    /**
     * This returns a boolean of if the inputted city is within the list
     * @return
     * Return a boolean of if the inputted city is within the list
     */
    public boolean hasCity(City city){
        return cities.contains(city);
    }

    /**
     * This deletes a inputted city from the list
     * @param city
     * This is a candidate city to remove
     * @throw an exception if city to remove not in list
     */
    public void deleteCity(City city) throws Exception {
        if(!cities.contains(city)){
            throw new Exception("City to remove not in list");
        }
            cities.remove(city);
    }

    /**
     * counts the number of cities in city list
     * @return number of cities
     */
    public int countCities(){
        return cities.size();
    }
}