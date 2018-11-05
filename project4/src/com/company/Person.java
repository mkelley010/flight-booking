/*
NAME: Michael Kelley

This file contains all the information for a passenger (name, age etc). It will be contained in an object of flight.
 */

package com.company;

public class Person
{
    private String name;
    private int age;
    private int checkedBags;
    private String seat;

    // Default constructor
    Person()
    {
        name = "No name";
        age = 0;
        checkedBags = 0;
        seat = "No seat";
    }

    // Set a passenger name
    public void setName(String newName)
    {
        name = newName;
    }

    public String getName()
    {
        return name;
    }

    // Set passenger age
    public void setAge(int newAge)
    {
        age = newAge;
    }

    public int getAge()
    {
        return age;
    }

    // Set number of checked bags
    public void setCheckedBags(int newCheckedBags)
    {
        checkedBags = newCheckedBags;
    }

    public int getCheckedBags()
    {
        return checkedBags;
    }

    // Set passenger's seat
    public void setSeat(String newSeat)
    {
        seat = newSeat;
    }

    public String getSeat()
    {
        return seat;
    }

    // Print passenger information
    public void print()
    {
        System.out.println("\n");
        System.out.println("Passenger Information");
        System.out.println("---------------------");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Checked bags: " + checkedBags);
        System.out.println("Seat: " + seat);
    }

}
