package exp5;
import java.util.Scanner;

public class HotelTest {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        HotelRoom r1 = new HotelRoom();

        System.out.println("1. Book Room");
        System.out.println("2. Cancel Booking");
        int choice = sc.nextInt();

        if(choice == 1)
            r1.bookRoom();
        else if(choice == 2)
            r1.cancelBooking();

        System.out.println("Available Rooms: " + HotelRoom.availableRooms());
    }
}