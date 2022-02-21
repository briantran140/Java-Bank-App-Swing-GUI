import javax.swing.*;
import java.awt.*;

public class WithdrawFrame extends BankingFrame {

    private JLabel accountNumber;
    private JTextField accountNumberField;
    private JLabel withdrawAmount;
    private JTextField withdrawAmountField;
    private JButton withdrawButton;

    public WithdrawFrame() {
        this.setTitle("App - Withdraw");

        // set up labels and their fields
//        accountNumber = new JLabel("Account Number:");
//        accountNumberField = new JTextField(20);
        withdrawAmount = new JLabel("Withdraw Amount:");
        withdrawAmountField = new JTextField(25);

        // add them to the label panel
//        labelPanel.add(accountNumber, BankingFrame.getConstraints(0, 2));
//        labelPanel.add(accountNumberField, BankingFrame.getConstraints(1, 2));
        labelPanel.add(withdrawAmount, BankingFrame.getConstraints(0, 1));
        labelPanel.add(withdrawAmountField, BankingFrame.getConstraints(1, 1));
        labelPanel.remove(firstName);
        labelPanel.remove(firstNameField);
        labelPanel.remove(lastName);
        labelPanel.remove(lastNameField);

        // set up button
        withdrawButton = new JButton("Withdraw");
        withdrawButton.setPreferredSize(new Dimension(100, 30));
        withdrawButton.addActionListener(e -> withdrawClicked());
        // add it to the button panel
        buttonPanel.add(withdrawButton);
        pack();
    }

    public void withdrawClicked() {
        String errorMsg = "";
        errorMsg += BankAppDriver.isPresent(idField.getText().trim(), "ID Number");
        errorMsg += BankAppDriver.isGreaterThanZeroDouble(withdrawAmountField.getText().trim(), "Withdraw Amount");

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

        double customerWithdrawAmount = Double.parseDouble(withdrawAmountField.getText().trim());
        if(customerWithdrawAmount > searchedCustomer.getBalance()) {
            JOptionPane.showMessageDialog(this, "Withdraw Amount is greater than the balance.",
                    "Invalid data", JOptionPane.ERROR_MESSAGE);
            return;
        }
        searchedCustomer.getSavingsAccount().withdraw(customerWithdrawAmount);
        BankAppDriver.updateCustomerDatabase(searchedCustomer);
        JOptionPane.showMessageDialog(this, "Withdraw successful",
                "Successful", JOptionPane.PLAIN_MESSAGE);
    }
}
