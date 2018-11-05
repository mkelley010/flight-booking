/*
NAME: Michael Kelley

This file contains info on the LLL nodes. Each LLL node holds a flight respective to its destination.
 */

package com.company;

public class LLLNode
{
    private LLLNode next;
    private Flight flight;

    // Default constructor
    LLLNode()
    {
        this.flight = new Flight();
    }

    // Set next reference of node
    public void setNext(LLLNode newNext)
    {
        this.next = newNext;
    }

    // Next reference of node
    public LLLNode getNext()
    {
        return next;
    }

    // Set a flight in a LLL node
    public void setFlight(Flight newFlight)
    {
        this.flight.setCity(newFlight.getCity());
        this.flight.setCountry(newFlight.getCountry());
        this.flight.setWeather(newFlight.getWeather());
        this.flight.setArrivalAirport(newFlight.getArrivalAirport());
        this.flight.setNum(newFlight.getNum());
        this.flight.setDepartDate(newFlight.getDepartDate());
        this.flight.setReturnDate(newFlight.getReturnDate());
        this.flight.setDepartTime(newFlight.getDepartTime());
        this.flight.setArrivalTime(newFlight.getArrivalTime());
        this.flight.setPrice(newFlight.getPrice());
        this.flight.setDepartAirport(newFlight.getDepartAirport());
        this.flight.setPassenger(newFlight.getPassenger());
    }

    // Get a flight in a node
    public Flight getFlight()
    {
        return flight;
    }

    // Print flight only
    public void printFlight()
    {
        flight.printFlightOnly();
        System.out.println("\n");
    }

    // Print flight with passengers
    public void printFlightWithPassengers()
    {
        flight.printFlightWithPassengersOnly();
        System.out.println("\n");
    }
}
