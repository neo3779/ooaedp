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

public class Lodging extends Property {

    private boolean roomOnly;
    private double fee;
    private static double feeRoomOnly = 50.00;
    private static double feeHalfBoard = 75.00;

    /**
     * Creates a blank lodging.
     */
    public Lodging() {
        this("", "", "", 0.0, false);
    }

    /**
     *
     * Creates a lodging with the following details:
     * @param firstName - the landlord's first name
     * @param lastName - the landlord's surname
     * @param address - address of the property
     * @param rent - the rent for the property.
     * @param roomOnly - whether the is room/halfboard true/false
     */
    public Lodging(String firstName, String lastName, String address, double rent, boolean roomOnly) {
        super(firstName, lastName, address, rent);
        this.roomOnly = roomOnly;
        if (roomOnly == true) {
            fee = feeRoomOnly;
        } else {
            fee = feeHalfBoard;
        }
    }

    /**
     * Return boolean on whether it is room only or not.
     * @return roomOnly - whether the is room/halfboard true/false
     */
    public boolean getRoomOnly() {
        return roomOnly;
    }

    /**
     * Return text verison on whether it is room only or not.
     * @return roomOnly - whether the is room/halfboard true/false
     */
    public String getTextRoomOnly() {
        if (roomOnly == true) {
            return "True";
        }

        return "False";
    }

    /**
     * Returns the fee to be paid
     * @return fee - The amount of money due
     */
    public double getFee() {
        return fee;
    }

    /**
     * Returns then details of a lodging
     * @return s - string from property class, room only and fee from the lodging class
     */
    public String toString() {
        String s = super.toString() + "\n  Room only: " + getTextRoomOnly() + "\n  Fee: £" + getFee() + "\n \n";
        return s;
    }
}
