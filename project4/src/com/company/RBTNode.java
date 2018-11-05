/*
NAME: Michael Kelley

This file contains the red-black tree node information. Each node contains a destination. RBT currently does not work so it's a binary search tree until fixed.
 */

package com.company;

public class RBTNode
{
    private LLLNode head;
    private RBTNode left;
    private RBTNode right;
    private RBTNode parent;
    private boolean red;
    private Destination destination;

    // Default constructor
    RBTNode()
    {
        destination = new Destination();
        red = false;
    }

    // Constructor w/ args to set node data
    RBTNode(Destination newDestination)
    {
        destination = new Destination();
        destination.setCity(newDestination.getCity());
        destination.setCountry(newDestination.getCountry());
        destination.setWeather(newDestination.getWeather());
        destination.setArrivalAirport(newDestination.getArrivalAirport());
        red = false;
    }

    // Wrapper to add a flight to LLL
    public boolean addNode(Flight newFlight)
    {
        if (head == null)
        {
            LLLNode newNode = new LLLNode();
            head = newNode;
            newNode.setFlight(newFlight);
            return true;
        }
        else
        {
            return addNode(head, newFlight);
        }
    }

    // Recursively add a flight to the end of the list
    public boolean addNode(LLLNode head, Flight newFlight)
    {
        if (head == null)
        {
            return false;
        }
        else if (head.getNext() == null)
        {
            LLLNode newNode = new LLLNode();
            head.setNext(newNode);
            newNode.setFlight(newFlight);
            return true;
        }
        else
        {
            return addNode(head.getNext(), newFlight);
        }
    }

    // Wrapper to find flights that match arrival/depart time criteria
    public void findMatchingFlights(double departTime, double arrivalTime, DLL list)
    {
        if (head == null)
        {
            return;
        }
        else
        {
            findMatchingFlights(head, departTime, arrivalTime, list);
        }
    }

    // Recursively search a LLL of flights to find flights within the specified range of arrival and depart times. If found, add them to the DLL.
    public void findMatchingFlights(LLLNode head, double departTime, double arrivalTime, DLL list)
    {
        if (head == null)
        {
            return;
        }
        // if flight is between the user's specifications add to DLL
        if (departTime <= head.getFlight().getDepartTime() && arrivalTime >= head.getFlight().getArrivalTime())
        {
            list.addNode(head.getFlight());
        }
        findMatchingFlights(head.getNext(), departTime, arrivalTime, list);
    }

    // Wrapper to print LLL of flights
    public void printLLL()
    {
        if (head == null)
        {
            System.out.println("No connecting flights.");
            return;
        }
        else
        {
            printLLL(head);
        }
    }

    // Recursively print LLL of flights
    public void printLLL(LLLNode head)
    {
        if (head == null)
        {
            return;
        }
        head.printFlight();
        printLLL(head.getNext());
    }

    // Left reference in tree
    public RBTNode left()
    {
        if (left != null)
        {
            return left;
        }
        else
        {
            return null;
        }
    }

    // Right reference in tree
    public RBTNode right()
    {
        if (right != null)
        {
            return right;
        }
        else
        {
            return null;
        }
    }

    // Parent reference in tree
    public RBTNode parent()
    {
        if (parent != null)
        {
            return parent;
        }
        else
        {
            return null;
        }
    }

    public boolean color()
    {
        return red;
    }

    public Destination getDestination()
    {
        return destination;
    }

    public void setBlack()
    {
        red = false;
    }

    public void setRed()
    {
        red = true;
    }

    public void setParent(RBTNode newParent)
    {
        parent = newParent;
    }

    public void setLeft(RBTNode newLeft)
    {
        left = newLeft;
    }

    public void setRight(RBTNode newRight)
    {
        right = newRight;
    }

    // Set a destination
    public void setDestination(Destination newDestination)
    {
        this.destination.setCity(newDestination.getCity());
        this.destination.setCountry(newDestination.getCountry());
        this.destination.setWeather(newDestination.getWeather());
        this.destination.setArrivalAirport(newDestination.getArrivalAirport());
    }

    // Print node's destination
    public void print()
    {
        destination.print();
    }
}
