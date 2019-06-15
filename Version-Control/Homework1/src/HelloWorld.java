import java.io.PrintStream;
import java.util.Scanner;


public class HelloWorld {
    public static void main(String[] args) {
        String name;
        boolean check = false;
        int day, month, year;
        //Ask a user to enter his/her name and birthday
        Scanner scanner = new Scanner(System.in);
        System.out.println("What is your name");
        name = scanner.nextLine();
        do {
            System.out.println("Please type your day of birthday:");
            day = scanner.nextInt();
            System.out.println("Please type your month of birthday:");
            month = scanner.nextInt();
            System.out.println("Please type your year of birthday:");
            year = scanner.nextInt();
            //If the birthday is not a valid date, ask her again until it is
            if (new DateUtil().checkDate(day, month, year)) {
                check = false;
            } else {
                check = true;
                System.out.println("\nYour Date of Birth is wrong. Please check again!!");
            }
        } while (check);
        //Say hello to that person 
        System.out.println("Hello " + name);
        System.out.println("Your age is " + DateUtil.calculateAge(year));
    }
}
