package com.example.code;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

import com.example.code.City;
import com.example.code.CityList;

public class CityListTest {
    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }
    private City mockCity() {
        return new City("Edmonton", "Alberta");
    }

    @Test
    public void testAdd() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities().size());
        City city = new City("Regina", "Saskatchewan");
        cityList.add(city);
        assertEquals(2, cityList.getCities().size());
        assertTrue(cityList.getCities().contains(city));
    }

    @Test
    public void testAddException() {
        CityList cityList = mockCityList();
        City city = new City("Yellowknife", "Northwest Territories");
        cityList.add(city);
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.add(city);
        });
    }
    @Test
    public void testGetCities() {
        CityList cityList = mockCityList();
        // This line checks if the first city in the cityList (retrieved by cityList.getCities().get(0))
        // is the same as the city returned by mockCity()
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(0)));
        // This pushes down the original city
        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);
        // Now the original city should be at position 1
        assertEquals(0, city.compareTo(cityList.getCities().get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(1)));
    }

    @Test
    public void testHasCity() {
        CityList cityList = mockCityList();
        assertTrue(cityList.hasCity(mockCity()));
        City city = new City("Regina", "Saskatchewan");
        assertFalse(cityList.hasCity(city));
    }

    @Test
    public void testDeleteCity() {
        CityList cityList = mockCityList();
        City city_to_delete = mockCity();
        cityList.add(city_to_delete);
        assertTrue(cityList.hasCity(city_to_delete));
        try {
            cityList.deleteCity(city_to_delete);
        } catch (Exception e) {
            fail("Should not throw an exception");
        }
        assertFalse(cityList.hasCity(city_to_delete));
    }

    @Test
    public void testDeleteCityException() {
        CityList cityList = mockCityList();
        City city = new City("Regina", "Saskatchewan");
        assertThrows(Exception.class, () -> {
            cityList.deleteCity(city);
        });
    }

    @Test
    public void testCountCities() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.countCities());
        City city = new City("Regina", "Saskatchewan");
        cityList.add(city);
        assertEquals(2, cityList.countCities());
    }
}