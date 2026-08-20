package OOP_Projects.BankAccountSystem;

public class Bank {
    private Customer customer;

    public Bank(Customer customer) {
        this.customer = customer;
    }

    public void deposit(int amount) {
        customer.deposit(amount);
    }

    public void withdraw(int amount) {
        customer.withdraw(amount);
    }

    public void viewBalance() {
        customer.viewBalance();
    }
}
