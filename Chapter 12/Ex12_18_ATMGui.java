// Exercise 12.18: GUI-Based Version of the ATM Case Study
// A simplified, self-contained ATM GUI (no separate BankDatabase/Account
// classes from Chapters 33-34) that approximates the screen flow with GUI
// components: a card-number/PIN screen, a main menu, and balance/withdraw/
// deposit screens using "Remove Cash" and "Insert Envelope" buttons.
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.HashMap;
import java.util.Map;

public class Ex12_18_ATMGui extends JFrame {

    // Very small stand-in "database": account number -> PIN, account number -> balance
    private final Map<String, String> pins = new HashMap<>();
    private final Map<String, Double> balances = new HashMap<>();

    private String currentAccount;

    private final CardLayout cardLayout = new CardLayout();
    private final JPanel screens = new JPanel();

    // Login screen components
    private final JTextField accountField = new JTextField(10);
    private final JPasswordField pinField = new JPasswordField(10);
    private final JLabel loginMessage = new JLabel(" ");

    // Main menu screen
    private final JLabel welcomeLabel = new JLabel(" ", SwingConstants.CENTER);

    // Balance screen
    private final JLabel balanceLabel = new JLabel(" ", SwingConstants.CENTER);

    // Withdrawal screen
    private final JComboBox<String> withdrawAmountCombo =
        new JComboBox<>(new String[] { "$20", "$40", "$60", "$100", "$200" });
    private final JLabel withdrawMessage = new JLabel(" ", SwingConstants.CENTER);
    private final JButton removeCashButton = new JButton("Remove Cash");
    private double pendingWithdrawal;
    private boolean cashReady;

    // Deposit screen
    private final JTextField depositField = new JTextField(10);
    private final JLabel depositMessage = new JLabel(" ", SwingConstants.CENTER);
    private final JButton insertEnvelopeButton = new JButton("Insert Envelope");
    private double pendingDeposit;

