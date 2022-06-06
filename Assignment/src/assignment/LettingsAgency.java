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

public class LettingsAgency {

    private ArrayList<Property> theProperty;
    private int maxProperty;
    private String lettingsAgencyName;

    /**
     * Creats an instance of a letting agency.
     * @param name - name of the letting agency
     * @param num - number of properies the agency can handel.
     */
    public LettingsAgency(String name, int num) {
        lettingsAgencyName = name;
        maxProperty = num;
        theProperty = new ArrayList<Property>(maxProperty);

    }

    /**
     * Adds a new property ensuring that there is enough room to add a new property.
     * @param newProperty - the property to be added
     * @return - boolean as to whether this is enough room to add anoher property
     */
    public boolean addProperty(Property newProperty) {
        if (theProperty.size() == maxProperty) {
            return false;
        } else {
            theProperty.add(newProperty);
            return true;
        }
    }

    /**
     * Returns an array list if the properties of houses that are free.
     * @return rp - arraylist of the property
     */
    public ArrayList outputFreeHouseDetails() {
        ArrayList<Property> rp = new ArrayList<Property>(maxProperty);

        for (Property p : theProperty) {
            if (p instanceof House) {
                if (p.getFree() == true) {
                    rp.add(p);
                }
            }
        }
        return rp;
    }

    /**
     * Returns an array list if the properties of lodging that are free.
     * @return rp - arraylist of the property
     */
    public ArrayList outputFreeLodgingDetails() {
        ArrayList<Property> rp = new ArrayList<Property>(maxProperty);

        for (Property p : theProperty) {
            if (p instanceof Lodging) {
                if (p.getFree() == true) {
                    rp.add(p);
                }
            }
        }
        return rp;

    }

    /**
     * Returns an array list of all properties.
     * @return rp - arraylist of the property
     */
    public ArrayList outputPropertyDetails() {
        ArrayList<Property> rp = new ArrayList<Property>(maxProperty);

        for (Property p : theProperty) {
            rp.add(p);
        }
        return rp;
    }

    /**
     * Finds a property based upon the address of the the property
     * @param address - the address of the property
     * @return p - the property if found
     */
    public Property findProperty(String address) {
        for (int i = 0; i < theProperty.size(); i++) {
            Property p = theProperty.get(i);

            if (p.getAddress().equalsIgnoreCase(address)) {
                return p;
            }
        }
        return null;
    }

    /**
     * Uses the find property method to find a property and delete it
     * @param address - the address of the property to be deleted
     * @return - boolean as to whether the property was or wasn't deleted
     */
    public boolean deleteProperty(String address) {
        Property p = findProperty(address);
        if (p != null) {
            theProperty.remove(p);

            return true;
        }
        return false;
    }

    /**
     * Rest a property for re-rental.
     * @param address - the address of the property to be rest
     * @return - boolean as to whether or not the address was found
     */
    public boolean reRentProperty(String address) {
        Property p = findProperty(address);
        if (p != null) {
            p.setTFirstName("");
            p.setTLastName("");
            p.setFree(true);

            return true;
        }
        return false;
    }

    /**
     * Enables a property to be classed as being rented with name of the tenant being recorded
     * @param address - address of the property
     * @param tFirstName - tenant's first name
     * @param tLastName - tenant's surname
     * @return - boolean as to whether the proerty was found or not.
     */
    public boolean rentProperty(String address, String tFirstName, String tLastName) {
        Property p = findProperty(address);
        if (p != null) {
            p.setTFirstName(tFirstName);
            p.setTLastName(tLastName);
            p.setFree(false);

            return true;
        }
        return false;
    }
}
