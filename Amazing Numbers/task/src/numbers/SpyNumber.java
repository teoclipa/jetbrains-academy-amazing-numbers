package numbers;

import java.util.ArrayList;

public class SpyNumber {

    public static void checkSpy(long number) {
        char[] digits = String.valueOf(number).toCharArray();
        int sum = 0;
        int product = 1;

        for (char c : digits) {
            sum += Character.getNumericValue(c);
            product *= Character.getNumericValue(c);
        }
        Properties.SPY.setProperty(sum == product);
    }
}
