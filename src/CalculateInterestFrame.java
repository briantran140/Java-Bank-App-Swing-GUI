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
//        accountNumber = new JLabel("Account Number:");
//        accountNumberField = new JTextField(25);
        interestMonth = new JLabel("Interest Month:");
        interestMonthField = new JTextField(25);
        calculatedInterest = new JLabel("Calculated Interest:");
        calculatedInterestField = new JTextField(25);

        // add to label panel
//        labelPanel.add(accountNumber, BankingFrame.getConstraints(0, 3));
//        labelPanel.add(accountNumberField, BankingFrame.getConstraints(1, 3));
        labelPanel.add(interestMonth, BankingFrame.getConstraints(0 ,3));
        labelPanel.add(interestMonthField, BankingFrame.getConstraints(1, 3));
        labelPanel.add(calculatedInterest, BankingFrame.getConstraints(0, 4));
        labelPanel.add(calculatedInterestField, BankingFrame.getConstraints(1, 4));

        // set up button
        calculateInterestButton = new JButton("Calculate Interest");
        calculatedInterestField.setEditable(false);
        calculateInterestButton.setPreferredSize(new Dimension(150, 30));

        // add button to button panel
        buttonPanel.add(calculateInterestButton);
        pack();
    }
}
