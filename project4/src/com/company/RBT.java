/*
NAME: Michael Kelley

This file contains the red-black tree code, which is a tree of destinations. RBT does not currently work and instead functions as a binary search tree until fixed.
 */
package com.company;

public class RBT
{
    private RBTNode root;

    // Default constructor
    RBT()
    {
        root = null;
    }

    public RBTNode getRoot()
    {
        return root;
    }

    // Wrapper to insert a destination into the tree
    public boolean insert(Destination newDestination)
    {
        // if tree is empty insert at root
        if (root == null)
        {
           RBTNode newNode = new RBTNode(newDestination);
           root = newNode;
           newNode.setBlack();
           return true;
        }
        else
        {
            return insert(root, newDestination);
        }
    }

    // Recursively insert a destination into the tree
    public boolean insert(RBTNode root, Destination newDestination)
    {
        RBTNode newNode = new RBTNode(newDestination);
        newNode.setRed();
        if (newDestination.getCity().compareTo(root.getDestination().getCity()) < 0)
        {
            if (root.left() == null)
            {
                root.setLeft(newNode);
                root.left().setParent(root);
                //adjustTree(newNode);
                return true;
            }
            else
            {
                return insert(root.left(), newDestination);
            }
        }
        else if (newDestination.getCity().compareTo(root.getDestination().getCity()) > 0)
        {
            if (root.right() == null)
            {
                root.setRight(newNode);
                root.right().setParent(root);
                //adjustTree(newNode);
                return true;
            }
            else
            {
                return insert(root.right(), newDestination);
            }
        }
        return false;
    }

    // Wrapper to search the tree for a destination
    public RBTNode search(String toFind)
    {
        if (this.root == null)
        {
            System.out.println("Empty tree, nothing to search.");
            return null;
        }
        else
        {
            RBTNode temp = new RBTNode();
            temp = search(root, toFind);
            if (search(root, toFind) == null)
            {
                return null;
            }
            else
            {
                return temp;
            }
        }
    }

    // Recursively search the tree for a destination
    public RBTNode search(RBTNode root, String toFind)
    {
        // if found, return true
        if (root.getDestination().getCity().compareToIgnoreCase(toFind) == 0)
        {
            return root;
        }
        // go down left subtree
        else if (toFind.compareToIgnoreCase(root.getDestination().getCity()) < 0)
        {
            if (root.left() == null)
            {
                return null;
            }
            else
            {
                return search(root.left(), toFind);
            }
        }
        // go down right subtree
        else if (toFind.compareToIgnoreCase(root.getDestination().getCity()) > 0)
        {
            if (root.right() == null)
            {
                return null;
            }
            else
            {
                return search(root.right(), toFind);
            }
        }
        return null;
    }

    // Search for a destination and add a connecting flight to its LLL
    public boolean searchAdd(String toFind, Flight newFlight)
    {
        RBTNode temp = search(root, toFind);
        newFlight.setArrivalAirport(temp.getDestination().getArrivalAirport());
        newFlight.setCity(temp.getDestination().getCity());
        newFlight.setCountry(temp.getDestination().getCountry());
        newFlight.setWeather(temp.getDestination().getWeather());
        if (temp == null)
        {
            return false;
        }
        else
        {
            return temp.addNode(newFlight);
        }
    }

    // Wrapper to find matching flights based on depart and arrival time criteria
    public void findMatchingFlights(double departTime, double arrivalTime, DLL list)
    {
       if (root == null)
       {
           return;
       }
       else
       {
           findMatchingFlights(root, departTime, arrivalTime, list);
       }
    }

    // Recursively go into each node (destination) of the tree and call the search function on the node which will search the LLL of flights.
    public void findMatchingFlights(RBTNode root, double departTime, double arrivalTime, DLL list)
    {
        if (root == null)
        {
            return;
        }
        root.findMatchingFlights(departTime, arrivalTime, list);
        findMatchingFlights(root.left(), departTime, arrivalTime, list);
        findMatchingFlights(root.right(), departTime, arrivalTime, list);
    }

