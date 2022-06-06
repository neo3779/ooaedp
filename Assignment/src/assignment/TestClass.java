/*
 * CE00882-1  Object Oriented and Event Driven Programming
 * Assignment
 */
package assignment;

/**
 * Alex J Davison
 * @author dv003874
 */
public class TestClass {

    public static void main(String[] args) {
        House H1 = new House("Alex", "Davison", "12 Haughton", 120.50, 3);
        House H2 = new House("Dainie", "Smith", "17 Ranton", 100.00, 2);

        Lodging L1 = new Lodging("Eddie", "Smith", "13 Haughton", 49.99, true);
        Lodging L2 = new Lodging("Dan", "Baxter", "11 Haughton", 49.99, false);

        System.out.println("House 1");
        System.out.println();
        System.out.println(H1.toString());
        System.out.println("House 2");
        System.out.println();
        System.out.println(H2.toString());
        System.out.println("Lodging 1");
        System.out.println();
        System.out.println(L1.toString());
        System.out.println("Lodging 2");
        System.out.println();
        System.out.println(L2.toString());
        System.out.println();

        System.out.println("Get house 1 address");
        System.out.println(H1.getAddress());
        System.out.println("Get house 1 fee");
        System.out.println(H1.getFee());
        System.out.println("Get house 1 free");
        System.out.println(H1.getFree());
        System.out.println("Get house 1 landlord's fullname");
        System.out.println(H1.getFullName());
        System.out.println("Get house 1 number of rooms");
        System.out.println(H1.getNumOfRooms());
        System.out.println("Get house 1 rent");
        System.out.println(H1.getRent());
        System.out.println("Get house 1 tenant's fullname");
        System.out.println(H1.getTFullName());
        System.out.println("Get house 1 free (Text Verison)");
        System.out.println(H1.getTextFree());
        System.out.println();

        H1.setFree(false);
        H1.setTFirstName("Dainie");
        H1.setTLastName("Smith");

        System.out.println("Get lodging 1 address");
        System.out.println(L1.getAddress());
        System.out.println("Get lodging 1 fee");
        System.out.println(L1.getFee());
        System.out.println("Get lodging 1 free");
        System.out.println(L1.getFree());
        System.out.println("Get lodging 1 landlord's fullname");
        System.out.println(L1.getFullName());
        System.out.println("Get lodging 1 room only");
        System.out.println(L1.getRoomOnly());
        System.out.println("Get lodging 1 rent");
        System.out.println(L1.getRent());
        System.out.println("Get lodging 1 tenant's fullname");
        System.out.println(L1.getTFullName());
        System.out.println("Get lodging 1 free (Text Verison)");
        System.out.println(L1.getTextFree());
        System.out.println("Get lodging 1 room only (Text Verison)");
        System.out.println(L1.getTextRoomOnly());
        System.out.println();

        L1.setFree(false);
        L1.setTFirstName("Alex");
        L1.setTLastName("Davison");

        System.out.println("House 1");
        System.out.println();
        System.out.println(H1.toString());
        System.out.println("House 2");
        System.out.println();
        System.out.println(H2.toString());
        System.out.println("Lodging 1");
        System.out.println();
        System.out.println(L1.toString());
        System.out.println("Lodging 2");
        System.out.println();
        System.out.println(L2.toString());
        System.out.println();

    }
}
