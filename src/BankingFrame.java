import javax.swing.*;
import java.awt.*;

public class BankingFrame extends JFrame {

    protected JLabel id;
    protected JTextField idField;
    protected JLabel firstName;
    protected JLabel lastName;
    protected JTextField firstNameField;
    protected JTextField lastNameField;
    protected JButton mainScreenButton;
    protected JPanel labelPanel;
    protected JPanel buttonPanel;

    public BankingFrame() {
        this.setLocationByPlatform(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // set up labels
        id = new JLabel("ID Number:");
        firstName = new JLabel("First Name:");
        lastName = new JLabel("Last Name:");

        // set up text fields
        idField = new JTextField(25);
        firstNameField = new JTextField(25);
        lastNameField = new JTextField(25);

        // set up buttons
        mainScreenButton = new JButton("Main Screen");
        mainScreenButton.setPreferredSize(new Dimension(120, 30));

        // add action listeners
        mainScreenButton.addActionListener(e -> MainScreenFrame.mainScreenClicked(this));

        // set up label panel
        labelPanel = new JPanel(new GridBagLayout());
        labelPanel.add(id, BankingFrame.getConstraints(0, 0));
        labelPanel.add(idField, BankingFrame.getConstraints(1, 0));
        labelPanel.add(firstName, BankingFrame.getConstraints(0, 1));
        labelPanel.add(lastName, BankingFrame.getConstraints(0, 2));
        labelPanel.add(firstNameField, BankingFrame.getConstraints(1, 1));
        labelPanel.add(lastNameField, BankingFrame.getConstraints(1, 2));

        // set up button panel
        buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.add(mainScreenButton);

        this.add(labelPanel, BorderLayout.CENTER);
        this.add(buttonPanel, BorderLayout.SOUTH);
        this.setResizable(false);
        this.pack();
        this.setVisible(true);
    }

    public static GridBagConstraints getConstraints(int x, int y) {
        GridBagConstraints c = new GridBagConstraints();
        c.anchor = GridBagConstraints.LINE_START;
        c.insets = new Insets(20, 30, 20, 30);
        c.gridx = x;
        c.gridy = y;
        return c;
    }
}
