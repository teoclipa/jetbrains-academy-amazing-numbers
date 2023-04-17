package numbers;

public class GapfulNumber {

    public static void checkGapful(long number) {
        if (number >= 100) {
            String firstDigit = String.valueOf(Long.toString(number).charAt(0));
            String lastDigit = String.valueOf(number % 10);
            int concat = Integer.parseInt(firstDigit + lastDigit);
            Properties.GAPFUL.setProperty(number % concat == 0);
        }

    }
}