    // Print a destination's connecting flights
    public void printConnectingFlights(String toFind)
    {
        RBTNode temp = search(root, toFind);
        if (temp == null)
        {
            System.out.println("Destination not found.");
        }
        else
        {
            temp.printLLL();
        }
    }

    // Wrapper to remove all nodes in the tree
    public RBTNode removeAll()
    {
        if (this.root == null)
        {
            System.out.println("Empty tree, nothing to remove");
            return null;
        }
        else
        {
            return removeAll(this.root);
        }
    }

    // Recursively remove all nodes in the tree
    public RBTNode removeAll(RBTNode root)
    {
        if (root == null)
        {
            System.out.println("All nodes removed.");
            this.root = null;
            return null;
        }
        root.setLeft(removeAll(root.left()));
        root.setRight(removeAll(root.right()));
        root = null;
        return root;
    }

    // Wrapper to remove a node
    public boolean remove(String toRemove)
    {
        if (this.root == null)
        {
            System.out.println("Empty tree, nothing to remove");
            return false;
        }
        else
        {
            return remove(this.root, toRemove);
        }
    }

    // Recursively remove a node
    public boolean remove(RBTNode root, String toRemove)
    {
        if (root == null)
        {
            return false;
        }
        if (toRemove.compareToIgnoreCase(root.getDestination().getCity()) < 0)
        {
            return remove(root.left(), toRemove);
        }
        else if (toRemove.compareToIgnoreCase(root.getDestination().getCity()) > 0)
        {
            return remove(root.right(), toRemove);
        }
        else
        {
            // two children
            if (root.left() != null && root.right() != null)
            {
                // find inorder successor, copy data to root then delete inorder successor
                RBTNode temp = root;
                RBTNode inorderSuccessor = findInorderSuccessor(temp.right());
                root.setDestination(inorderSuccessor.getDestination());
                return remove(root.right(), inorderSuccessor.getDestination().getCity());
            }
            // one child, root has a left child
            else if (root.left() != null)
            {
                // if root is a left child of its parent set left child to left child of root
                if (root.parent().left() == root)
                {
                    root.parent().setLeft(root.left());
                }
                // if root is a right child of its parent set right child to left child of root
                else
                {
                    root.parent().setRight(root.left());
                }
                root = null;
                return true;
            }
            // one child, root has a right child
            else if (root.right() != null)
            {
                // if root is a left child of its parent set left child of parent to right child of root
                if (root.parent().left() == root)
                {
                    root.parent().setLeft(root.right());
                }
                // if root is a right child of its parent set right child of parent to right child of root
                else
                {
                    root.parent().setRight(root.right());
                }
                root = null;
                return true;
            }
            // no children
            else
            {
                // if root is a left child of parent
                if (root.parent().left() == root)
                {
                    root.parent().setLeft(null);
                }
                // if root is a right child of parent
                else
                {
                    root.parent().setRight(null);
                }
                root = null;
                return true;
            }
        }
    }

    // Finds the inorder successor for removal
    public RBTNode findInorderSuccessor(RBTNode root)
    {
        if (root.left() == null)
        {
            return root;
        }
        else
        {
            return findInorderSuccessor(root.left());
        }
    }

    // Called from adjustTree to rotate left, may be single or doubly rotated
    public void rotateLeft(RBTNode newNode)
    {
        if (newNode.parent() != null)
        {
            if (newNode == newNode.parent().left())
            {
                newNode.parent().setLeft(newNode.right());
            }
            else
            {
                newNode.parent().setRight(newNode.right());
            }
            newNode.right().setParent(newNode.parent());
            newNode.setParent(newNode.right());
            if (newNode.right().left() != null)
            {
                newNode.right().left().setParent(newNode);
            }
            newNode.setRight(newNode.right().left());
            newNode.parent().setLeft(newNode);
        }
        // rotate the root
        else
        {
            RBTNode temp = this.root.right();
            this.root.setRight(temp.left());
            temp.left().setParent(this.root);
            this.root.setParent(temp);
            temp.setLeft(this.root);
            temp.setParent(null);
            this.root = temp;
        }
    }

