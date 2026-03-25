package Q5;
import java.util.ArrayList;
public class Customer {
    private String name, customerId;
    private ArrayList<BankAccount> accounts=new ArrayList<>();
    
    public Customer(String name, String customerId){
        this.name=name;
        this.customerId = customerId;
        System.out.println("Creating a new customer: "+name+" (ID: "+customerId+")");
    }
    
    public void addAccount(BankAccount account){
        accounts.add(account);
    }
    
    public BankAccount getAccount(String accountNumber){
        for(BankAccount ba :accounts){
            if(ba!=null && ba.getAccountNumber().equalsIgnoreCase(accountNumber)){
                return ba;
            }
        }
        return null;
    }
    
    public String getName(){
        return name;
    }
    
    public String getCustomerId(){
        return customerId;
    }
    
    public void displayAccounts(){
        System.out.println("Displaying all accounts for customer "+name+":");
        for(BankAccount ba: accounts){
            System.out.println("Account Number: "+ba.getAccountNumber() + ", Balance: "+ba.getBalance());
        }
    }
}
