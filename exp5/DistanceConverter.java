package exp5;
class DistanceConverter {

    static double kmToMiles(double km) {
        return km * 0.621371;
    }

    static double milesToKm(double miles) {
        return miles * 1.60934;
    }

    void displayConversion(double value) {
        System.out.println("KM to Miles: " + kmToMiles(value));
        System.out.println("Miles to KM: " + milesToKm(value));
    }
}