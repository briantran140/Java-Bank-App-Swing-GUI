import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class MainScreenFrame extends JFrame {

    protected JButton searchCustomerButton;
    protected JButton addCustomerButton;
    protected JButton openAccountButton;
    protected JButton calculateInterestButton;
    protected JButton withdrawButton;
    protected JButton depositButton;
    protected JLabel optionLabel;

    public MainScreenFrame() {
        try {
            UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException |
                IllegalAccessException | UnsupportedLookAndFeelException e) {
            System.out.println(e);
        }
        initComponents();
    }

    private void initComponents() {
        // set up frame
        setTitle("Banking Application - Main Screen");
        setLocationByPlatform(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // set up buttons
        searchCustomerButton = new JButton("Search Customer");
        addCustomerButton = new JButton("Add Customer");
        openAccountButton = new JButton("Open Account");
        calculateInterestButton = new JButton("Calculate Interest");
        withdrawButton = new JButton("Withdraw");
        depositButton = new JButton("Deposit");

        // set size buttons
        searchCustomerButton.setPreferredSize(new Dimension(150, 30));
        addCustomerButton.setPreferredSize(new Dimension(150, 30));
        openAccountButton.setPreferredSize(new Dimension(150, 30));
        calculateInterestButton.setPreferredSize(new Dimension(150, 30));
        withdrawButton.setPreferredSize(new Dimension(150, 30));
        depositButton.setPreferredSize(new Dimension(150, 30));

        // set up buttons action listener
        searchCustomerButton.addActionListener(e -> searchCustomerClicked());
        addCustomerButton.addActionListener(e -> addCustomerClicked());
        openAccountButton.addActionListener(e -> openAccountClicked());
        calculateInterestButton.addActionListener(e -> calculateInterestClicked());
        withdrawButton.addActionListener(e -> withdrawClicked());
        depositButton.addActionListener(e -> depositClicked());

        // set up button panels
        JPanel buttonPanel = new JPanel(new GridBagLayout());
        buttonPanel.add(searchCustomerButton, BankingFrame.getConstraints(0, 1));
        buttonPanel.add(addCustomerButton, BankingFrame.getConstraints(1, 1));
        buttonPanel.add(openAccountButton, BankingFrame.getConstraints(0, 2));
        buttonPanel.add(calculateInterestButton, BankingFrame.getConstraints(1, 2));
        buttonPanel.add(withdrawButton, BankingFrame.getConstraints(0, 3));
        buttonPanel.add(depositButton, BankingFrame.getConstraints(1, 3));
        Border buttonPadding = BorderFactory.createEmptyBorder(0, 15, 20, 15);
        buttonPanel.setBorder(buttonPadding);

        // set up label
        optionLabel = new JLabel("Choose One Option");
        optionLabel.setFont(new Font("Times New Roman", Font.PLAIN, 25));

        //set up label panel
        JPanel labelPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        labelPanel.add(optionLabel);
        Border labelPadding = BorderFactory.createEmptyBorder(20, 0, 10 ,0);
        labelPanel.setBorder(labelPadding);

        // add panels to frame
        add(labelPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);

        pack();
        setResizable(false);
        setVisible(true);
    }

    private void searchCustomerClicked() {
        dispose();
        SearchCustomerFrame searchFrame = new SearchCustomerFrame();
    }

    private void addCustomerClicked() {
        dispose();
        AddCustomerFrame addCustomerFrame = new AddCustomerFrame();
    }

    private void openAccountClicked() {
        dispose();
        OpenAccountFrame openAccountFrame = new OpenAccountFrame();
    }

    private void calculateInterestClicked() {
        dispose();
        CalculateInterestFrame calculateInterestFrame = new CalculateInterestFrame();
    }

    private void withdrawClicked() {
        dispose();
        WithdrawFrame withdrawFrame = new WithdrawFrame();
    }

    private void depositClicked() {
        dispose();
        DepositFrame depositFrame = new DepositFrame();
    }

    public static void mainScreenClicked(JFrame frame) {
        frame.dispose();
        MainScreenFrame mainScreenFrame = new MainScreenFrame();
    }

}

