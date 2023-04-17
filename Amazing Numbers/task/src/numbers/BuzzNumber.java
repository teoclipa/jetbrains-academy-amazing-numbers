package numbers;

public class BuzzNumber {

    static public void checkBuzz(long number) {
        boolean buzz = number % 7 == 0 || number % 10 == 7;
        Properties.BUZZ.setProperty(buzz);

    }
}