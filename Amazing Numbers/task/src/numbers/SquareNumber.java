package numbers;

public class SquareNumber {

    public static void checkSquare(long number) {
        if (number == 1) {
            Properties.SQUARE.setProperty(true);
        } else {
            double sqrt = Math.sqrt(number);
            Properties.SQUARE.setProperty((sqrt - Math.floor(sqrt)) == 0);
        }
    }
}
