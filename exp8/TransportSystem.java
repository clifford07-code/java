package exp8;

import java.util.Scanner;

abstract class Transport {
    abstract void move();
}

abstract class PublicTransport extends Transport {
    abstract double ticketFare();
}

class Bus extends PublicTransport {
    private double distance;

    Bus(double distance) {
        this.distance = distance;
    }

    public double getDistance() { return distance; }
    public void setDistance(double distance) { this.distance = distance; }

    void move() {
        System.out.println("Bus is moving");
    }

    double ticketFare() {
        return distance * 2; 
    }
}

public class TransportSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter distance: ");
        double d = sc.nextDouble();

        Bus b = new Bus(d);

        b.move();
        System.out.println("Fare: " + b.ticketFare());
    }
}