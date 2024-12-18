import java.io.*;
import java.util.*;

class Account implements Serializable {
    private String name;
    private int accountNumber;
    private int age;
    private double balance;

    public Account(String name, int accountNumber, int age, double initialBalance) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.age = age;
        this.balance = initialBalance;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Amount deposited successfully!");
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && balance - amount >= 1000) {
            balance -= amount;
            System.out.println("Amount withdrawn successfully!");
        } else {
            System.out.println("Invalid or insufficient balance for withdrawal.");
        }
    }

    @Override
    public String toString() {
        return "Account Number: " + accountNumber + ", Name: " + name + ", Age: " + age + ", Balance: ₹" + balance;
    }
}

class Bank {
    private Map<Integer, Account> accounts = new HashMap<>();
    private final String fileName = "accounts.dat";

    public Bank() {
        loadAccounts();
    }

    public void createAccount(String name, int accountNumber, int age, double initialBalance) {
        if (!accounts.containsKey(accountNumber)) {
            Account account = new Account(name, accountNumber, age, initialBalance);
            accounts.put(accountNumber, account);
            saveAccounts();
            System.out.println("Account created successfully!");
        } else {
            System.out.println("Account number already exists.");
        }
    }

    public void deposit(int accountNumber, double amount) {
        Account account = accounts.get(accountNumber);
        if (account != null) {
            account.deposit(amount);
            saveAccounts();
        } else {
            System.out.println("Account not found.");
        }
    }

    public void withdraw(int accountNumber, double amount) {
        Account account = accounts.get(accountNumber);
        if (account != null) {
            account.withdraw(amount);
            saveAccounts();
        } else {
            System.out.println("Account not found.");
        }
    }

    public void balanceInquiry(int accountNumber) {
        Account account = accounts.get(accountNumber);
        if (account != null) {
            System.out.println("Current Balance: ₹" + account.getBalance());
        } else {
            System.out.println("Account not found.");
        }
    }

    public void updateAccount(int accountNumber, String name, int age) {
        Account account = accounts.get(accountNumber);
        if (account != null) {
            account.setName(name);
            account.setAge(age);
            saveAccounts();
            System.out.println("Account updated successfully!");
        } else {
            System.out.println("Account not found.");
        }
    }

    public void deleteAccount(int accountNumber) {
        if (accounts.containsKey(accountNumber)) {
            accounts.remove(accountNumber);
            saveAccounts();
            System.out.println("Account deleted successfully!");
        } else {
            System.out.println("Account not found.");
        }
    }

    public void generateMiniStatement(int accountNumber) {
        Account account = accounts.get(accountNumber);
        if (account != null) {
            System.out.println(account);
        } else {
            System.out.println("Account not found.");
        }
    }

    private void saveAccounts() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(accounts);
        } catch (IOException e) {
            System.out.println("Error saving accounts: " + e.getMessage());
        }
    }

    private void loadAccounts() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            accounts = (Map<Integer, Account>) ois.readObject();
        } catch (FileNotFoundException e) {
            // No accounts file yet; start fresh.
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading accounts: " + e.getMessage());
        }
    }
}

public class BankManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Bank bank = new Bank();

        while (true) {
            System.out.println("\nBank Management System");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Balance Inquiry");
            System.out.println("5. Update Account");
            System.out.println("6. Delete Account");
            System.out.println("7. Generate Mini Statement");
            System.out.println("8. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter Name: ");
                    String name = scanner.next();
                    System.out.print("Enter Account Number: ");
                    int accountNumber = scanner.nextInt();
                    System.out.print("Enter Age: ");
                    int age = scanner.nextInt();
                    System.out.print("Enter Initial Balance: ");
                    double initialBalance = scanner.nextDouble();
                    bank.createAccount(name, accountNumber, age, initialBalance);
                    break;
                case 2:
                    System.out.print("Enter Account Number: ");
                    accountNumber = scanner.nextInt();
                    System.out.print("Enter Amount to Deposit: ");
                    double depositAmount = scanner.nextDouble();
                    bank.deposit(accountNumber, depositAmount);
                    break;
                case 3:
                    System.out.print("Enter Account Number: ");
                    accountNumber = scanner.nextInt();
                    System.out.print("Enter Amount to Withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    bank.withdraw(accountNumber, withdrawAmount);
                    break;
                case 4:
                    System.out.print("Enter Account Number: ");
                    accountNumber = scanner.nextInt();
                    bank.balanceInquiry(accountNumber);
                    break;
                case 5:
                    System.out.print("Enter Account Number: ");
                    accountNumber = scanner.nextInt();
                    System.out.print("Enter New Name: ");
                    name = scanner.next();
                    System.out.print("Enter New Age: ");
                    age = scanner.nextInt();
                    bank.updateAccount(accountNumber, name, age);
                    break;
                case 6:
                    System.out.print("Enter Account Number: ");
                    accountNumber = scanner.nextInt();
                    bank.deleteAccount(accountNumber);
                    break;
                case 7:
                    System.out.print("Enter Account Number: ");
                    accountNumber = scanner.nextInt();
                    bank.generateMiniStatement(accountNumber);
                    break;
                case 8:
                    System.out.println("Exiting system. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
