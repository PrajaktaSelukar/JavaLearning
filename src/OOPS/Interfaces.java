package OOPS;

public class Interfaces {
    interface Payable {
        void pay(double amount);
        String getPaymentMethod();
    }
    interface Refundable {
        void refund(double amount);
    }
    static class CreditCard implements Payable, Refundable{
        private String cardHolder;
        private double creditLimit;
        private double spent;

        public CreditCard(String cardHolder, double creditLimit) {
            this.cardHolder = cardHolder;
            this.creditLimit = creditLimit;
            this.spent = 0.0;
        }
        @Override
        public void pay(double amount) {
            double balance = creditLimit - spent;
            if(amount <= balance) {
                this.spent += amount;
                System.out.println("Paid " + amount + ". Spent: " + spent);
            } else {
                System.out.println("Insufficient amount");
            }
        }
        public void refund(double amount) {
            this.spent -= amount;
            System.out.println("Refunded "+amount);
        }
        public String getPaymentMethod() {
            return "Credit Card";
        }
        public double getAvailableCredit() {
            return creditLimit - spent;
        }
    }
    static class UPI implements Payable {
        private String upiId;
        private double balance;

        public UPI(String upiId, double balance) {
            this.upiId = upiId;
            this.balance = balance;
        }
        // pay(double amount) → deduct from balance, reject if insufficient
        //        //getPaymentMethod() → returns "UPI"
        @Override
        public void pay(double amount) {
            if(amount <= balance) {
                this.balance -= amount;
                System.out.println("Balance has been paid "+amount);
            } else {
                System.out.println("Insufficient balance");
            }
        }
        public String getPaymentMethod() {
            return "UPI";
        }
    }
    public static void main(String[] args) {
        // Problem 4 — Interfaces
        CreditCard card = new CreditCard("Prajakta", 50000);
        UPI upi         = new UPI("prajakta@upi", 10000);

        card.pay(20000);
        card.pay(40000);   // should fail
        card.refund(5000);
        System.out.println("Available credit: " + card.getAvailableCredit());

        upi.pay(3000);
        upi.pay(8000);     // should fail
        System.out.println("Payment methods: " + card.getPaymentMethod() + ", " + upi.getPaymentMethod());

        // Polymorphism with interface — add this and explain in a comment:
        Payable p = new UPI("test@upi", 500);
        p.pay(200);
        // Balance has been paid 200
    }
}
