package OOP_Projects.BankAccountSystem;

public class Customer {
    private String name;
    private Account account;

    public Customer(String name, Account account) {
        this.name = name;
        this.account = account;
    }

    public void deposit(int amount) {
        account.deposit(amount);
    }

    public void withdraw(int amount) {
        account.withdraw(amount);
    }

    public void viewBalance() {
        System.out.println("Balance : " + account.getbalance());
    }
}
