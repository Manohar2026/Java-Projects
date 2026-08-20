package OOP_Projects.BankAccountSystem;

public class Account {
    private long accountNumber;
    private int balance;

    public Account(long accountNumber, int balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public long getbalance() {
        return balance;
    }

    public void deposit(int amount) {
        if(amount > 0) {
            balance += amount;
            System.out.println("Deposited " + amount + " successfully");
        }
    }

    public void withdraw(int amount) {
        if(amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal " + amount + " successful");
        }
    }
}
