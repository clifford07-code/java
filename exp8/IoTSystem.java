package exp8;
import java.util.Scanner;

interface RemoteControl {
    void turnOn();
}

abstract class Appliance {

    static void applianceType() {
        System.out.println("Home Appliance");
    }

    abstract void operate();
}

class AirConditioner extends Appliance implements RemoteControl {

    private int temperature;

    AirConditioner(int temperature) {
        this.temperature = temperature;
    }

    public int getTemperature() { return temperature; }
    public void setTemperature(int temperature) { this.temperature = temperature; }

    public void turnOn() {
        System.out.println("AC Turned ON");
    }

    void operate() {
        System.out.println("Cooling at " + temperature + " degrees");
    }
}

public class IoTSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Temperature: ");
        int temp = sc.nextInt();

        AirConditioner ac = new AirConditioner(temp);

        Appliance.applianceType();
        ac.turnOn();
        ac.operate();
    }
}