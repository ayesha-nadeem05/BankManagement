import bank.Bank;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;




    public class Main{
 public static void main(String[] args) {
        Bank bank = new Bank ();
        JFrame frame = new JFrame("Bank Management System");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JButton addNewRecordBtn = new JButton("Add New Account");
        addNewRecordBtn.setBounds(50, 50, 200, 30);
        addNewRecordBtn.addActionListener(e -> {
            String name = JOptionPane.showInputDialog("Enter name of Account Holder:").toUpperCase();
            double initialAmount = Double.parseDouble(JOptionPane.showInputDialog("Enter the initial amount to be deposited:"));
            bank.addNewRecord(name, initialAmount);
        });
        frame.add(addNewRecordBtn);

        JButton depositBtn = new JButton("Deposit");
        depositBtn.setBounds(50, 100, 200, 30);
        depositBtn.addActionListener(e -> {
            int pin = Integer.parseInt(JOptionPane.showInputDialog("Enter your 4-digit PIN:"));
            double amount = Double.parseDouble(JOptionPane.showInputDialog("Enter the amount to be deposited:"));
            bank.deposit(pin, amount);
        });
        frame.add(depositBtn);

        JButton withdrawBtn = new JButton("Withdraw");
        withdrawBtn.setBounds(50, 150, 200, 30);
        withdrawBtn.addActionListener(e -> {
            int pin = Integer.parseInt(JOptionPane.showInputDialog("Enter your 4-digit PIN:"));
            double amount = Double.parseDouble(JOptionPane.showInputDialog("Enter the amount to be withdrawn:"));
            bank.withdraw(pin, amount);
        });
        frame.add(withdrawBtn);

        JButton transferBtn = new JButton("Transfer");
        transferBtn.setBounds(50, 200, 200, 30);
        transferBtn.addActionListener(e -> {
            int senderPin = Integer.parseInt(JOptionPane.showInputDialog("Enter your 4-digit PIN:"));
            int receiverPin = Integer.parseInt(JOptionPane.showInputDialog("Enter the recipient's 4-digit PIN:"));
            double amount = Double.parseDouble(JOptionPane.showInputDialog("Enter the amount to transfer:"));
            bank.transfer(senderPin, receiverPin, amount);
        });
        frame.add(transferBtn);

        JButton deleteAccountBtn = new JButton("Delete Account");
        deleteAccountBtn.setBounds(50, 250, 200, 30);
        deleteAccountBtn.addActionListener(e -> {
            int pin = Integer.parseInt(JOptionPane.showInputDialog("Enter your 4-digit PIN:"));
            bank.deleteAccount(pin);
        });
        frame.add(deleteAccountBtn);

        JButton searchAccountBtn = new JButton("Search Account");
        searchAccountBtn.setBounds(50, 300, 200, 30);
        searchAccountBtn.addActionListener(e -> {
            int pin = Integer.parseInt(JOptionPane.showInputDialog("Enter your 4-digit PIN:"));
            bank.searchAccount(pin);
        });
        frame.add(searchAccountBtn);

        JButton printAccountsBtn = new JButton("Print All Accounts");
        printAccountsBtn.setBounds(50, 350, 200, 30);
        printAccountsBtn.addActionListener(e -> bank.print());
        frame.add(printAccountsBtn);

        JButton saveAccountsBtn = new JButton("Save Accounts");
        saveAccountsBtn.setBounds(50, 400, 200, 30);
        saveAccountsBtn.addActionListener(e -> bank.save());
        frame.add(saveAccountsBtn);

        JButton loadAccountsBtn = new JButton("Load Accounts");
        loadAccountsBtn.setBounds(50, 450, 200, 30);
        loadAccountsBtn.addActionListener(e -> bank.load());
        frame.add(loadAccountsBtn);

        frame.setVisible(true);
    }
}


