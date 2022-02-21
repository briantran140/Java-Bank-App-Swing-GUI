import javax.swing.*;
import java.awt.*;

public class OpenAccountFrame extends AddCustomerFrame {

    private JLabel interestRate;
    private JTextField interestRateField;

    public OpenAccountFrame() {
        this.setTitle("Banking App - Open Account");

        interestRate = new JLabel("Interest Rate:");
        interestRateField = new JTextField(25);

        labelPanel.add(interestRate, BankingFrame.getConstraints(0 ,5));
        labelPanel.add(interestRateField, BankingFrame.getConstraints(1, 5));
        JButton openAccountButton = new JButton("Open Account");
        openAccountButton.setPreferredSize(new Dimension(120, 30));
        openAccountButton.addActionListener(e -> openAccountClicked());
        buttonPanel.remove(addButton);
        buttonPanel.add(openAccountButton);
        pack();
    }

    private void openAccountClicked() {
        // validation
        String errorMsg = BankAppDriver.errorMsg(idField, firstNameField, lastNameField, addressField, phoneNumberField, interestRateField);

        if (!errorMsg.isEmpty()) {
            JOptionPane.showMessageDialog(this, errorMsg,
                    "Invalid data", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // check to see if customer already exists.
        Customer customerDatabase = BankAppDriver.getCustomer(idField.getText());


        // If the customer exists and already has a savings account, return.
        if(customerDatabase != null && customerDatabase.getSavingsAccount() != null) {
            JOptionPane.showMessageDialog(this, " Customer that has ID number \"" + customerDatabase.getId() + "\" already has a savings account",
                    "Invalid", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Set up a new savings account for customer.
        SavingsAccount newSavingsAccount = new SavingsAccount();
        newSavingsAccount.setInterestRate(Double.parseDouble(interestRateField.getText()));

        // if the driver doesn't exist, we will add new customer to our database with a 6 digit savings account number
        String customerName = firstNameField.getText() + " " + lastNameField.getText();
        if (customerDatabase == null) {
            Customer newCustomer = new Customer(idField.getText(), firstNameField.getText(),
                    lastNameField.getText(), addressField.getText(), phoneNumberField.getText());
            newCustomer.setSavingsAccount(newSavingsAccount);

            BankAppDriver.addCustomerDatabase(newCustomer);

        } else { // if the customer exists but doesn't have a savings account, we will update their information if they enter different information in the form
            // and generate a 6 digit savings account number attached to their id number.
            customerDatabase.setFirstName(firstNameField.getText());
            customerDatabase.setLastName(lastNameField.getText());
            customerDatabase.setAddress(addressField.getText());
            customerDatabase.setPhoneNumber(phoneNumberField.getText());
            customerDatabase.setSavingsAccount(newSavingsAccount);

            BankAppDriver.updateCustomerDatabase(customerDatabase);
        }

        JOptionPane.showMessageDialog(this, customerName + "'s account is opened successful",
                "Successful", JOptionPane.PLAIN_MESSAGE);
    }
}
