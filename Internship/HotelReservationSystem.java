import java.util.ArrayList;
import java.util.Scanner;

class Room {
    int roomNumber;
    String category;
    boolean isBooked;

    Room(int roomNumber, String category) {
        this.roomNumber = roomNumber;
        this.category = category;
        this.isBooked = false;
    }
}

public class HotelReservationSystem {

    static ArrayList<Room> rooms = new ArrayList<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        rooms.add(new Room(101, "Standard"));
        rooms.add(new Room(102, "Standard"));
        rooms.add(new Room(201, "Deluxe"));
        rooms.add(new Room(202, "Deluxe"));
        rooms.add(new Room(301, "Suite"));

        while (true) {

            System.out.println("\n===== HOTEL RESERVATION SYSTEM =====");
            System.out.println("1. View Available Rooms");
            System.out.println("2. Book Room");
            System.out.println("3. Cancel Reservation");
            System.out.println("4. View Booking Details");
            System.out.println("5. Exit");

            System.out.print("Enter Choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    viewRooms();
                    break;

                case 2:
                    System.out.print("Enter Room Number to Book: ");
                    int bookRoom = sc.nextInt();
                    bookRoom(bookRoom);
                    break;

                case 3:
                    System.out.print("Enter Room Number to Cancel: ");
                    int cancelRoom = sc.nextInt();
                    cancelReservation(cancelRoom);
                    break;

                case 4:
                    viewBookingDetails();
                    break;

                case 5:
                    System.out.println("Thank You!");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }

    static void viewRooms() {
        System.out.println("\nAvailable Rooms:");

        for (Room room : rooms) {
            if (!room.isBooked) {
                System.out.println(
                        "Room No: " + room.roomNumber +
                        " | Category: " + room.category);
            }
        }
    }

    static void bookRoom(int roomNo) {

        for (Room room : rooms) {

            if (room.roomNumber == roomNo) {

                if (!room.isBooked) {
                    room.isBooked = true;
                    System.out.println("Room Booked Successfully!");
                } else {
                    System.out.println("Room Already Booked!");
                }
                return;
            }
        }

        System.out.println("Room Not Found!");
    }

    static void cancelReservation(int roomNo) {

        for (Room room : rooms) {

            if (room.roomNumber == roomNo) {

                if (room.isBooked) {
                    room.isBooked = false;
                    System.out.println("Reservation Cancelled!");
                } else {
                    System.out.println("Room is Not Booked!");
                }
                return;
            }
        }

        System.out.println("Room Not Found!");
    }

    static void viewBookingDetails() {

        System.out.println("\nBooked Rooms:");

        boolean found = false;

        for (Room room : rooms) {

            if (room.isBooked) {
                found = true;
                System.out.println(
                        "Room No: " + room.roomNumber +
                        " | Category: " + room.category);
            }
        }

        if (!found) {
            System.out.println("No Rooms Booked.");
        }
    }
}