public class SavingsAccount extends Account {
    private double interestRate;
    private double minBalance;
    private double interest;

    //Constructor
    public SavingsAccount(String accNo, String name, double bal, String pass,
                          double rate, double minBalance) {
        super(accNo, name, bal, pass);
        this.interestRate = rate;
        this.minBalance = minBalance;
    }
    
    //Methods 
    @Override
    public double calculateInterest() {
        interest =  interestRate * balance; // annual interest earned
        return interest;
    }

    @Override
    public boolean withdraw(double amount) {
        if (amount <= 0) return false;

        if (balance - amount >= minBalance) {
            balance -= amount;//balance inherited from parent class
            System.out.println("Withdrawal successful.");
            return true;
        }
        System.out.println("Minimum balance violation.");
        return false;
    }
    
    @Override
    public void displayInfo() {
        System.out.println("\n--- Savings Account Information ---");
        System.out.println("Account Number : " + accountNumber);
        System.out.println("Owner Name     : " + ownerName);
        System.out.println("Balance        : $" + balance);
        System.out.println("Interest Rate  : " + (interestRate * 100) + "%");
        System.out.println("Min Balance    : $" + minBalance);
    }


    public double getInterestRate() {
        return interestRate;
    }

    public double getMinBalance() {
        return minBalance;
    }
}
