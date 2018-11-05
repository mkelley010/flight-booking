/*
NAME: Michael Kelley

This file contains information for utility tools like reading in information and opening/reading/closing the supplied text files.
 */
package com.company;

import java.io.File;
import java.util.Scanner;

public class Utility
{
    protected Scanner input;
    protected Scanner read;

    Utility()
    {
        input = new Scanner(System.in);
    }

    // Opens a file, throws exception if it can't be opened
    public void openFile(String fileName)
    {
        try
        {
            read = new Scanner(new File(fileName));
        }
        catch (Exception e)
        {
            System.out.println("File not opened.");
        }
    }

    // Read in destination data from file
    public void readDestinationFile(RBT tree)
    {
        while (read.hasNext())
        {
            String city = read.nextLine();
            String country = read.nextLine();
            String weather = read.nextLine();
            String airport = read.nextLine();
            Destination destination = new Destination();
            destination.setCity(city);
            destination.setCountry(country);
            destination.setWeather(weather);
            destination.setArrivalAirport(airport);
            tree.insert(destination);
        }
    }

    // Read in flight data from file
    public void readFlightFile(RBT tree)
    {
        while (read.hasNext())
        {
            String city = read.nextLine();
            for (int i = 0; i < 3; ++i)
            {
                String arrivalAirport = read.nextLine();
                String tempNum = read.nextLine();
                String depart = read.nextLine();
                String returnDate = read.nextLine();
                String tempDepartTime = read.nextLine();
                String tempArrivalTime = read.nextLine();
                String tempPrice = read.nextLine();
                // parse strings to ints and doubles
                int num = Integer.parseInt(tempNum);
                double departTime = Double.parseDouble(tempDepartTime);
                double arrivalTime = Double.parseDouble(tempArrivalTime);
                double price = Double.parseDouble(tempPrice);
                Flight flight = new Flight();
                flight.setArrivalAirport(arrivalAirport);
                flight.setNum(num);
                flight.setDepartDate(depart);
                flight.setReturnDate(returnDate);
                flight.setDepartTime(departTime);
                flight.setArrivalTime(arrivalTime);
                flight.setPrice(price);
                tree.searchAdd(city, flight);
            }
        }
    }

    public void closeFile()
    {
        read.close();
    }
}
