
package bank;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
 import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;
import java.io.*;


public class Bank {
    ArrayList<Account> accounts = new ArrayList<>();

    public void addNewRecord(String name, double initialAmount) {
        Random random = new Random();
        int accountNumber = 10000000 + random.nextInt(90000000);
        int pin = 1000 + random.nextInt(9000);

        Account account = new Account(name, accountNumber, pin, initialAmount);
        accounts.add(account);
        JOptionPane.showMessageDialog(null, "Account created successfully.\nAccount Number: " + accountNumber + "\nPIN: " + pin);
    }

    public void deposit(int pin, double amount) {
        Account account = findAccount(pin);
        if (account != null) {
            account.setAmount(account.getAmount() + amount);
            JOptionPane.showMessageDialog(null, "Deposit of " + amount + " successful!");
        } else {
            JOptionPane.showMessageDialog(null, "Account not found!");
        }
    }

    public void withdraw(int pin, double amount) {
        Account account = findAccount(pin);
        if (account != null) {
            if (amount <= account.getAmount()) {
                account.setAmount(account.getAmount() - amount);
                JOptionPane.showMessageDialog(null, "Withdrawal of " + amount + " successful!");
            } else {
                JOptionPane.showMessageDialog(null, "Insufficient balance!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Account not found!");
        }
    }

    public void transfer(int senderPin, int receiverPin, double amount) {
        Account sender = findAccount(senderPin);
        if (sender != null) {
            Account receiver = findAccount(receiverPin);
            if (receiver != null) {
                if (amount <= sender.getAmount()) {
                    sender.setAmount(sender.getAmount() - amount);
                    receiver.setAmount(receiver.getAmount() + amount);
                    JOptionPane.showMessageDialog(null, "Transfer of " + amount + " successful!");
                } else {
                    JOptionPane.showMessageDialog(null, "Insufficient balance!");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Recipient's account not found!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Sender's account not found!");
        }
    }

    public void deleteAccount(int pin) {
        Account account = findAccount(pin);
        if (account != null) {
            accounts.remove(account);
            JOptionPane.showMessageDialog(null, "Account deleted successfully.");
        } else {
            JOptionPane.showMessageDialog(null, "Account not found!");
        }
    }

    public void searchAccount(int pin) {
        Account account = findAccount(pin);
        if (account != null) {
            JOptionPane.showMessageDialog(null, "Account found:\nName: " + account.getName() + "\nAccount Number: " + account.getAccountNumber() + "\nBalance: " + account.getAmount() + "\nPIN: " + account.getPIN());
        } else {
            JOptionPane.showMessageDialog(null, "Account not found!");
        }
    }

    public void print() {
        if (accounts.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No accounts found!");
        } else {
            StringBuilder accountsInfo = new StringBuilder();
            for (Account account : accounts) {
                accountsInfo.append("\nName: ").append(account.getName());
                accountsInfo.append("\nAccount Number: ").append(account.getAccountNumber());
                accountsInfo.append("\nBalance: ").append(account.getAmount());
                accountsInfo.append("\nPIN: ").append(account.getPIN()).append("\n");
            }
            JOptionPane.showMessageDialog(null, accountsInfo.toString());
        }
    }
public void save() {
        try {
            FileOutputStream fos = new FileOutputStream("BankRecord.ser");
            ObjectOutputStream out = new ObjectOutputStream(fos);
            out.writeObject(accounts);
            out.close();
            fos.close();
            JOptionPane.showMessageDialog(null, "Accounts saved successfully.");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error saving accounts: " + e.getMessage());
        }
    }
    public void load() {
        try {
            FileInputStream fis = new FileInputStream("BankRecord.ser");
            ObjectInputStream in = new ObjectInputStream(fis);
            accounts = (ArrayList<Account>) in.readObject();
            in.close();
            fis.close();
            JOptionPane.showMessageDialog(null, "Accounts loaded successfully.");
        } catch (IOException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Error loading accounts: " + e.getMessage());
        }
    }

    private Account findAccount(int pin) {
        for (Account account : accounts) {
            if (account.getPIN() == pin) {
                return account;
            }
        }
        return null;
    }
}
   
    
