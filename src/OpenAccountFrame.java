import javax.swing.*;
import java.awt.*;

public class OpenAccountFrame extends AddCustomerFrame {

    public OpenAccountFrame() {
        this.setTitle("Banking App - Open Account");
        JButton openAccountButton = new JButton("Open Account");
        openAccountButton.setPreferredSize(new Dimension(120, 30));
        openAccountButton.addActionListener(e -> openAccountClicked());
        buttonPanel.remove(addButton);
        buttonPanel.add(openAccountButton);
    }

    private void openAccountClicked() {
        // validation
        String errorMsg = BankAppDriver.errorMsg(idField, firstNameField, lastNameField, addressField, phoneNumberField);

        if (!errorMsg.isEmpty()) {
            JOptionPane.showMessageDialog(this, errorMsg,
                    "Invalid data", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // check to see if customer already exists.
        Customer customerDatabase = BankAppDriver.getCustomer(idField.getText());
        // if the driver doesn't exist, we will add new customer to our database with a 6 digit savings account number
        if (customerDatabase == null) {
            Customer newCustomer = new Customer(idField.getText(), firstNameField.getText(),
                    lastNameField.getText(), addressField.getText(), phoneNumberField.getText());
            newCustomer.setSavingsAccount(new SavingsAccount());
            BankAppDriver.addCustomerDatabase(newCustomer);
        } else { // if the customer already exists, we will update their information if they enter different information in the form
            // and generate a 6 digit savings account number attached to their id number.
            customerDatabase.setFirstName(firstNameField.getText());
            customerDatabase.setLastName(lastNameField.getText());
            customerDatabase.setAddress(addressField.getText());
            customerDatabase.setPhoneNumber(phoneNumberField.getText());
            customerDatabase.setSavingsAccount(new SavingsAccount());
            BankAppDriver.updateCustomerDatabase(customerDatabase);
        }
    }
}
