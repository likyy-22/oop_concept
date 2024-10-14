import java.util.Scanner;

class BankAccount {
    private String accountHolderName;
    private String accountNumber;
    protected int balance;

    // Constructor
    public BankAccount(String accountHolderName, String accountNumber, int initialBalance) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    // Deposit method
    public void deposit(int amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Withdraw method
    public void withdraw(int amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew: " + amount);
        } else {
            System.out.println("Insufficient funds or invalid withdrawal amount.");
        }
    }

    // Get balance method
    public int getBalance() {
        return balance;
    }

    // Display account details
    public void displayAccountInfo() {
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: " + balance);
    }
}

class SavingsAccount extends BankAccount {
    // Constructor
    public SavingsAccount(String accountHolderName, String accountNumber, int initialBalance) {
        super(accountHolderName, accountNumber, initialBalance);
    }
}

class CheckingAccount extends BankAccount {
    // Constructor
    public CheckingAccount(String accountHolderName, String accountNumber, int initialBalance) {
        super(accountHolderName, accountNumber, initialBalance);
    }
}

public class Banking {
    public static void main(String[] args) {
        Scanner s1 = new Scanner(System.in);

        // Get details for Savings Account
        System.out.println("Enter details for Savings Account:");
        System.out.print("Account Holder Name: ");
        String savingsHolderName = s1.nextLine();
        System.out.print("Account Number: ");
        String savingsAccountNumber = s1.nextLine();
        SavingsAccount sa1 = new SavingsAccount(savingsHolderName, savingsAccountNumber, 1000);

        // Get details for Checking Account
        System.out.println("Enter details for Checking Account:");
        System.out.print("Account Holder Name: ");
        String checkingHolderName = s1.nextLine();
        System.out.print("Account Number: ");
        String checkingAccountNumber = s1.nextLine();
        CheckingAccount ca1 = new CheckingAccount(checkingHolderName, checkingAccountNumber, 500);

        // Main menu loop
        while (true) {
            System.out.println("\nBank System Menu:");
            System.out.println("1. Deposit to Savings Account");
            System.out.println("2. Withdraw from Savings Account");
            System.out.println("3. Display Savings Account Info");
            System.out.println("4. Deposit to Checking Account");
            System.out.println("5. Withdraw from Checking Account");
            System.out.println("6. Display Checking Account Info");
            System.out.println("7. Exit");

            int choice = s1.nextInt();
            s1.nextLine();  // Consume newline left-over from nextInt()

            switch (choice) {
                case 1:
                    System.out.print("Enter deposit amount for Savings Account: ");
                    int depositAmountSA = s1.nextInt();
                    sa1.deposit(depositAmountSA);
                    break;
                case 2:
                    System.out.print("Enter withdrawal amount for Savings Account: ");
                    int withdrawAmountSA = s1.nextInt();
                    sa1.withdraw(withdrawAmountSA);
                    break;
                case 3:
                    sa1.displayAccountInfo();
                    break;
                case 4:
                    System.out.print("Enter deposit amount for Checking Account: ");
                    int depositAmountCA = s1.nextInt();
                    ca1.deposit(depositAmountCA);
                    break;
                case 5:
                    System.out.print("Enter withdrawal amount for Checking Account: ");
                    int withdrawAmountCA = s1.nextInt();
                    ca1.withdraw(withdrawAmountCA);
                    break;
                case 6:
                    ca1.displayAccountInfo();
                    break;
                case 7:
                    System.out.println("Exiting...");
                    s1.close();
                    return;  // Exit the while loop and end the program
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 7.");
            }
        }
    }
}
