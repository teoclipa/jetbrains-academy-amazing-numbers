package numbers;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class PalindromicNumber {

    public static void checkPalindrome(long number) {
        NumberFormat nf = new DecimalFormat("#.####");
        String inputNumber = nf.format(number);
        String reverseNumber = new StringBuilder(inputNumber).reverse().toString();

        Properties.PALINDROMIC.setProperty(reverseNumber.equals(inputNumber));


    }
}

