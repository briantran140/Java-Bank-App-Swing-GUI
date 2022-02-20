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

    }
}
