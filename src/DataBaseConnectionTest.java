import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DataBaseConnectionTest {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/gamestore";
        String user = "postgres";
        String password = "postgres";

        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println("Połączono z bazą danych!");
        } catch (SQLException e) {
            System.out.println("Błąd połączenia z siecią.");
        }
    }
}
