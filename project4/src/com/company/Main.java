/*
NAME: Michael Kelley
CLASS: CS202
ASSIGNMENT: Project 5

Red-black tree currently does not work properly so I salvaged what I could and turned it into a BST. However, I did leave the problematic RBT code in there - it's just not used.

This program imports a list of destinations into a tree and then imports flights going to that destination into a LLL. From there the user is prompted with various menu options to view flights, search flights, add flights to a DLL they're considering purchasing,
remove flights, purchase flights and view their itinerary.
 */

package com.company;

public class Main extends Utility
{
    public static void main(String[] args)
    {
        Flight itinerary = new Flight();
        double arrivalTime = 0, departureTime = 0;
        int removeByFlightNum = 0, flightNumPurchase = 0;
        String destination = new String();
        DLL list = new DLL();
        char option;
        Utility read = new Utility();
        Main application = new Main();
        // these file names should work but change them if they throw an exception
        String destinationFile = "src/com/company/destinations.txt", flightFile = "src/com/company/flights.txt";
        RBT tree = new RBT();
        // read in destination data
        read.openFile(destinationFile);
        read.readDestinationFile(tree);
        read.closeFile();
        // read in flight data
        read.openFile(flightFile);
        read.readFlightFile(tree);
        read.closeFile();

        application.displayMenu();
        option = application.input.next().charAt(0);
        while (option != 'q')
        {
            switch (option)
            {
                case 'a':
                    // find flights by destination
                    application.input.nextLine();
                    System.out.print("Enter a destination: ");
                    destination = application.input.nextLine();
                    RBTNode temp = new RBTNode();
                    temp = tree.search(destination);
                    if (temp == null)
                    {
                        System.out.println("Not found.");
                    }
                    else
                    {
                        temp.printLLL();
                    }
                    break;
                case 'b':
                    tree.printFlightsOnly();
                    break;
                case 'c':
                    tree.print();
                    break;
                case 'd':
                    tree.printAll();
                    break;
                case 'e':
                    // add potential flights to DLL
                    System.out.println("This option will find all flights between specified departure/arrival times and add them to a list of flights you're considering purchasing. ");
                    System.out.println("Please enter times in 24 hour format with a decimal separator (e.g. 18.30 for 6:30 PM).");
                    System.out.print("Enter departure time: ");
                    departureTime = application.input.nextDouble();
                    System.out.print("Enter arrival time: ");
                    arrivalTime = application.input.nextDouble();
                    tree.findMatchingFlights(departureTime, arrivalTime, list);
                    System.out.println("\n");
                    list.print();
                    break;
                case 'f':
                    list.print();
                    break;
                case 'g':
                    // if removed
                    if (list.removeAll() == true)
                    {
                        System.out.println("Removed all flights!");
                    }
                    else
                    {
                        System.out.println("Failed.");
                    }
                    break;
                case 'h':
                    System.out.print("Enter flight number: ");
                    removeByFlightNum = application.input.nextInt();
                    // if removed
                    if (list.remove(removeByFlightNum) == true)
                    {
                        System.out.println("Removed flight!");
                        System.out.println("\n");
                    }
                    else
                    {
                        System.out.println("Failed.");
                        System.out.println("\n");
                    }
                    list.print();
                    break;
                case 'i':
                    list.print();
                    System.out.print("Enter flight number from above that you wish to purchase: ");
                    flightNumPurchase = application.input.nextInt();
                    itinerary = list.purchaseFlight(flightNumPurchase);
                    break;
                case 'j':
                    // if no itinerary
                    if (itinerary.getNum() == 0)
                    {
                        System.out.println("No itinerary.");
                    }
                    else
                    {
                        System.out.println("===ITINERARY===");
                        itinerary.printFlightWithDestinationPassengers();
                    }
                    break;
                default:
                    System.out.println("Invalid input. ");
                    break;
            }
            System.out.println("\n");
            application.displayMenu();
            option = application.input.next().charAt(0);
        }
    }

    // Display the menu
    public void displayMenu()
    {
        System.out.println("Welcome to my flight viewer.");
        System.out.println("a) Find flights by destination");
        System.out.println("b) Print all flights");
        System.out.println("c) Print all destinations");
        System.out.println("d) Print all flights + destinations");
        System.out.println("e) Add flights by departure and arrival time to list of flights you may want to purchase");
        System.out.println("f) View list of potential flights");
        System.out.println("g) Remove all flights from list of potential flights");
        System.out.println("h) Remove a flight from list of potential flights");
        System.out.println("i) Purchase flight from list of potential flights");
        System.out.println("j) View your itinerary");
        System.out.println("q) Quit");
        System.out.println("Select an option: ");
    }

}
