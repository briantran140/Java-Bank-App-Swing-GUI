import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class SearchCustomerFrame extends BankingFrame {

    private JButton searchButton;

    public SearchCustomerFrame() {
        setTitle("App - Search Customer");
        searchButton = new JButton("Search");
        searchButton.setPreferredSize(new Dimension(80, 30));
        searchButton.addActionListener(e -> searchClicked());
        buttonPanel.add(searchButton);
        labelPanel.remove(id);
        labelPanel.remove(idField);
    }

    private void searchClicked() {
        String errorMsg = BankAppDriver.errorMsg(firstNameField, lastNameField);

        if (!errorMsg.isEmpty()) {
            JOptionPane.showMessageDialog(this, errorMsg,
                    "Invalid data", JOptionPane.ERROR_MESSAGE);
            return;
        }

        ArrayList<Customer> customerArrayList = BankAppDriver.getCustomerArrayList(firstNameField.getText().trim(), lastNameField.getText().trim());
        if(customerArrayList.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Customer doesn't exist",
                    "Invalid data", JOptionPane.ERROR_MESSAGE);
            return;
        }
        dispose();
        SearchResultFrame searchResultFrame = new SearchResultFrame(customerArrayList);

    }
}
