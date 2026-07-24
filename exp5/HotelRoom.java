package exp5;

class HotelRoom {
    static int availableRooms = 10;
    boolean isBooked = false;

    void bookRoom() {
        if (!isBooked && availableRooms > 0) {
            isBooked = true;
            availableRooms--;
            System.out.println("Room booked successfully.");
        } else {
            System.out.println("Room not available.");
        }
    }

    void cancelBooking() {
        if (isBooked) {
            isBooked = false;
            availableRooms++;
            System.out.println("Booking cancelled.");
        } else {
            System.out.println("Room was not booked.");
        }
    }

    static int availableRooms() {
        return availableRooms;
    }
}

