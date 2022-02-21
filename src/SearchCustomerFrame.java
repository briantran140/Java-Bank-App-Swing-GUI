import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class SearchCustomerFrame extends BankingFrame {

    private JButton searchButton;

    public SearchCustomerFrame() {
        setTitle("App - Search Customer");
        searchButton = new JButton("Search");
        searchButton.setPreferredSize(new Dimension(80, 30));
        searchButton.addActionListener(e -> searchClicked());
        buttonPanel.add(searchButton);
        labelPanel.remove(id);
        labelPanel.remove(idField);
    }

    private void searchClicked() {
        String errorMsg = BankAppDriver.errorMsg(firstNameField, lastNameField);

        if (!errorMsg.isEmpty()) {
            JOptionPane.showMessageDialog(this, errorMsg,
                    "Invalid data", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Customer searchedCustomer = BankAppDriver.getCustomer(firstNameField.getText().trim(), lastNameField.getText().trim());
//        System.out.println(searchedCustomer);
        if(searchedCustomer == null) {
            JOptionPane.showMessageDialog(this, "Customer doesn't exist",
                    "Invalid data", JOptionPane.ERROR_MESSAGE);
        }


        String msg = "";
        msg += "ID number: " + searchedCustomer.getId() + " \n";
        msg += "First name: " + searchedCustomer.getFirstName() + " \n";
        msg += "Last name: " + searchedCustomer.getLastName() + " \n";
        msg += "Address: " + searchedCustomer.getAddress() + " \n";
        msg += "Phone Number: " + searchedCustomer.getPhoneNumber() + " \n";

        System.out.println(searchedCustomer.getSavingsAccount());
        if (searchedCustomer.getSavingsAccount() != null) {
            msg += "Account Number: " + searchedCustomer.getAccountNumber() + " \n";
            msg += "Balance: " + searchedCustomer.getBalance() + " \n";
            msg += "Interest Rate: " + searchedCustomer.getInterestRate() + "\n";
        }
        System.out.println("hellu");
        JOptionPane.showMessageDialog(this, msg, "Customer data", JOptionPane.PLAIN_MESSAGE);
    }
}
