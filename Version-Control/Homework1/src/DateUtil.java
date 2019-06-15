import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
    static int MAX_VALID_YR = 9999;
    static int MIN_VALID_YR = 1800;

    // Returns true if  
    // given year is valid. 
    static boolean isLeap(int year) {
        // Return true if year is  
        // a multiple of 4 and not  
        // multiple of 100. 
        // OR year is multiple of 400. 
        return (((year % 4 == 0)
                && (year % 100 != 0))
                || (year % 400 == 0));
    }

    // Returns true if given  
    // year is valid or not. 
    static boolean checkDate(int d, int m, int y) {
        // If year, month and day  
        // are not in given range 
        if (y > MAX_VALID_YR
                || y < MIN_VALID_YR) {
            return false;
        }
        if (m < 1 || m > 12) {
            return false;
        }
        if (d < 1 || d > 31) {
            return false;
        }

        // Handle February month 
        // with leap year 
        if (m == 2) {
            if (isLeap(y)) {
                return (d <= 29);
            } else {
                return (d <= 28);
            }
        }

        // Months of April, June,  
        // Sept and Nov must have  
        // number of days less than 
        // or equal to 30. 
        if (m == 4 || m == 6
                || m == 9 || m == 11) {
            return (d <= 30);
        }
        return true;
    }

    private static Age calculateAge(Date birthDate) {
        int years = 0;
        int months = 0;
        int days = 0;

        //create calendar object for birth day
        Calendar birthDay = Calendar.getInstance();
        birthDay.setTimeInMillis(birthDate.getTime());

        //create calendar object for current day
        long currentTime = System.currentTimeMillis();
        Calendar now = Calendar.getInstance();
        now.setTimeInMillis(currentTime);

        //Get difference between years
        years = now.get(Calendar.YEAR) - birthDay.get(Calendar.YEAR);
        int currMonth = now.get(Calendar.MONTH) + 1;
        int birthMonth = birthDay.get(Calendar.MONTH) + 1;

        //Get difference between months
        months = currMonth - birthMonth;

        //if month difference is in negative then reduce years by one
        //and calculate the number of months.
        if (months < 0) {
            years--;
            months = 12 - birthMonth + currMonth;
            if (now.get(Calendar.DATE) < birthDay.get(Calendar.DATE)) {
                months--;
            }
        } else if (months == 0 && now.get(Calendar.DATE) < birthDay.get(Calendar.DATE)) {
            years--;
            months = 11;
        }

        //Calculate the days
        if (now.get(Calendar.DATE) > birthDay.get(Calendar.DATE)) {
            days = now.get(Calendar.DATE) - birthDay.get(Calendar.DATE);
        } else if (now.get(Calendar.DATE) < birthDay.get(Calendar.DATE)) {
            int today = now.get(Calendar.DAY_OF_MONTH);
            now.add(Calendar.MONTH, -1);
            days = now.getActualMaximum(Calendar.DAY_OF_MONTH) - birthDay.get(Calendar.DAY_OF_MONTH) + today;
        } else {
            days = 0;
            if (months == 12) {
                years++;
                months = 0;
            }
        }
        return new Age(days, months, years);
    }

    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date birthDate = sdf.parse("29/11/1981");
        Age age = calculateAge(birthDate);
        System.out.println(age);
    }

    public static int calculateAge(int year) {
         Date date = new Date();        
        return date.getYear()+1900 -year  >=0?date.getYear()+1900 -year:-1;
    }
}
