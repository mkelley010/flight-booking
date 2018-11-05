/*
NAME: Michael Kelley

This file contains all of the information for a flight (such as flight number, ticket price, depart/arrival time etc). It's a subclass of Destination and contains a Person object.
 */

package com.company;

import java.text.DecimalFormat;

public class Flight extends Destination
{
    private int num;
    private String departDate;
    private String returnDate;
    private double departTime;
    private double arrivalTime;
    private double price;
    private String departAirport;
    private Person passenger;

    // Default constructor
    Flight()
    {
        num = 0;
        departDate = "No departure date";
        returnDate = "No return date";
        departTime = 0;
        arrivalTime = 0;
        price = 0;
        departAirport = "PDX";
        passenger = new Person();
    }

    // Set flight number
    public void setNum(int newNum)
    {
        this.num = newNum;
    }

    public int getNum()
    {
        return num;
    }

    // Set departure date
    public void setDepartDate(String newDate)
    {
        this.departDate = newDate;
    }

    public String getDepartDate()
    {
        return departDate;
    }

    // Set return date
    public void setReturnDate(String newDate)
    {
        this.returnDate = newDate;
    }

    public String getReturnDate()
    {
        return returnDate;
    }

    // Set flight depart time
    public void setDepartTime(double newDepart)
    {
        this.departTime = newDepart;
    }

    public double getDepartTime()
    {
        return departTime;
    }

    // Set flight arrival time
    public void setArrivalTime(double newArrivalTime)
    {
        this.arrivalTime = newArrivalTime;
    }

    public double getArrivalTime()
    {
        return arrivalTime;
    }

    // Set flight ticket price
    public void setPrice(double newPrice)
    {
        this.price = newPrice;
    }

    public double getPrice()
    {
        return price;
    }

    // Set departing airport
    public void setDepartAirport(String newDepartAirport)
    {
        this.departAirport = newDepartAirport;
    }

    public String getDepartAirport()
    {
        return departAirport;
    }

    // Set passenger on flight
    public void setPassenger(String name, int age, int checkedBags, String seat)
    {
        this.passenger.setName(name);
        this.passenger.setAge(age);
        this.passenger.setCheckedBags(checkedBags);
        this.passenger.setSeat(seat);
    }

    // Overload for setting a passenger on a flight
    public void setPassenger(Person newPassenger)
    {
        this.passenger.setName(newPassenger.getName());
        this.passenger.setSeat(newPassenger.getSeat());
        this.passenger.setCheckedBags(newPassenger.getCheckedBags());
        this.passenger.setAge(newPassenger.getAge());
    }

    public Person getPassenger()
    {
        return passenger;
    }

    // Print a flight with destination
    public void printFlightWithDestination()
    {
        // create decimal format object to set price precision to 2 decimals
        DecimalFormat two = new DecimalFormat("#0.00");
        // convert flight times to string so they can be displayed as a time
        String temp, tempDepart, tempArrival;
        temp = String.format("%.2f", departTime);
        tempDepart = temp.replace('.',':');
        temp = String.format("%.2f", arrivalTime);
        tempArrival = temp.replace('.',':');
        super.print();
        System.out.println("Flight number: " + num);
        System.out.println("Date: " + departDate + "-" + returnDate);
        System.out.println("Airports: " +  departAirport + "->" + arrivalAirport);
        System.out.println("Departure time: " + tempDepart);
        System.out.println("Arrival time: " + tempArrival);
        System.out.println("Price: $" + two.format(price));
    }

    // Print flight info only
    public void printFlightOnly()
    {
        // create decimal format object to set price precision to 2 decimals
        DecimalFormat two = new DecimalFormat("#0.00");
        // convert flight times to string so they can be displayed as a time
        String temp, tempDepart, tempArrival;
        temp = String.format("%.2f", departTime);
        tempDepart = temp.replace('.',':');
        temp = String.format("%.2f", arrivalTime);
        tempArrival = temp.replace('.',':');
        System.out.println("Flight number: " + num);
        System.out.println("Date: " + departDate + "-" + returnDate);
        System.out.println("Airports: " +  departAirport + "->" + arrivalAirport);
        System.out.println("Departure time: " + tempDepart);
        System.out.println("Arrival time: " + tempArrival);
        System.out.println("Price: $" + two.format(price));
    }

    // Print flight info with passenger and destination info
    public void printFlightWithDestinationPassengers()
    {
        printFlightWithDestination();
        passenger.print();
    }

    // Print a flight with passengers only
    public void printFlightWithPassengersOnly()
    {
        printFlightOnly();
        passenger.print();
    }

}
