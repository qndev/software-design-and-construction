
import java.util.Scanner;

public class FirtNumberApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner input = new Scanner(System.in);
        int numberInput;
        while (true) {
            System.out.println("Type a number : ");
            while (!input.hasNextInt()) {
                System.out.println("Sorry , Try again");
                input.next();
            }
            numberInput = input.nextInt();
            break;
        }
        int typeOfNumber = NumberUtil. checkPrimeNumber(numberInput);
        switch (typeOfNumber) {
            case NumberUtil.TYPE_NONE:
                System.out.println(numberInput + " is not prime and composite");
                break;
            case NumberUtil.PRIME_NUMBER:
                System.out.println(numberInput + " is a prime number");
                break;
            case NumberUtil.PERFECT_NUMBER:
                System.out.println(numberInput + " is a perfect number");
                break;
            default:
                System.out.println(numberInput + " is a composite number");
                break;
        }
        if (NumberUtil.isSquareNumber(numberInput)) {
            System.out.println(numberInput + " is a square number");
        } else {
            System.out.println(numberInput + " is not a square number");
        }
        if (NumberUtil.checkPerfectNumber(numberInput)) {
            System.out.println(numberInput + " is a perfect number");
        } else {
            System.out.println(numberInput + " is not a perfect number");
        }
    }
}
