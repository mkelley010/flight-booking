/*
NAME: Michael Kelley

This file contains implementation of the doubly linked list. The DLL is a list that holds potential flights the user wants to purchase based on departure/arrival times.
 */

package com.company;

public class DLL extends Utility
{
    private DLLNode head;

    // Wrapper to add nodes to the DLL
    public void addNode(Flight newFlight)
    {
        if (head == null)
        {
            DLLNode newNode = new DLLNode(newFlight);
            this.head = newNode;
            newNode.setPrev(this.head);
        }
        else
        {
            addNode(head, newFlight);
        }
    }

    // Recursively add nodes to end of DLL
    public void addNode(DLLNode head, Flight newFlight)
    {
        // prevent duplicates being added to potential flights
        if (head.getFlight().getNum() == newFlight.getNum())
        {
            return;
        }
        else if (head.getNext() == null)
        {
            DLLNode newNode = new DLLNode(newFlight);
            head.setNext(newNode);
            newNode.setPrev(head);
        }
        else
        {
            addNode(head.getNext(), newFlight);
        }
    }

    // Wrapper to purchase a flight by flight num
    public Flight purchaseFlight(int flightNum)
    {
        if (this.head == null)
        {
            System.out.println("Empty list, nothing to purchase.");
            return null;
        }
        else
        {
            return purchaseFlight(head, flightNum);
        }
    }

    // Recursively search the DLL to find a matching flight. If found, return the match and set it as the user's itinerary.
    public Flight purchaseFlight(DLLNode head, int flightNum)
    {
        if (head == null)
        {
            System.out.println("Requested flight not found in list.");
            return null;
        }
        if (head.getFlight().getNum() == flightNum)
        {
            Person passenger = new Person();
            System.out.print("Enter passenger name: ");
            passenger.setName(input.nextLine());
            System.out.print("Enter passenger age: ");
            passenger.setAge(input.nextInt());
            System.out.print("Enter number of checked bags: ");
            passenger.setCheckedBags(input.nextInt());
            System.out.print("Enter seat: ");
            input.nextLine();
            passenger.setSeat(input.nextLine());
            head.getFlight().setPassenger(passenger);
            System.out.println("Ticket purchased!");
            System.out.println("===ITINERARY=== ");
            head.getFlight().printFlightWithDestinationPassengers();
            return head.getFlight();
        }
        else
        {
            return purchaseFlight(head.getNext(), flightNum);
        }
    }

    // Wrapper to print DLL
    public void print()
    {
        if (head == null)
        {
            System.out.println("Empty list, nothing to print.");
        }
        else
        {
            print(head);
        }
    }

    // Recursively print the DLL
    public void print(DLLNode head)
    {
        if (head == null)
        {
            return;
        }
        else
        {
            head.getFlight().printFlightOnly();
            System.out.println("\n");
            print(head.getNext());
        }
    }

    // Wrapper to remove a flight from the DLL
    public boolean remove(int flightNum)
    {
        if (head == null)
        {
            return false;
        }
        else
        {
            return remove(head, flightNum);
        }
    }

    // Recursively remove a flight from the DLL
    public boolean remove(DLLNode head, int flightNum)
    {
        if (head == null)
        {
            return false;
        }
        else if (head.getFlight().getNum() == flightNum)
        {
            // removal at head
            if (this.head == head)
            {
                // if removing at head and it's the only item in the list
                if (head.getNext() == null)
                {
                    this.head = null;
                }
                // if removing at head and it's NOT the only item in the list
                else
                {
                    head.getNext().setPrev(this.head);
                    this.head = head.getNext();
                    head.setPrev(null);
                    head.setNext(null);
                }
                return true;
            }
            // removal at tail
            else if (head.getNext() == null)
            {
                head.getPrev().setNext(null);
                head.setPrev(null);
                return true;
            }
            // removal in between
            else
            {
                head.getPrev().setNext(head.getNext());
                head.getNext().setPrev(head.getPrev());
                head.setPrev(null);
                head.setNext(null);
                return true;
            }
        }
        else
        {
           return remove(head.getNext(), flightNum);
        }
    }

    // Remove all nodes from DLL
    public boolean removeAll()
    {
        if (head == null)
        {
            System.out.println("Empty list, nothing to remove. ");
            return false;
        }
        else
        {
            this.head = null;
            return true;
        }
    }

}
