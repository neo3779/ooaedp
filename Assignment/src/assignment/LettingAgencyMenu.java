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

public class LettingAgencyMenu {

    private LettingsAgency theLettingsAgency = new LettingsAgency("Octagon Lettings Agency", 5);
    private Scanner kybd = new Scanner(System.in);

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        LettingAgencyMenu tMenu = new LettingAgencyMenu();
        tMenu.go();
    }

    /**
     *
     */
    public void go() {
        System.out.println("Welcome to the Octagon Lettings Agency");
        int choice = showMenu();
        while (choice != 9) {
            switch (choice) {
                case 1:
                    addHouse();
                    break;
                case 2:
                    addLodging();
                    break;
                case 3:
                    outputHouseDetails();
                    break;
                case 4:
                    outputLodgingDetails();
                    break;
                case 5:
                    outputPropertiesDetails();
                    break;
                case 6:
                    rentProperty();
                    break;
                case 7:
                    reRentProperty();
                    break;
                case 8:
                    removeProperty();
                    break;
                default:
                    System.out.println("Not a valid option, try again");
            }
            choice = showMenu();
        }
        System.out.println("Thank you for running the Octagon Lettings Agency program");
    }

    /**
     *
     * @return
     */
    public int showMenu() {
        System.out.println("Please select an option");
        System.out.println("1:  Add a house");
        System.out.println("2:  Add a lodging");
        System.out.println("3:  Display all free houses");
        System.out.println("4:  Display all free lodging");
        System.out.println("5:  Display all properties");
        System.out.println("6:  Rent property");
        System.out.println("7:  Re-Rent property");
        System.out.println("8:  Remove property");
        System.out.println("9:  Exit");
        System.out.println("Please enter choice? ");
        return kybd.nextInt();
    }

    /**
     *
     */
    public void addHouse() {
        // flush input
        kybd.nextLine();
        System.out.println("Landlord's first name?  ");
        String firstName = kybd.nextLine();
        System.out.println("Landlord's surname?  ");
        String lastName = kybd.nextLine();
        System.out.println("Property's address? ");
        String address = kybd.nextLine();
        System.out.println("Cost per month? ");
        double cost = kybd.nextDouble();
        System.out.println("Number of rooms? ");
        int rooms = kybd.nextInt();
        House h = new House(firstName, lastName, address, cost, rooms);
        if (theLettingsAgency.addProperty(h)) {
            System.out.println("New house added");
        } else {
            System.out.println("Sorry, the agency can't take on any more properties at this time.");
        }
    }

    /**
     *
     */
    public void addLodging() {
        // flush input
        kybd.nextLine();
        System.out.println("Landlord's first name?  ");
        String firstName = kybd.nextLine();
        System.out.println("Landlord's surname?  ");
        String lastName = kybd.nextLine();
        System.out.println("Property's address? ");
        String address = kybd.nextLine();
        System.out.println("Cost per month? ");
        double cost = kybd.nextDouble();
        System.out.println("Room only? ");
        boolean roomOnly = kybd.nextBoolean();
        Lodging l = new Lodging(firstName, lastName, address, cost, roomOnly);
        if (theLettingsAgency.addProperty(l)) {
            System.out.println("New lodging added");
        } else {
            System.out.println("Sorry, the agency can't take on any more properties at this time.");
        }
    }

    /**
     *
     */
    public void outputHouseDetails() {
        System.out.println("List of free houses: ");

        System.out.println(theLettingsAgency.outputFreeHouseDetails().toString());
    }

    /**
     *
     */
    public void outputLodgingDetails() {
        System.out.println("List of free lodgings: ");

        System.out.println(theLettingsAgency.outputFreeLodgingDetails().toString());
    }

    /**
     *
     */
    public void outputPropertiesDetails() {
        System.out.println("List of properties: ");

        System.out.println(theLettingsAgency.outputPropertyDetails().toString());

    }

    /**
     *
     */
    public void rentProperty() {
        kybd.nextLine();
        System.out.println("Please enter the addess of the property");
        String address = kybd.nextLine();
        System.out.println("Please enter the first name of the tenant");
        String tFirstName = kybd.next();
        System.out.println("Please enter the last name of the tenant");
        String tLastName = kybd.next();
        if (theLettingsAgency.rentProperty(address, tFirstName, tLastName)) {
            System.out.println("Property rented.");
        } else {
            System.out.println("Sorry, property not found.");
        }
    }

    /**
     *
     */
    public void reRentProperty() {
        kybd.nextLine();
        System.out.println("Please enter the addess of the property");
        String address = kybd.nextLine();
        if (theLettingsAgency.reRentProperty(address)) {
            System.out.println("Property rest");
        } else {
            System.out.println("Sorry, property not found.");
        }
    }

    /**
     *
     */
    public void removeProperty() {
        kybd.nextLine();

        System.out.println("Property's address? ");
        String address = kybd.nextLine();
        if (theLettingsAgency.deleteProperty(address)) {
            System.out.println("Property removed.");
        } else {
            System.out.println("Sorry, property not found.");
        }
    }
}


