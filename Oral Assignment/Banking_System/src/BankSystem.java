import java.io.*;
import java.util.*;

public class BankSystem {

    private static final String DATABASE_FILE = "accounts.txt";
    private static Map<String, Account> accounts = new HashMap<>();

    public static void main(String[] args) {
        loadAccountsFromFile();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Banking System");

        // Login
        System.out.print("Enter account number: ");
        String accNum = scanner.nextLine();
        System.out.print("Enter password: ");
        String pass = scanner.nextLine();

        Account account = login(accNum, pass);
        if (account == null) {
            System.out.println("Invalid login credentials.");
            return;
        }

        System.out.println("Login successful. Welcome, " + account.ownerName);
        account.displayInfo();

        boolean running = true;
        while (running) {
            System.out.println("\nMenu:");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Apply Monthly Interest");
            System.out.println("5. Logout");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter deposit amount: ");
                    account.deposit(scanner.nextDouble());
                    break;

                case 2:
                    System.out.print("Enter withdrawal amount: ");
                    if (!account.withdraw(scanner.nextDouble())) {
                        System.out.println("Withdrawal failed.");
                    }
                    break;

                case 3:
                    System.out.printf("Current balance: $%.2f\n" , account.getBalance());
                    break;

                case 4:
                    account.applyMonthlyInterest();
                    break;

                case 5:
                    saveAccountsToFile();
                    running = false;
                    System.out.println("Logged out successfully.");
                    break;

                default:
                    System.out.println("Invalid option.");
            }
        }
        scanner.close();
    }

    private static Account login(String accNum, String pass) {
        Account acc = accounts.get(accNum);
        return (acc != null && acc.validatePassword(pass)) ? acc : null;//if true return acc, else return null
    }

    private static void loadAccountsFromFile() {
        try (BufferedReader br = new BufferedReader(new FileReader(DATABASE_FILE))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");

                if (parts.length < 6) continue;

                String accNum = parts[0];
                String name = parts[1];
                double bal = Double.parseDouble(parts[2]);
                String pass = parts[3];
                String type = parts[4];

                if (type.equals("Savings") && parts.length >= 7) {
                    double rate = Double.parseDouble(parts[5]);
                    double minBal = Double.parseDouble(parts[6]);
                    accounts.put(accNum,
                            new SavingsAccount(accNum, name, bal, pass, rate, minBal));

                } else if (type.equals("Current")) {
                    double overdraft = Double.parseDouble(parts[5]);
                    accounts.put(accNum,
                            new CurrentAccount(accNum, name, bal, pass, overdraft));
                }
            }
        } catch (IOException e) {
            System.out.println("Database not found. Starting fresh.");
        }
    }

    private static void saveAccountsToFile() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(DATABASE_FILE))) {

            for (Account acc : accounts.values()) {
                if (acc instanceof SavingsAccount sa) {
                    bw.write(sa.accountNumber + "," + sa.ownerName + "," + sa.balance + "," +
                             sa.getPassword() + ",Savings," +
                             sa.getInterestRate() + "," + sa.getMinBalance());
                } else if (acc instanceof CurrentAccount ca) {
                    bw.write(ca.accountNumber + "," + ca.ownerName + "," + ca.balance + "," +
                             ca.getPassword() + ",Current," +
                             ca.getOverdraftLimit());
                }
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving accounts.");
        }
    }
    //txt file 
    //AccountNumber,Name,Balance,Password,Type,Extra1,Extra2
    //SA - extra 1 = interest rate, extra 2 = min balance
    //CA - extra 1 = ovedraft limit, extra 2 = no use
}
