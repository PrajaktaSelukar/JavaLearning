package OOPS;

public class Encapsulation {
    static class BankAccount {
        private String accountHolder;
        private double balance;
        private int pin;

        public BankAccount(String accountHolder, int pin) {
            this.accountHolder = accountHolder;
            this.balance = 0.0;
            this.pin = pin;
        }
        public void deposit(double amount) {
            if(amount <= 0) {
                System.out.println("Invalid amount");
                return;
            }
            this.balance += amount;
            System.out.println("Deposited " + amount);
        }
        public void withdraw(double amount, int pin) {
            if(amount <= 0) {
                System.out.println("Invalid amount");
                return;
            }
            if(this.pin == pin) {
                if (amount > this.balance) {
                    System.out.println("Insufficient funds");
                } else {
                    this.balance -= amount;
                    System.out.println("Withdrawn "+amount+". Remaining balance: "+this.balance);
                }
            } else {
                System.out.println("Wrong PIN");
            }
        }
        public double getBalance(int pin) {
            if(pin == this.pin) return this.balance;
            else {
                System.out.println("Wrong PIN");
                return -1;
            }
        }
        public String getAccountHolder() {
            return accountHolder;
        }
    }
    public static void main(String[] args) {
        // Problem 2 — Encapsulation
        BankAccount acc = new BankAccount("Prajakta", 1234);
        acc.deposit(5000);
        acc.withdraw(2000, 1234);
        acc.withdraw(500, 9999);
        acc.withdraw(99999, 1234);
        System.out.println("Balance: " + acc.getBalance(1234));
    }
}
