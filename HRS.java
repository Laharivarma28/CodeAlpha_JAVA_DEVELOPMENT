import java.util.*;

class Room {
    int roomNumber;
    String type;
    boolean isAvailable;
    double price;

    public Room(int roomNumber, String type, double price) {
        this.roomNumber = roomNumber;
        this.type = type;
        this.isAvailable = true;
        this.price = price;
    }
}

class Hotel {
    private final List<Room> rooms = new ArrayList<>();
    private final Map<Integer, String> reservations = new HashMap<>();
    
    public Hotel() {
        rooms.add(new Room(101, "Single", 100.0));
        rooms.add(new Room(102, "Double", 150.0));
        rooms.add(new Room(103, "Suite", 250.0));
    }
    
    public void showAvailableRooms() {
        System.out.println("Available Rooms:");
        for (Room room : rooms) {
            if (room.isAvailable) {
                System.out.println("Room " + room.roomNumber + " - " + room.type + " - $" + room.price);
            }
        }
    }
    
    public void bookRoom(int roomNumber, String guestName) {
        for (Room room : rooms) {
            if (room.roomNumber == roomNumber && room.isAvailable) {
                room.isAvailable = false;
                reservations.put(roomNumber, guestName);
                System.out.println("Room " + roomNumber + " booked successfully for " + guestName);
                return;
            }
        }
        System.out.println("Room not available!");
    }
    
    public void viewBookings() {
        System.out.println("Current Reservations:");
        for (var entry : reservations.entrySet()) {
            System.out.println("Room " + entry.getKey() + " - Booked by " + entry.getValue());
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Hotel hotel = new Hotel();
        
        while (true) {
            System.out.println("1. View Available Rooms  2. Book a Room  3. View Bookings  4. Exit");
            int choice = scanner.nextInt();
            
            if (choice == 4) break;
            
            switch (choice) {
                case 1 -> hotel.showAvailableRooms();
                case 2 -> {
                    System.out.println("Enter room number to book:");
                    int roomNumber = scanner.nextInt();
                    System.out.println("Enter guest name:");
                    String guestName = scanner.next();
                    hotel.bookRoom(roomNumber, guestName);
                }
                case 3 -> hotel.viewBookings();
                default -> System.out.println("Invalid choice!");
            }
        }
        
        scanner.close();
    }
}
