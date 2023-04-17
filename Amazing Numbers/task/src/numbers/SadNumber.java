package numbers;

public class SadNumber {

    static void checkSad(long n) {
        if (n == 1 || n == 7) {
            Properties.SAD.setProperty(false);
            return;
        }
        long sum = n;
        long x = n;

        // this loop executes till the sum of square of
        // digits obtained is not a single digit number
        while (sum > 9) {
            sum = 0;

            // this loop finds the sum of square of digits
            while (x > 0) {
                long d = x % 10;
                sum += d * d;
                x /= 10;
            }
            if (sum == 1) {
                Properties.SAD.setProperty(false);
                return;
            }
            x = sum;
        }
        if (sum == 7) {
            Properties.SAD.setProperty(false);
            return;
        }
        Properties.SAD.setProperty(true);
    }
}
