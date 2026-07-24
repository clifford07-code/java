package exp6;

final class MathUtility {

    public int square(int n) {
        return n * n;
    }

    public int cube(int n) {
        return n * n * n;
    }
}

public class FinalDemo {
    public static void main(String[] args) {

        MathUtility m = new MathUtility();

        int num = 3;

        System.out.println("Square: " + m.square(num));
        System.out.println("Cube: " + m.cube(num));
    }
}