    public Ex12_18_ATMGui() {
        super("ATM");

        // Seed one demo account
        pins.put("12345", "1111");
        balances.put("12345", 1000.00);

        screens.setLayout(cardLayout);
        screens.add(buildLoginScreen(), "login");
        screens.add(buildMainMenuScreen(), "menu");
        screens.add(buildBalanceScreen(), "balance");
        screens.add(buildWithdrawScreen(), "withdraw");
        screens.add(buildDepositScreen(), "deposit");

        add(screens);

        setSize(420, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private JPanel buildLoginScreen() {
        JPanel panel = new JPanel(new GridLayout(4, 1, 5, 5));
        panel.add(new JLabel("Welcome! Enter account number and PIN.", SwingConstants.CENTER));

        JPanel accountRow = new JPanel();
        accountRow.add(new JLabel("Account #:"));
        accountRow.add(accountField);
        panel.add(accountRow);

        JPanel pinRow = new JPanel();
        pinRow.add(new JLabel("PIN:"));
        pinRow.add(pinField);
        panel.add(pinRow);

        JPanel bottomRow = new JPanel();
        JButton loginButton = new JButton("Login");
        loginButton.addActionListener((ActionEvent e) -> attemptLogin());
        bottomRow.add(loginButton);
        bottomRow.add(loginMessage);
        panel.add(bottomRow);

        // Demo hint
        loginMessage.setText("(Demo account: 12345 / PIN 1111)");

        return panel;
    }

    private void attemptLogin() {
        String account = accountField.getText().trim();
        String pin = new String(pinField.getPassword());

        if (pins.containsKey(account) && pins.get(account).equals(pin)) {
            currentAccount = account;
            welcomeLabel.setText("<html>Welcome!<br>Please choose a transaction.</html>");
            cardLayout.show(screens, "menu");
        } else {
            loginMessage.setText("Invalid account number or PIN.");
        }
    }

    private JPanel buildMainMenuScreen() {
        JPanel panel = new JPanel(new BorderLayout(5, 5));
        panel.add(welcomeLabel, BorderLayout.NORTH);

        JPanel buttons = new JPanel(new GridLayout(4, 1, 5, 5));

        JButton viewBalanceButton = new JButton("View Balance");
        viewBalanceButton.addActionListener((ActionEvent e) -> {
            balanceLabel.setText(String.format("Your balance is: $%.2f", balances.get(currentAccount)));
            cardLayout.show(screens, "balance");
        });
        buttons.add(viewBalanceButton);

        JButton withdrawButton = new JButton("Withdraw Cash");
        withdrawButton.addActionListener((ActionEvent e) -> {
            withdrawMessage.setText(" ");
            removeCashButton.setEnabled(false);
            cashReady = false;
            cardLayout.show(screens, "withdraw");
        });
        buttons.add(withdrawButton);

        JButton depositButton = new JButton("Deposit Funds");
        depositButton.addActionListener((ActionEvent e) -> {
            depositField.setText("");
            depositMessage.setText(" ");
            insertEnvelopeButton.setEnabled(false);
            cardLayout.show(screens, "deposit");
        });
        buttons.add(depositButton);

        JButton logoutButton = new JButton("Logout");
        logoutButton.addActionListener((ActionEvent e) -> {
            currentAccount = null;
            accountField.setText("");
            pinField.setText("");
            cardLayout.show(screens, "login");
        });
        buttons.add(logoutButton);

        panel.add(buttons, BorderLayout.CENTER);
        return panel;
    }

    private JPanel buildBalanceScreen() {
        JPanel panel = new JPanel(new BorderLayout(5, 5));
        panel.add(balanceLabel, BorderLayout.CENTER);

        JButton backButton = new JButton("Back to Menu");
        backButton.addActionListener((ActionEvent e) -> cardLayout.show(screens, "menu"));
        panel.add(backButton, BorderLayout.SOUTH);

        return panel;
    }

    private JPanel buildWithdrawScreen() {
        JPanel panel = new JPanel(new BorderLayout(5, 5));

        JPanel topRow = new JPanel();
        topRow.add(new JLabel("Select amount:"));
        topRow.add(withdrawAmountCombo);
        JButton confirmButton = new JButton("Withdraw");
        confirmButton.addActionListener((ActionEvent e) -> {
            String selected = (String) withdrawAmountCombo.getSelectedItem();
            pendingWithdrawal = Double.parseDouble(selected.replace("$", ""));
            double balance = balances.get(currentAccount);

            if (pendingWithdrawal > balance) {
                withdrawMessage.setText("Insufficient funds.");
                removeCashButton.setEnabled(false);
            } else {
                balances.put(currentAccount, balance - pendingWithdrawal);
                withdrawMessage.setText("Please take your cash.");
                removeCashButton.setEnabled(true);
                cashReady = true;
            }
        });
        topRow.add(confirmButton);
        panel.add(topRow, BorderLayout.NORTH);

        panel.add(withdrawMessage, BorderLayout.CENTER);

        JPanel bottomRow = new JPanel();
        removeCashButton.setEnabled(false);
        removeCashButton.addActionListener((ActionEvent e) -> {
            if (cashReady) {
                withdrawMessage.setText("Cash removed. Thank you!");
                removeCashButton.setEnabled(false);
                cashReady = false;
            }
        });
        bottomRow.add(removeCashButton);

        JButton backButton = new JButton("Back to Menu");
        backButton.addActionListener((ActionEvent e) -> cardLayout.show(screens, "menu"));
        bottomRow.add(backButton);

        panel.add(bottomRow, BorderLayout.SOUTH);
        return panel;
    }

    private JPanel buildDepositScreen() {
        JPanel panel = new JPanel(new BorderLayout(5, 5));

        JPanel topRow = new JPanel();
        topRow.add(new JLabel("Enter amount:"));
        topRow.add(depositField);
        JButton confirmButton = new JButton("Deposit");
        confirmButton.addActionListener((ActionEvent e) -> {
            try {
                pendingDeposit = Double.parseDouble(depositField.getText().trim());
                depositMessage.setText("Please insert your envelope.");
                insertEnvelopeButton.setEnabled(true);
            } catch (NumberFormatException ex) {
                depositMessage.setText("Please enter a valid amount.");
                insertEnvelopeButton.setEnabled(false);
            }
        });
        topRow.add(confirmButton);
        panel.add(topRow, BorderLayout.NORTH);

        panel.add(depositMessage, BorderLayout.CENTER);

        JPanel bottomRow = new JPanel();
        insertEnvelopeButton.setEnabled(false);
        insertEnvelopeButton.addActionListener((ActionEvent e) -> {
            double balance = balances.get(currentAccount);
            balances.put(currentAccount, balance + pendingDeposit);
            depositMessage.setText("Envelope received. Funds will be credited.");
            insertEnvelopeButton.setEnabled(false);
        });
        bottomRow.add(insertEnvelopeButton);

        JButton backButton = new JButton("Back to Menu");
        backButton.addActionListener((ActionEvent e) -> cardLayout.show(screens, "menu"));
        bottomRow.add(backButton);

        panel.add(bottomRow, BorderLayout.SOUTH);
        return panel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Ex12_18_ATMGui().setVisible(true));
    }
}