    // Called from adjustTree to rotate right, may be single or doubly rotated
    public void rotateRight(RBTNode newNode)
    {
        if (newNode.parent() != null)
        {
            if (newNode == newNode.parent().left())
            {
                newNode.parent().setLeft(newNode.left());
            }
            else
            {
                newNode.parent().setRight(newNode.left());
            }
            newNode.left().setParent(newNode.parent());
            newNode.setParent(newNode.left());
            if (newNode.left().right() != null)
            {
                newNode.left().right().setParent(newNode);
            }
            newNode.setLeft(newNode.left().right());
            newNode.parent().setRight(newNode);
        }
        // rotate the root
        else
        {
            RBTNode temp = this.root.left();
            this.root.setLeft(temp.left().right());
            temp.right().setParent(this.root);
            this.root.setParent(temp);
            temp.setRight(this.root);
            temp.setParent(null);
            this.root = temp;
        }
    }

    // This function will fix violations after insertion in the red-black tree.
    public void adjustTree(RBTNode newNode)
    {
       // TODO: while loop condition causing null pointer exceptions, adjustment doesn't work
        while (newNode.parent().color())
        {
            RBTNode uncle = null;
            if (newNode.parent() == newNode.parent().parent().left())
            {
                uncle = newNode.parent().parent().right();
                // if uncle is red
                if (uncle != null && uncle.color())
                {
                    newNode.parent().setBlack();
                    uncle.setBlack();
                    newNode.parent().parent().setRed();
                    newNode = newNode.parent().parent();
                    continue;
                }
                // double rotation
                if (newNode == newNode.parent().right())
                {
                    newNode = newNode.parent();
                    rotateLeft(newNode);
                }
                // single rotation
                newNode.parent().setBlack();
                newNode.parent().parent().setRed();
                rotateRight(newNode.parent().parent());
            }
            else
            {
                uncle = newNode.parent().parent().left();
                // if uncle is red
                if (uncle != null && uncle.color())
                {
                    newNode.parent().setBlack();
                    uncle.setBlack();
                    newNode.parent().parent().setRed();
                    newNode = newNode.parent().parent();
                    continue;
                }
                // need double rotation
                if (newNode == newNode.parent().left())
                {
                    newNode = newNode.parent();
                    rotateRight(newNode);
                }
                // single rotation
                newNode.parent().setBlack();
                newNode.parent().parent().setRed();
                rotateLeft(newNode.parent().parent());
            }
        }
        this.root.setBlack();
    }

    // Wrapper to print destinations in tree
    public void print()
    {
        if (root == null)
        {
            System.out.println("Empty tree, nothing to print");
        }
        else
        {
            print(root);
        }
    }

    // Recursively print destinations inorder
    public void print(RBTNode root)
    {
        if (root != null)
        {
            print(root.left());
            root.print();
            System.out.println("\n");
            print(root.right());
        }
    }

    // Wrapper to print all destinations + flights
    public void printAll()
    {
        if (root == null)
        {
            System.out.println("Empty tree, nothing to print");
        }
        else
        {
            printAll(root);
        }
    }

    // Print all destinations w/ their flights
    public void printAll(RBTNode root)
    {
        if (root != null)
        {
            printAll(root.left());
            root.print();
            System.out.println("\n");
            root.printLLL();
            printAll(root.right());
        }
    }

    // Wrapper to print all flights
    public void printFlightsOnly()
    {
        if (root == null)
        {
            System.out.println("Empty tree, nothign to print. ");
        }
        else
        {
            printFlightsOnly(root);
        }
    }

    // Print all flights
    public void printFlightsOnly(RBTNode root)
    {
        if (root != null)
        {
            printFlightsOnly(root.left());
            root.printLLL();
            printFlightsOnly(root.right());
        }
    }
}
