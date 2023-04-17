package numbers;

import java.util.ArrayList;

public class JumpingNumber {

    public static void checkJumping(long number) {

        if (number < 10 && number > 0) {
            Properties.JUMPING.setProperty(true);
            return;
        }

        ArrayList<Integer> digits = new ArrayList<>();
        String n = String.valueOf(number);

        for (int i = 0; i < n.length(); i++) {
            digits.add((int) n.charAt(i));
        }
        for (int i = 0; i < digits.size() - 1; i++) {
            int diff = Math.abs(digits.get(i) - digits.get(i + 1));
            if (diff != 1) {
                Properties.JUMPING.setProperty(false);
                break;
            }
            Properties.JUMPING.setProperty(true);
        }

    }
}
