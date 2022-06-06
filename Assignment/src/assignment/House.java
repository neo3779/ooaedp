/*
 * CE00882-1  Object Oriented and Event Driven Programming
 * Assignment
 */
package assignment;

/**
 * Alex J Davison
 * @author dv003874
 */
import java.util.*;

public class House extends Property {

    private int numOfRooms;
    private static double fee = 30.00;
    private double tfee = 0.0;

    /**
     * Creates a blank house.
     */
    public House() {
        this("", "", "", 0.0, 0);
    }

    /**
     * Creates a house with the following details:
     * Note: Also sets the total fee.
     * @param firstName - the landlord's first name
     * @param lastName - the landlord's surname
     * @param address - address of the property
     * @param rent - the cost/rent for the property
     * @param numOfRooms - the number of rooms the property has
     */
    public House(String firstName, String lastName, String address, double rent, int numOfRooms) {
        super(firstName, lastName, address, rent);
        this.numOfRooms = numOfRooms;
        tfee = (fee * getNumOfRooms() + (getRent() / 2));
        tfee = Math.round(tfee + 0.3d);
    }

    /**
     * Returns the number of rooms the property has
     * @return numOfRooms - the number of rooms the property has
     */
    public int getNumOfRooms() {
        return numOfRooms;
    }

    /**
     * Returns the calulated rent for te property
     * @return trent - the cost/rent for the property
     */
    public double getFee() {
        return tfee;
    }

    /**
     * Returns then details of a house
     * @return s - string from property class, the number of rooms and fee from the house class
     */
    public String toString() {
        String s = super.toString() + "\n  Number of rooms: " + getNumOfRooms() + "\n  Fee: £" + getFee() + "\n \n";
        return s;
    }
}
