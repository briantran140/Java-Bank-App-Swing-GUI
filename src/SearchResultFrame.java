
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class SearchResultFrame extends OpenAccountFrame {

    private JLabel accountNumberLabel;
    private JTextField accountNumberField;
    private JLabel balanceLabel;
    private JTextField balanceField;
    private JButton previousCustomerButton;
    private JButton nextCustomerButton;
    private ArrayList<Customer> customerArrayList;
    private int arrayIndex; // we don't need to declare this in the constructor because it will be 0 by default.

    public SearchResultFrame(ArrayList<Customer> customerArrayList) {
        setTitle("Search Result");
        this.customerArrayList = customerArrayList;

        // set up labels and text fields
        accountNumberLabel = new JLabel("Account Number:");
        accountNumberField = new JTextField(25);
        balanceLabel = new JLabel("Balance:");
        balanceField = new JTextField(25);

        // add labels and fields to label panel
        labelPanel.add(accountNumberLabel, BankingFrame.getConstraints(0, 6));
        labelPanel.add(accountNumberField, BankingFrame.getConstraints(1, 6));
        labelPanel.add(balanceLabel, BankingFrame.getConstraints(0, 7));
        labelPanel.add(balanceField, BankingFrame.getConstraints(1, 7));

        // set up button
        previousCustomerButton = new JButton("Previous Customer");
        previousCustomerButton.setPreferredSize(new Dimension(140, 30));
        previousCustomerButton.addActionListener(e -> previousCustomerClicked());

        nextCustomerButton = new JButton("Next Customer");
        nextCustomerButton.setPreferredSize(new Dimension(120, 30));
        nextCustomerButton.addActionListener(e -> nextCustomerClicked());
        // add buttons to button panel
        buttonPanel.add(previousCustomerButton);
        buttonPanel.add(nextCustomerButton);
        buttonPanel.remove(openAccountButton);

        // disable all textFields.
        idField.setEditable(false);
        firstNameField.setEditable(false);
        lastNameField.setEditable(false);
        addressField.setEditable(false);
        phoneNumberField.setEditable(false);
        accountNumberField.setEditable(false);
        balanceField.setEditable(false);
        interestRateField.setEditable(false);

        showCustomer();
        pack();
    }

    private void previousCustomerClicked() {
        if (arrayIndex == 0) {
            JOptionPane.showMessageDialog(this, "There is no previous customer.",
                    "Invalid Data", JOptionPane.ERROR_MESSAGE);
            return;
        }

        arrayIndex--;
        emptyTextField();
        showCustomer();
    }

    private void nextCustomerClicked() {
        if (arrayIndex == customerArrayList.size() - 1) {
            JOptionPane.showMessageDialog(this, "There is no next customer.",
                    "Invalid Data", JOptionPane.ERROR_MESSAGE);
            return;
        }

        arrayIndex++;
        emptyTextField();
        showCustomer();
    }

    private void showCustomer() {
        Customer customer = customerArrayList.get(arrayIndex);
        idField.setText(customer.getId());
        firstNameField.setText(customer.getFirstName());
        lastNameField.setText(customer.getLastName());
        addressField.setText(customer.getAddress());
        phoneNumberField.setText(customer.getPhoneNumber());
        if (customer.getSavingsAccount() != null) {
            accountNumberField.setText(customer.getAccountNumber());
            balanceField.setText(customer.getBalance() + "");
            interestRateField.setText(customer.getInterestRate() + "%");
        }
    }

    private void emptyTextField() {
        idField.setText("");
        firstNameField.setText("");
        lastNameField.setText("");
        addressField.setText("");
        phoneNumberField.setText("");
        accountNumberField.setText("");
        balanceField.setText("");
        interestRateField.setText("");
    }
}
