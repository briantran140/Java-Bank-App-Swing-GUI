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
        labelPanel.add(withdrawAmount, BankingFrame.getConstraints(0, 3));
        labelPanel.add(withdrawAmountField, BankingFrame.getConstraints(1, 3));

        // set up button
        withdrawButton = new JButton("Withdraw");
        withdrawButton.setPreferredSize(new Dimension(100, 30));
        // add it to the button panel
        buttonPanel.add(withdrawButton);
        pack();
    }
}
