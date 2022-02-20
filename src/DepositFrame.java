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
//        accountNumber = new JLabel("Account Number:");
//        accountNumberField = new JTextField(20);
        depositAmount = new JLabel("Deposit Amount:");
        depositAmountField = new JTextField(25);

        // add them to the label panel
//        labelPanel.add(accountNumber, BankingFrame.getConstraints(0, 2));
//        labelPanel.add(accountNumberField, BankingFrame.getConstraints(1, 2));
        labelPanel.add(depositAmount, BankingFrame.getConstraints(0, 3));
        labelPanel.add(depositAmountField, BankingFrame.getConstraints(1, 3));

        // set up button
        depositButton = new JButton("Deposit");
        depositButton.setPreferredSize(new Dimension(100, 30));
        // add it to the button panel
        buttonPanel.add(depositButton);
        pack();
    }
}
