package java8.joda_date_time_api;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class ZonedDateTimes {

    public static void main(String[] args) {
        ZoneId zone = ZoneId.systemDefault();

        System.out.println("My current system default zone id: " + zone);

        ZoneId losAngeles = ZoneId.of("America/Los_Angeles");
        ZonedDateTime zonedDateTime = ZonedDateTime.now(losAngeles);

        System.out.println("Loss-Angeles zoned date time is: " + zonedDateTime);
    }

}
