/*
 * CE00882-1  Object Oriented and Event Driven Programming
 * Assignment
 */
package assignment;

/**
 * Alex J Davison
 * @author dv003874
 */
public abstract class Property
{

    private String firstName;
    private String lastName;
    private String address;
    private double rent;
    private boolean free;
    private String tFirstName;
    private String tLastName;

    /**
     * Allows you to set whether the property is free or not.
     * @param free - boolean for property availability
     */
    public void setFree(boolean free)
    {
        this.free = free;
    }

    /**
     * Allows for a tenant's first name to be recorded against a property
     * @param tFirstName - tenant's first name
     */
    public void setTFirstName(String tFirstName)
    {
        this.tFirstName = tFirstName;
    }

    /**
     * Allows for a tenant's surname to be recorded against a property
     * @param tLastName - tenant's surname
     */
    public void setTLastName(String tLastName)
    {
        this.tLastName = tLastName;
    }

    /**
     * Returns the landlord's full name
     * @return - string of landlord's full name
     */
    public String getFullName()
    {
        return firstName + " " + lastName;
    }

    /**
     * Returns the tenant's full name
     * @return - string of tenant's full name
     */
    public String getTFullName()
    {
        return tFirstName + " " + tLastName;
    }

    /**
     * Returns the addess of the property
     * @return - string of the addess of the property
     */
    public String getAddress()
    {
        return address;
    }

    /**
     * Returns the rent of the property
     * @return - double of the rent of the property
     */
    public double getRent()
    {
        return rent;
    }

    /**
     * Returns the rent of the property times two for the first moonth
     * @return  - double of the  first mounts rent of the property
     */

    public double getFRent()
    {
        return rent*2;
    }

    /**
     * Returns whether the property is free or not
     * @return - boolean of the free status of the property
     */
    public boolean getFree()
    {
        return free;
    }

    /**
     * Returns whether the property is free or not (mainly to ensure capital T and F)
     * @return - string of the free status of the property
     */
    public String getTextFree()
    {
        if (free = true)
        {
            return "True";
        }

        return "False";
    }

    /**
     * Returns then details of a property
     * @return s - string of the property's details
     */
    public String toString()
    {
        String s = " Landlord's name: " + getFullName() + "\n  Address: " + getAddress() + "\n  Rent: £" + getRent() + "\n  First amount of rent: £" + getFRent() + "\n  Free: " + getTextFree() + "\n  Tenant's name: " + getTFullName();
        return s;
    }

    /**
     * Makes a blank property
     */
    public Property()
    {
        this("", "", "", 0.0);
    }

    /**
     * Creates a property with the following details:
     * @param firstName - the landlord's first name
     * @param lastName - the landlord's surname
     * @param address - address of the property
     * @param rent - the cost/rent for the property
     */
    public Property(String firstName, String lastName, String address, double rent)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.rent = rent;
        free = true;
        tFirstName = "";
        tLastName = "";

    }

    /**
     * Sets the fee of all the properties to 0.0 at first
     * @return - 0.0
     */
    public double getFee()
    {
        return 0.0;
    }
}
