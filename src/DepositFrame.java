import javax.swing.*;
import java.awt.*;

public class DepositFrame extends BankingFrame {

    private JLabel accountNumber;
    private JTextField accountNumberField;
    private JLabel depositAmount;
    private JTextField depositAmountField;
    private JButton depositButton;

    public DepositFrame() {
        this.setTitle("App - Deposit");

        // set up labels and their fields
        depositAmount = new JLabel("Deposit Amount:");
        depositAmountField = new JTextField(25);

        // add them to the label panel
        labelPanel.add(depositAmount, BankingFrame.getConstraints(0, 1));
        labelPanel.add(depositAmountField, BankingFrame.getConstraints(1, 1));
        labelPanel.remove(firstName);
        labelPanel.remove(firstNameField);
        labelPanel.remove(lastName);
        labelPanel.remove(lastNameField);

        // set up button
        depositButton = new JButton("Deposit");
        depositButton.setPreferredSize(new Dimension(100, 30));
        depositButton.addActionListener(e -> depositClicked());
        // add it to the button panel
        buttonPanel.add(depositButton);
        pack();
    }

    public void depositClicked() {
        String errorMsg = "";
        errorMsg += BankAppDriver.isPresent(idField.getText().trim(), "ID Number");
        errorMsg += BankAppDriver.isGreaterThanZeroDouble(depositAmountField.getText().trim(), "Deposit Amount");

        if (!errorMsg.isEmpty()) {
            JOptionPane.showMessageDialog(this, errorMsg,
                    "Invalid data", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // check if customer exists
        Customer searchedCustomer = BankAppDriver.getCustomer(idField.getText());
        if(searchedCustomer == null) {
            JOptionPane.showMessageDialog(this, "Customer doesn't exist",
                    "Invalid data", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // check if customer has a savings account
        if(searchedCustomer.getSavingsAccount() == null) {
            JOptionPane.showMessageDialog(this, "Customer doesn't have a savings account",
                    "Invalid data", JOptionPane.ERROR_MESSAGE);
            return;
        }

        double customerDepositAmount = Double.parseDouble(depositAmountField.getText().trim());

        searchedCustomer.getSavingsAccount().deposit(customerDepositAmount);
        BankAppDriver.updateCustomerDatabase(searchedCustomer);
        JOptionPane.showMessageDialog(this, "Deposit successful",
                "Successful", JOptionPane.PLAIN_MESSAGE);
    }
}
