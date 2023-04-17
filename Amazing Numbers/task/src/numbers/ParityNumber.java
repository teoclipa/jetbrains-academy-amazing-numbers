package numbers;

public class ParityNumber {

    static public void checkParity(long number) {
        if (number % 2 == 1) {
            Properties.ODD.setProperty(true);
        } else {
            Properties.EVEN.setProperty(true);
        }

    }

}
