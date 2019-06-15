
import java.util.Scanner;

public class NumberUtil {
    public static final int TYPE_NONE = 0;
    public static final int PRIME_NUMBER = 1;
    public static final int COMPOSITE_NUMBER = 2;
    public static final int PERFECT_NUMBER = 3;

    /*
     * This method checks whether a number is prime or not.
     * Returns true if the number is prime, false otherwise.
     */
    public static int checkPrimeNumber(int number) {
        if (number < 2) {
            return TYPE_NONE;
        }
        if (isPrimeNumber(number)) {
            return PRIME_NUMBER;
        }
        return COMPOSITE_NUMBER;
    }

    public static boolean isPrimeNumber(int integer) {
        if (integer < 2) {
            return false;                         // If that integer is <2 then it is not prime
        } else {
            if (integer == 2 || integer == 3) {
                return true;                     //If integer = 2 or = 3 then it is prime

            }
        }
        for (int i = 2; i <= (int) Math.sqrt(integer); i++) {
            if ((integer % i) == 0) // Take integer divide by two int numbers from 2 to square root of integer
            {
                return false;      // If integer is divisible by 1 in the numbers of the sequence, then the integer is not prime
            }
        }
        return true;

    }

    /*
     * This method checks if a number is a composite or not.
     * Returns true if it is a union, false otherwise.
     */
    public static boolean isCompositeNumber(int integer) {
        if (integer < 4) {
            return false;                                 // If integer <4 then that is not a composite	
        } else {
            if (isPrimeNumber(integer) == true) {
                return false;                            // If the integer mak is prime, then it is not an integer
            }
        }
        return true;                                     // otherwise the opposite
    }

    /*
 * This method checks to see if an int number is a square number or not.
 * Returns true if the square number, Returns false if it is not a square number
     */
    public static boolean isSquareNumber(int integer) {
        int sqrt = (int) Math.sqrt(integer);          // Calculates the square root of the integer and then takes the int value
        int square = (int) Math.pow(sqrt, 2);        // squared value of int
        if (square == integer) {
            return true;             // If the square is equal to the original number then the number is the square
        } else {
            return false;            // Otherwise it is not a square number
        }
    }

    int divisor(int x) {
        return x;
    }

    public static boolean checkPerfectNumber(int number) {
        int sum = 0;
        for (int i = 1; i < number; i++) {
            if (number % i == 0) {
                sum = sum + i;
            }
        }
        if (sum == number) {
            System.out.println("Given number is Perfect");
            return true;
        } else {
            System.out.println("Given number is not Perfect");
            return false;
        }
    }
}
