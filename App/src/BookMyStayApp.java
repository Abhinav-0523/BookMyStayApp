MAIN CLASS - BookMyStayApp
================================================================================================================

Use Case 2: Displaying Room Types and Availability
Use Case 3: Centralized Room Inventory Management

Description:
This program demonstrates object-oriented modeling of hotel room types using abstraction, inheritance,
encapsulation, and polymorphism. The system defines an abstract Room class that represents common room
        characteristics, while concrete classes (SingleRoom, DoubleRoom, and SuiteRoom) extend it to represent
specific room types.
This program demonstrates centralized inventory management for hotel rooms using a HashMap.
Instead of storing room availability in scattered variables, the system introduces a dedicated
RoomInventory component responsible for maintaining and managing availability for all room types.

Room objects are created when the application runs, and their availability is stored using simple
variables. The program then displays the room details along with their availability in the console.
Room objects still model the characteristics of each room type using abstraction, inheritance,
encapsulation, and polymorphism. However, room availability is now stored in a single HashMap
that maps room types to their available counts. The inventory class provides controlled methods
        to retrieve and update availability, ensuring consistent state management across the system.

This design introduces the concept of a single source of truth, improves scalability, and
separates room domain modeling from inventory management logic.

@author Abhinav-0523
@version 2.0
@version 3.0
        ================================================================================================================
        */

        import java.util.HashMap;

abstract class Room
{
    private int beds;
    @@ -97,32 +103,65 @@ public String getRoomType()
}
}

class RoomInventory
{
    private HashMap<String,Integer> inventory;

    public RoomInventory()
    {
        inventory=new HashMap<String,Integer>();
        inventory.put("Single Room",5);
        inventory.put("Double Room",3);
        inventory.put("Suite Room",2);
    }

    public int getAvailability(String roomType)
    {
        return inventory.get(roomType);
    }

    public void updateAvailability(String roomType,int count)
    {
        inventory.put(roomType,count);
    }

    public void displayInventory()
    {
        for(String roomType:inventory.keySet())
        {
            System.out.println(roomType+" Available: "+inventory.get(roomType));
        }
    }
}

public class BookMyStayApp
{
    public static void main(String args[])
    {
        System.out.println("Welcome to Hotel Booking Management System!");
        System.out.println("Version: 2.0");
        System.out.println("Version: 3.0");
        System.out.println("Author: Abhinav-0523");
        System.out.println();

        Room single=new SingleRoom();
        Room doubleRoom=new DoubleRoom();
        Room suite=new SuiteRoom();

        int singleAvailability=5;
        int doubleAvailability=3;
        int suiteAvailability=2;
        RoomInventory inventory=new RoomInventory();

        single.displayRoomDetails();
        System.out.println("Available Rooms: "+singleAvailability);
        System.out.println("Available Rooms: "+inventory.getAvailability(single.getRoomType()));
        System.out.println();

        doubleRoom.displayRoomDetails();
        System.out.println("Available Rooms: "+doubleAvailability);
        System.out.println("Available Rooms: "+inventory.getAvailability(doubleRoom.getRoomType()));
        System.out.println();

        suite.displayRoomDetails();
        System.out.println("Available Rooms: "+suiteAvailability);
        System.out.println("Available Rooms: "+inventory.getAvailability(suite.getRoomType()));
        System.out.println();

        System.out.println("Current Inventory State:");
        inventory.displayInventory();
    }
}