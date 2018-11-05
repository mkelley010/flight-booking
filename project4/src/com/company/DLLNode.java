/*
NAME: Michael Kelley

This file contains code for a node in the DLL. The DLL stores potential flights the user is considering purchasing based on arrival and departure times.
 */
package com.company;

public class DLLNode
{
    private Flight flight;
    private DLLNode next;
    private DLLNode prev;


    // Default constructor to initialize flight memory
    DLLNode()
    {
        this.flight = new Flight();
    }

    // Constructor with args to populate a DLL node with a flight
    DLLNode(Flight newFlight)
    {
        this.flight = new Flight();
        this.flight.setNum(newFlight.getNum());
        this.flight.setDepartDate(newFlight.getDepartDate());
        this.flight.setReturnDate(newFlight.getReturnDate());
        this.flight.setDepartTime(newFlight.getDepartTime());
        this.flight.setArrivalTime(newFlight.getArrivalTime());
        this.flight.setPrice(newFlight.getPrice());
        this.flight.setDepartAirport(newFlight.getDepartAirport());
        this.flight.setArrivalAirport(newFlight.getArrivalAirport());
        this.flight.setWeather(newFlight.getWeather());
        this.flight.setCountry(newFlight.getCountry());
        this.flight.setCity(newFlight.getCity());
    }

    // Setters and getters
    public void setNext(DLLNode newNext)
    {
        this.next = newNext;
    }

    public void setPrev(DLLNode newPrev)
    {
        this.prev = newPrev;
    }

    public DLLNode getNext()
    {
        return this.next;
    }

    public DLLNode getPrev()
    {
        return this.prev;
    }

    public Flight getFlight()
    {
        return this.flight;
    }
}
