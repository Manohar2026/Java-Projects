package OOP_Projects.BankAccountSystem;

public class BankAccountSystem {
    public static void main(String[] args) {
        Account account = new Account(1234567, 0);

        Customer customer = new Customer("Ajay", account);

        Bank bank = new Bank(customer);

        bank.viewBalance();
        bank.deposit(2000);
        bank.viewBalance();
        bank.withdraw(1000);
        bank.viewBalance();
    }
}
