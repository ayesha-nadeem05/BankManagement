/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank;
import java.io.*;

class Account implements Serializable {
    String name;
    int accountNumber;
    int pin;
    double amount;

    Account() {
        name = null;
        accountNumber = 0;
        pin = 0;
        amount = 0;
    }

    Account(String name, int acc, int pin, double amount) {
        this.name = name;
        this.accountNumber = acc;
        this.pin = pin;
        this.amount = 1000 + amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getPIN() {
        return pin;
    }

    public void setPIN(int pin) {
        this.pin = pin;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}

    

