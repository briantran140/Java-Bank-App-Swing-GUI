
import javax.swing.*;
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
            ps.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Customer can't be added.");
            System.err.println();
            e.printStackTrace();
        }
    }

    public static Customer getCustomer(String id) {
        String sql = "SELECT ID, FirstName, LastName, Address," +
                " PhoneNumber, AccountNumber, Balance, InterestRate" +
                " FROM customers WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
//                String customerID = rs.getString("ID");
                String firstName = rs.getString("FirstName");
                String lastName = rs.getString("LastName");
                String address = rs.getString("Address");
                String phoneNumber = rs.getString("PhoneNumber");
                Customer customer = new Customer(id, firstName, lastName, address, phoneNumber);
                String accountNumber = rs.getString("accountNumber");
                if(accountNumber != null) {
                    Double balance = rs.getDouble("Balance");
                    Double interestRate = rs.getDouble("InterestRate");
                    customer.setSavingsAccount(new SavingsAccount(accountNumber,
                            balance, interestRate));
                }

                rs.close();
                return customer;
            } else {
                rs.close();
                return null;
            }
        } catch (SQLException e) {
            System.err.println(e);
            return null;
        }
    }

    public static String errorMsg(JTextField idField, JTextField firstNameField, JTextField lastNameField, JTextField addressField, JTextField phoneNumberField) {
        String errorMsg = "";
        errorMsg += isPresent(idField.getText(), "ID number");
        errorMsg += isPresent(firstNameField.getText(), "First Name");
        errorMsg += isPresent(lastNameField.getText(), "Last Name");
        errorMsg += isPresent(addressField.getText(), "Address");
        errorMsg += isPresent(phoneNumberField.getText(), "Phone Number");

        return errorMsg;
    }

    public static String isPresent(String value, String name) {
        String msg = "";
        if (value.isEmpty()) {
            msg = name + " is required. \n";
        }
        return msg;
    }
    
}



















