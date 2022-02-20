import javax.swing.*;
import java.awt.*;

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

    }
}
