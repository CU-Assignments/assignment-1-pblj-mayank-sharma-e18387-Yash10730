import java.util.Scanner;

class BankAccount {
    private String name;
    private int accountNumber;
    private double balance;

    public BankAccount(String name, int accountNumber, double initialBalance) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposit successful! Current Balance: " + balance);
    }

    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Error: Insufficient funds. Current Balance: " + balance);
        } else {
            balance -= amount;
            System.out.println("Withdrawal successful! Current Balance: " + balance);
        }
    }

    public void displayAccount() {
        System.out.println("Name: " + name);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: " + balance);
    }
}

public class BankingSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Create Account:");
        System.out.print("Name: ");
        String name = sc.nextLine();

        System.out.print("Account Number: ");
        int accNo = sc.nextInt();

        System.out.print("Initial Balance: ");
        double balance = sc.nextDouble();

        BankAccount account = new BankAccount(name, accNo, balance);

        while (true) {
            System.out.println("\n1. Deposit\n2. Withdraw\n3. Display Account\n4. Exit");
            System.out.print("Choose option: ");
            int option = sc.nextInt();

            switch (option) {
                case 1:
                    System.out.print("Enter deposit amount: ");
                    double dep = sc.nextDouble();
                    account.deposit(dep);
                    break;
                case 2:
                    System.out.print("Enter withdrawal amount: ");
                    double with = sc.nextDouble();
                    account.withdraw(with);
                    break;
                case 3:
                    account.displayAccount();
                    break;
                case 4:
                    System.out.println("Exiting... Thank you!");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
}
