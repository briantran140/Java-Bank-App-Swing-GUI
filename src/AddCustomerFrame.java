import javax.swing.*;
import java.awt.*;

public class AddCustomerFrame extends BankingFrame {

    protected JLabel address;
    protected JLabel phoneNumber;
    protected JTextField addressField;
    protected JTextField phoneNumberField;
    protected JButton addButton;

    public AddCustomerFrame() {
        setTitle("Banking App - Add Customer");

        // set up labels
        address = new JLabel("Address");
        phoneNumber = new JLabel("Phone Number");

        // set up buttons
        addButton = new JButton("Add");
        addButton.setPreferredSize(new Dimension(70, 30));

        // add action listeners
        addButton.addActionListener(e -> addClicked());

        // remove old text fields
        labelPanel.remove(firstNameField);
        labelPanel.remove(lastNameField);   

        // set up text fields
        firstNameField = new JTextField(25);
        lastNameField = new JTextField(25);
        addressField = new JTextField(25);
        phoneNumberField = new JTextField(25);

        // set up label panel
        labelPanel.add(firstNameField, BankingFrame.getConstraints(1, 1));
        labelPanel.add(lastNameField, BankingFrame.getConstraints(1, 2));
        labelPanel.add(address, BankingFrame.getConstraints(0, 3));
        labelPanel.add(addressField, BankingFrame.getConstraints(1, 3));
        labelPanel.add(phoneNumber, BankingFrame.getConstraints(0, 4));
        labelPanel.add(phoneNumberField, BankingFrame.getConstraints(1, 4));

        // set up button panel
        buttonPanel.add(addButton);
        pack();
    }

    private void addClicked() {
        String errorMsg = BankAppDriver.errorMsg(idField,firstNameField,lastNameField,addressField,phoneNumberField);

        if(errorMsg.isEmpty()) {
            Customer customer = new Customer(idField.getText(), firstNameField.getText(),
                    lastNameField.getText(), addressField.getText(), phoneNumberField.getText());
            BankAppDriver.addCustomerDatabase(customer);
            String customerName = firstNameField.getText() + " " + lastNameField.getText();
            JOptionPane.showMessageDialog(this, customerName +  " is added successful",
                    "Successful", JOptionPane.PLAIN_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, errorMsg,
                    "Invalid data", JOptionPane.ERROR_MESSAGE);
        }
    }

}
