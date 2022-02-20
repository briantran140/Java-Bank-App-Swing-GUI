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
        // check to see if customer already exists.
        // if customer already exists in database, but put in different first name, last name, address and phone number, we will update the new information
        // if first, last name and other information is still the same, we keep it.


        // if customer doesn't exist in database, we will add a new customer to our database with their new information and give them a savings account number
    }
}
