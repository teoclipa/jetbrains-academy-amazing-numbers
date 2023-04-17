package numbers;

public class DuckNumber {

    static public void checkDuck(long number) {

        while (number != 0) {
            long remainder = number % 10;
            if (remainder == 0) {
                Properties.DUCK.setProperty(true);
            }
            number = number / 10;
        }

    }
}
