import java.util.ArrayList;
import java.util.Scanner;

public class GameStore {
    public static void main(String[] args) {
        ArrayList<Game> games = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Enter game identifier: ");
            String inputIdentifier = sc.nextLine();

            if (inputIdentifier.isEmpty()) {
                break;
            } else {
                System.out.println("Enter game title: ");
                String inputGameTitle = sc.nextLine();
            }
        }
    }

    // Validate if input date is in correct format. Date returns in new SimpleDate object.
    public static SimpleDate readDate(Scanner sc) {
        while (true) {
            System.out.println("Enter release date (day.month.year)");
            String inputDate = sc.nextLine();
            if (!inputDate.matches("\\d{1,2}\\.\\d{1,2}\\d{4}")) {
                System.out.println("Wrong date format. Use day.month.year, for example 24.03.2017.");
                continue;
            }

            String[] dateParts = inputDate.split("\\.");
            int day = Integer.valueOf(dateParts[0]);
            int month = Integer.valueOf(dateParts[1]);
            int year = Integer.valueOf(dateParts[2]);

            if (day < 1 || day > 30) {
                System.out.println("Wrong day. Day must be between 1 and 30.");
                continue;
            }

            if (month < 1 || month > 12) {
                System.out.println("Wrong month. Month must be between 1 and 12.");
                continue;
            }

            if (year < 1 || year > 9999) {
                System.out.println("Wrong year. Year must cannot be below 9999.");
                continue;
            }

            return new SimpleDate(day, month, year);
        }
    }

    // Validate if input price is in correct format. Price returns as new Money object.
    public static Money readMoney(Scanner sc) {
        while (true) {
            System.out.println("Enter game price: ");
            String inputGamePrice = sc.nextLine();

            if (!inputGamePrice.matches("\\d{1,2}\\.\\d{1,2}")) {
                System.out.println("Wrong price format. Price format should be for example 19.99.");
                continue;
            }

            String[] moneyParts = inputGamePrice.split(".");

            int euros = Integer.valueOf(moneyParts[0]);
            int cents = Integer.valueOf(moneyParts[1]);

            if (euros < 0) {
                System.out.println("Invalid price. Euros cant be negative.");
                continue;
            }

            if (cents < 0 || cents > 100) {
                System.out.println("Invalid price. Cents cannot be below 100.");
                continue;
            }

            return new Money(euros, cents);
        }
    }
}
