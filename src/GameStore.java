import java.util.ArrayList;
import java.util.Scanner;

public class GameStore {
    public static void main(String[] args) {
        ArrayList<Game> games = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        while(true) {
            System.out.println("Enter game identifier: ");
            String inputIdentifier = sc.nextLine();

            if (inputIdentifier.isEmpty()) {
                break;
            }
            System.out.println("Enter game title: ");
            String inputGameTitle = sc.nextLine();

            if (inputGameTitle.isEmpty()) {
                System.out.println("Title cannot be empty. Try again.");
                continue;
            }

            SimpleDate inputReleaseDate = readDate(sc);
            Money inputPrice = readMoney(sc);

            Game game = new Game(inputIdentifier, inputGameTitle, inputReleaseDate, inputPrice);

            if (!games.contains(game)) {
                games.add(game);
            } else {
                System.out.println("The game is already on the list. Try again.");
            }
        }
        System.out.println("=== GAMES LIST ===");
        for (Game game : games) {
            System.out.println(game);
        }
        System.out.println();
        System.out.println("Total games in list: " + games.size());

        Money totalValue = new Money(0,0);

        for (Game game : games) {
            totalValue = totalValue.plus(game.getPrice());
        }

        System.out.println("Total inventory value: " + totalValue);
    }

    // Validate if input date is in correct format. Date returns in new SimpleDate object.
    public static SimpleDate readDate(Scanner sc) {
        while (true) {
            System.out.println("Enter release date (day.month.year)");
            String inputDate = sc.nextLine();

            if (inputDate.isEmpty()) {
                System.out.println("Input is empty. Try again.");
                continue;
            }
            if (!inputDate.matches("\\d{1,2}\\.\\d{1,2}\\.\\d{4}")) {
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
                System.out.println("Wrong year. Year must be between 1 and 9999.");
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

            if (inputGamePrice.isEmpty()) {
                System.out.println("Input is empty. Try again.");
                continue;
            }

            if (!inputGamePrice.matches("\\d+\\.\\d{2}")) {
                System.out.println("Wrong price format. Price format should be for example 19.99.");
                continue;
            }

            String[] moneyParts = inputGamePrice.split("\\.");

            int euros = Integer.valueOf(moneyParts[0]);
            int cents = Integer.valueOf(moneyParts[1]);

            if (cents < 0 || cents > 99) {
                System.out.println("Invalid price. Cents must be between 0 and 99.");
                continue;
            }

            return new Money(euros, cents);
        }
    }
}
