import javax.swing.*;
import java.awt.*;

public class CalculateInterestFrame extends BankingFrame {

    private JLabel accountNumber;
    private JTextField accountNumberField;
    private JLabel interestMonth;
    private JTextField interestMonthField;
    private JLabel calculatedInterest;
    private JTextField calculatedInterestField;
    private JButton calculateInterestButton;

    public CalculateInterestFrame() {
        setTitle("App - Calculate Interest");

        // set up labels
        interestMonth = new JLabel("Interest Month:");
        interestMonthField = new JTextField(25);
        calculatedInterest = new JLabel("Calculated Interest:");
        calculatedInterestField = new JTextField(25);

        // add to label panel
        labelPanel.add(interestMonth, BankingFrame.getConstraints(0 ,3));
        labelPanel.add(interestMonthField, BankingFrame.getConstraints(1, 3));
        labelPanel.add(calculatedInterest, BankingFrame.getConstraints(0, 4));
        labelPanel.add(calculatedInterestField, BankingFrame.getConstraints(1, 4));

        firstNameField.setEditable(false);
        lastNameField.setEditable(false);
        // set up button
        calculateInterestButton = new JButton("Calculate Interest");
        calculatedInterestField.setEditable(false);
        calculateInterestButton.setPreferredSize(new Dimension(150, 30));
        calculateInterestButton.addActionListener(e -> calculateClicked());

        // add button to button panel
        buttonPanel.add(calculateInterestButton);
        pack();
    }

    public void calculateClicked() {
        String errorMsg = "";
        errorMsg += BankAppDriver.isPresent(idField.getText().trim(), "ID Number");
        errorMsg += BankAppDriver.isGreaterThanZeroDouble(interestMonthField.getText().trim(), "Interest Month");

        if (!errorMsg.isEmpty()) {
            JOptionPane.showMessageDialog(this, errorMsg,
                    "Invalid data", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // check if customer exists
        Customer searchedCustomer = BankAppDriver.getCustomer(idField.getText().trim());
        if(searchedCustomer == null) {
            JOptionPane.showMessageDialog(this, "Customer doesn't exist",
                    "Invalid data", JOptionPane.ERROR_MESSAGE);
            return;
        }
        firstNameField.setText(searchedCustomer.getFirstName());
        lastNameField.setText(searchedCustomer.getLastName());

        // check if customer has a savings account
        if(searchedCustomer.getSavingsAccount() == null) {
            JOptionPane.showMessageDialog(this, "Customer doesn't have a savings account",
                    "Invalid data", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // calculate interest
        double customerInterestMonth = Double.parseDouble(interestMonthField.getText().trim());
        double calculatedInterest = searchedCustomer.getBalance() * (searchedCustomer.getInterestRate() / 100) * (customerInterestMonth / 12);
        calculatedInterestField.setText(calculatedInterest + "");
    }
}
