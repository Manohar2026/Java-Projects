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
}
