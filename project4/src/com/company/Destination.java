/*
NAME: Michael Kelley

This file contains all the information for the Destination class which will store the destination of a flight. It's the parent class of Flight.
*/

package com.company;

public class Destination extends Utility
{
    protected String city;
    protected String country;
    protected String weather;
    protected String arrivalAirport;

    // Default constructor
    Destination()
    {
        city = "No city";
        country = "No country";
        weather = "No weather";
        arrivalAirport = "No airport";
    }

    // Set city
    public void setCity(String newCity)
    {
        this.city = newCity;
    }

    // Return city
    public String getCity()
    {
        return city;
    }

    // Set country
    public void setCountry(String newCountry)
    {
        this.country = newCountry;
    }

    // Get country
    public String getCountry()
    {
        return country;
    }

    // Get arrival airport
    public String getArrivalAirport()
    {
        return arrivalAirport;
    }

    // Set weather
    public void setWeather(String newWeather)
    {
        this.weather = newWeather;
    }

    // Get weather
    public String getWeather()
    {
        return weather;
    }

    // Set the airport the flight arrives at
    public void setArrivalAirport(String newArrival)
    {
        arrivalAirport = newArrival;
    }

    // Print a destination
    public void print()
    {
        System.out.println("City: " + city);
        System.out.println("Country: " + country);
        System.out.println("Forecast: " + weather);
    }
}
