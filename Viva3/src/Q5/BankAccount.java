package Q5;

public class BankAccount {
    private String accountNumber, accountHolderName;
    private double balance=0.0;
    
    public BankAccount(String accountNumber, String accountHolderName, double initialDepositAmount){
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = initialDepositAmount;
        System.out.println("Adding a saving account for "+accountHolderName+" with account number "+accountNumber+" and an initial deposit of $"+initialDepositAmount);
    }
    
    public void deposit(double amount){
        double newBalance = balance+amount;
        setBalance(newBalance);
        System.out.println("Depositing $"+amount+" into account "+ accountNumber+"...");
    }
    
    public boolean withdraw(double amount){
        System.out.println("Withdrawing $"+amount+ " from account "+accountNumber+"...");
        if(balance>=amount){
            double newBalance = balance-amount;
            setBalance(newBalance);
            return true;
        }
        else{
            return false;
        }
    }
    
    public String getAccountNumber(){
        return accountNumber;
    }
    
    public String getAccountHolderName(){
        return accountHolderName;
    }
    
    public double getBalance(){
        return balance;
    }
    
    private void setBalance(double balance){
        this.balance = balance;
    }
}
