import java.sql.*;

public class GameRepository {
    private final String url = "url"
    private final String user = "postgres";
    private final String password = "postgres";

    // Prints all games from database.
    public void printAllGames() {
        String sql = "SELECT * FROM games";

        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                String identifier = resultSet.getString("identifier");
                String title = resultSet.getString("title");
                int releaseDay = resultSet.getInt("release_day");
                int releaseMonth = resultSet.getInt("release_month");
                int releaseYear = resultSet.getInt("release_year");
                int priceEuros = resultSet.getInt("price_euros");
                int priceCents = resultSet.getInt("price_cents");

                System.out.println(identifier + " | " + title + " | " + releaseDay + " | " + releaseMonth + " | "
                        + releaseDay + " | " + releaseMonth + " | " + releaseYear + " | " + priceEuros + " | " + priceCents + " | ");

            }

            resultSet.close();
            statement.close();
            connection.close();

        } catch (SQLException e) {
            System.out.println("Loading games data failed.");
        }
    }

    // Adds game to database.
    public boolean addGame(Game game) {
        String sql = "INSERT INTO games (identifier, title, release_day, release_month, release_year, price_euros, price_cents) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try {
            Connection connection = DriverManager.getConnection(url, user, password);

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, game.getIdentifier());
            statement.setString(2, game.getTitle());
            statement.setInt(3, game.getReleaseDate().getDay());
            statement.setInt(4, game.getReleaseDate().getMonth());
            statement.setInt(5, game.getReleaseDate().getYear());
            statement.setInt(6, game.getPrice().getEuros());
            statement.setInt(7, game.getPrice().getCents());

            statement.executeUpdate();
            connection.close();

            return true;

        } catch (SQLException e) {
            System.out.println("Adding game to database failed.");
            System.out.println(e.getMessage());

            return false;
        }
    }
}
