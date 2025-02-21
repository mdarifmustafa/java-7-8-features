package java8.joda_date_time_api;

import java.time.*;
import java.util.Scanner;

public class Basic {
    public static void main(String[] args) {
        LocalDate date = LocalDate.now();
        System.out.println("local date now is: " + date);

        LocalTime time = LocalTime.now();
        System.out.println("local time now is: " + time);

        LocalDateTime dateTime = LocalDateTime.now();
        System.out.println("local date and time now is: " + dateTime);

        int dd = date.getDayOfMonth();
        int MM = date.getMonthValue();
        int yyyy = date.getYear();

        System.out.println("day value: " + dd + ", month value: " + MM + ", and year is: " + yyyy);

        int hh = time.getHour();
        int mm = time.getMinute();
        int ss = time.getSecond();
        int nn = time.getNano();

        // Even you can get this whole set of values i.e. dd,MM,yyyy hh:mm:ss:nn using dateTime variable directly instead of getting from separated variable date and time.

        System.out.printf("%d:%d:%d:%d", hh, mm, ss, nn);

        // creating new LocalDateTime object using above micro variables
        LocalDateTime newLocalDateTime = LocalDateTime.of(yyyy, Month.MAY, dd, hh, mm, ss, nn);

        System.out.println(newLocalDateTime);

        System.out.println("6 months earlier date: " + newLocalDateTime.minusMonths(6));
        System.out.println("3 months after date: " + newLocalDateTime.plusMonths(3));


        LocalDateTime birthday = LocalDateTime.of(1989, 8, 28, 05, 05, 05, 05);
        LocalDateTime today = LocalDateTime.now();

        // period needs LocalDate start and end objects, hence we need to cast the LocalDateTime object to LocalDate object
        Period period = Period.between(birthday.toLocalDate(), today.toLocalDate());

        System.out.printf("Age is: %d years %d months %d days\n", period.getYears(), period.getMonths(), period.getDays());

        LocalDate deathDay = LocalDate.of(birthday.getYear() + 60, birthday.getMonth(), birthday.getDayOfMonth());
        System.out.println(deathDay);

        Period leftPeriod = Period.between(today.toLocalDate(), deathDay);
        System.out.printf("Left age is: %d years %d months %d days\n", leftPeriod.getYears(), leftPeriod.getMonths(), leftPeriod.getDays());

        // here years and months could vary because of leap year and month's days count, but just calculating for round off!
        int totalDaysLeft = leftPeriod.getYears() * 365 + leftPeriod.getMonths() * 30 + leftPeriod.getDays();

        System.out.println("leftPeriod days are: " + totalDaysLeft);

        System.out.print("\n------------------------------------\nEnter your year number: ");
        Scanner scanner = new Scanner(System.in);
        int isoYear = scanner.nextInt();

        Year year = Year.of(isoYear);
        if (year.isLeap()) {
            System.out.println(year + " is a leap year!");
        } else {
            System.out.println(year + " is not leap year!");
        }

        scanner.close();

    }
}
