package Q5;
import java.util.ArrayList;

public class Bank {
    private String bankName;
    private ArrayList<Customer> customers= new ArrayList<>();
    
    public Bank(String bankName){
        this.bankName=bankName;
        System.out.println("Welcome to "+bankName+"!");
    }
    
    public void addCustomer(Customer customer){
        customers.add(customer);
    }
    
    public Customer getCustomer(String customerId){
        for(Customer c: customers){
            if(c!=null && c.getCustomerId().equalsIgnoreCase(customerId)){
                return c;
            }
        }
        return null;
    } 
    
    public void displayAllCustomers(){
        System.out.println("Displaying all customer of "+ bankName+":");
        for(Customer c:customers){
            if(c!=null){
                System.out.println("Customer: "+c.getName()+ ", ID: "+c.getCustomerId());
            }
        }
    }
}
