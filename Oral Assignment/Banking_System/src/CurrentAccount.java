public class CurrentAccount extends Account {
    private double overdraftLimit;
    private final double overdraftInterestRate = 0.10;
    private double overAmount;
    
    //Constructor
    public CurrentAccount(String accNo, String name, double bal, String pass,
                          double overdraftLimit) {
        super(accNo, name, bal, pass);
        this.overdraftLimit = overdraftLimit;
    }
    
    //Methods
    @Override
    public double calculateInterest() {
        if (balance < 0) {
            overAmount=  - (overdraftInterestRate * Math.abs(balance));
            return overAmount;
        }
        return 0;
    }

    @Override
    public boolean withdraw(double amount) {
        if (amount <= 0) return false;

        if (balance - amount >= -overdraftLimit) {
            balance -= amount;
            System.out.println("Withdrawal successful.");
            return true;
        }
        System.out.println("Overdraft limit exceeded.");
        return false;
    }
    
    @Override
    public void displayInfo() {
        System.out.println("\n--- Current Account Information ---");
        System.out.println("Account Number : " + accountNumber);
        System.out.println("Owner Name     : " + ownerName);
        System.out.println("Balance        : $" + balance);
        System.out.println("Overdraft Limit: $" + overdraftLimit);
    }


    public double getOverdraftLimit() {
        return overdraftLimit;
    }
}
