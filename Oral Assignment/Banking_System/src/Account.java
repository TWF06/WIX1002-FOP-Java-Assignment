public abstract class Account {
    protected String accountNumber;
    protected String ownerName;
    protected double balance;
    private String password;//Encapsulation
    
    //Constructor
    public Account(String accountNumber, String ownerName, double balance, String password) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = balance;
        this.password = password;
    }
    
    //Methods (abstract methods are to be overriden in subclasses)
    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid deposit.");
            return;
        }
        balance += amount;
        System.out.println("Deposited $" + amount);
    }

    public abstract boolean withdraw(double amount);

    public abstract double calculateInterest();

    public void applyMonthlyInterest() {
        double monthly = calculateInterest() / 12.0;
        balance += monthly;
        System.out.printf("Monthly interest applied: $%2f\n" , monthly);
    }

    public boolean validatePassword(String pass) {
        return password.equals(pass);
    }

    public double getBalance() {
        return balance;
    }

    public String getPassword() {
        return password;
    }
    
    public void displayInfo() {
        System.out.println("\n--- Account Information ---");
        System.out.println("Account Number : " + accountNumber);
        System.out.println("Owner Name     : " + ownerName);
        System.out.println("Balance        : $" + balance);
        System.out.println("Account Type   : General");
    }

}
