


import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class TimeConversion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the date and time (yyyy-MM-dd HH:mm:ss): ");
        String inputDateTime = scanner.nextLine();

        // Parse the input date and time
        LocalDateTime localDateTime = LocalDateTime.parse(inputDateTime, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        System.out.println("Available time zones:");
        ZoneId.getAvailableZoneIds().stream()
                .sorted()
                .forEach(System.out::println);

        System.out.print("Enter the source time zone: ");
        String sourceTimeZone = scanner.nextLine();

        System.out.print("Enter the target time zone: ");
        String targetTimeZone = scanner.nextLine();

        // Convert the local date and time to source time zone
        ZonedDateTime sourceZonedDateTime = localDateTime.atZone(ZoneId.of(sourceTimeZone));

        // Convert the source time zone to target time zone
        ZonedDateTime targetZonedDateTime = sourceZonedDateTime.withZoneSameInstant(ZoneId.of(targetTimeZone));

        // Format the target date and time
        String formattedDateTime = targetZonedDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        System.out.println("Converted date and time: " + formattedDateTime);

        scanner.close();
    }
}
