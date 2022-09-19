package MyDate;

public class MyDate {

    private static Object another;

    private int year;
    private int month;
    private int day;
    private static String[] strMonths = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
    private static String[] strDays = {"Sunday", "Monday", "Tuesday", "Wedensday", "Thursday", "Fridy", "Saturday"};
    private static int[] DaysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public static boolean isLeapYear(int year) {
        if (year % 4 != 0) {
            return false;
        } else if (year % 400 == 0) {
            return true;
        } else if (year % 100 == 0) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean isValidDate(int year, int month, int day) {
        int getMonthLastDay = DaysInMonth[month - 1] + (isLeapYear(year) && month == 2 ? 1 : 0);
        return (1 <= year && year <= 9999)
                && (1 <= month && month <= 12)
                && (1 <= day && day <= getMonthLastDay);
    }

    public static int getDayOfWeek(int year, int month, int day) {
     final int[] nonLeapYearMonthNumbers = {0, 3, 3, 6, 1, 4, 6, 2, 5, 0, 3, 5};
     final int[] leapYearMonthNumbers = {6, 2, 3, 6, 1, 4, 6, 2, 5, 0, 3, 5};
    if (! isValidDate(year, month, day) 
        ) {
            return -1;
    }
    int magicCenturyNumber = 6 - 2 * ((year / 100) % 4);
    int lastTwoDigitsOfYear = year % 100;
    int magicYearNumber = lastTwoDigitsOfYear / 4;
    int magicMonthNumber = isLeapYear(year) ? leapYearMonthNumbers[month - 1] : nonLeapYearMonthNumbers[month - 1];
    int magicDayNumber = day;
    return (  magicCenturyNumber + lastTwoDigitsOfYear 
    + magicYearNumber    + magicMonthNumber + magicDayNumber

) % 7; 
    }

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }
    
 public void setDate(int year, int month, int day)
    {
        if (! isValidDate(year, month, day)) {
            throw new IllegalArgumentException("Invalid year, month, or day!");
        }
        this.year  = year;
        this.month = month;
        this.day   = day;
    }
  public String toString() {
        int weekDay = getDayOfWeek(year, month, day);
        return String.format("%1$s %2$d %3$s %4$d", strDays[weekDay], day, strMonths[month-1], year);
    }
   public MyDate nextDay(){
       int getMonthLastDay = DaysInMonth[month-1] + (isLeapYear(year) && month == 2 ? 1 : 0 );
          int maxDay = getMonthLastDay;
        if (maxDay == day && 12 == month && 9999 == year) {
            return this;
        }

        if (maxDay == day && 12 == month) {
            setDate(year+1, 1, 1);
            return this;
        }

        if (maxDay == day) {
            setDate(year, month+1, 1);
            return this;
        }
        
        setDate(year, month, day+1);
        return this;
   }
public MyDate nextMonth()
    {
         int getMonthLastDay = DaysInMonth[month-1] + (isLeapYear(year) && month == 2 ? 1 : 0 );
          int maxDay = getMonthLastDay;
        if (12 == month && 9999 == year) {
            return this;
        }

        if (day == getMonthLastDay) {
            maxDay = maxDay;
        }
        else if (day > maxDay) {
            maxDay = maxDay;
        }
        else if (day < maxDay) {
            maxDay = day;
        }

        if (12 == month) {
            setDate(year+1, 1, maxDay);
            return this;
        }

        setDate(year, month+1, maxDay);
        return this;
    }

       public MyDate nextYear()
    {
        if (9999== year) {
            return this;
        }
int getMonthLastDay = DaysInMonth[month-1] + (isLeapYear(year) && month == 2 ? 1 : 0 );
        int maxDay = getMonthLastDay;

        if (day == getMonthLastDay) {
            maxDay = maxDay;
        }
        else if (day > maxDay) {
            maxDay = maxDay;
        }
        else if (day < maxDay) {
            maxDay = day;
        }

        setDate(year+1, month, maxDay);
        return this;
    }
       public MyDate previousDay()
    {
        if (1 == day && 1 == month && 1 == year) {
            return this;
        }
int getMonthLastDay = DaysInMonth[month-1] + (isLeapYear(year) && month == 2 ? 1 : 0 );
        if (1 == day && 1 == month) {
            setDate(year-1, 12, getMonthLastDay);
            return this;
        }

        if (1 == day) {
            setDate(year, month-1, getMonthLastDay);
            return this;
        }
        
        setDate(year, month, --day);
        return this;
    }
       public MyDate previousMonth()
    {
        if (1 == month && 1 == year) {
            return this;
        }
int getMonthLastDay = DaysInMonth[month-1] + (isLeapYear(year) && month == 2 ? 1 : 0 );
        int maxDay = (1 == month)
                ?   getMonthLastDay
                :   getMonthLastDay;

        if (day == getMonthLastDay) {
            maxDay = maxDay;
        }
        else if (day > maxDay) {
            maxDay = maxDay;
        }
        else if (day < maxDay) {
            maxDay = day;
        }

        if (1== month) {
            setDate(year-1, 12, maxDay);
            return this;
        }

        setDate(year, month-1, maxDay);
        return this;
    }

  public MyDate previousYear()
    {
        if (1 == year) {
            return this;
        }
int getMonthLastDay = DaysInMonth[month-1] + (isLeapYear(year) && month == 2 ? 1 : 0 );
        int maxDay = getMonthLastDay;

        if (day == getMonthLastDay) {
            maxDay = maxDay;
        }
        else if (day > maxDay) {
            maxDay = maxDay;
        }
        else if (day < maxDay) {
            maxDay = day;
        }

        setDate(year-1, month, maxDay);
        return this;
    }
}
