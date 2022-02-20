
import java.sql.*;

public class BankAppDriver {

    private static Connection connection;

    public static void main(String[] args) {
        MainScreenFrame frame = new MainScreenFrame();

        try {
            String dbURL = "jdbc:sqlite:bank.sqlite";
            connection = DriverManager.getConnection(dbURL);
            Statement statement = connection.createStatement();
            statement.execute("DROP TABLE IF EXISTS customers" );
            statement.execute("CREATE TABLE IF NOT EXISTS customers" +
                    " (ID TEXT PRIMARY KEY NOT NULL, FirstName TEXT NOT NULL, LastName TEXT NOT NULL, Address TEXT NOT NULL," +
                    " PhoneNumber TEXT NOT NULL, AccountNumber TEXT, Balance REAL, InterestRate REAL)");
        } catch (SQLException e) {
            System.err.println(e);
            return;
        }
    }

    public static void addCustomerDatabase(Customer customer) {

        String sql = "INSERT INTO customers (ID, FirstName, LastName, Address," +
                " PhoneNumber, AccountNumber, Balance, InterestRate) " +
                "VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            System.out.println(customer.getId());
            ps.setString(1, customer.getId());
            ps.setString(2, customer.getFirstName());
            ps.setString(3, customer.getLastName());
            ps.setString(4, customer.getAddress());
            ps.setString(5, customer.getPhoneNumber());
            if (customer.getSavingsAccount() != null) {
                ps.setString(6, customer.getAccountNumber());
                ps.setDouble(7, customer.getBalance());
                ps.setDouble(8, customer.getInterestRate());
            }
            ps.execute();

        } catch (SQLException e) {
            System.err.println("Customer can't be added.");
            System.err.println();
            e.printStackTrace();
        }
    }


}
