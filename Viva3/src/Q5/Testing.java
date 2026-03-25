package Q5;

public class Testing {
    public static void main(String[]args){
        Bank bank= new Bank("Simple Bank");
        
        Customer johnC = new Customer("John Doe", "C001");
        bank.addCustomer(johnC);
        
        BankAccount johnBA = new BankAccount("A1001","John Doe",500);
        johnC.addAccount(johnBA);
        
        johnBA.deposit(200);
        System.out.println("New balance: $"+ johnBA.getBalance());
        
        if(!johnBA.withdraw(100)){
            System.out.println("insufficient amount.");
        }
        System.out.println("New balance: $"+ johnBA.getBalance());
        
        johnC.displayAccounts();
        bank.displayAllCustomers();
        
        
        
        System.out.println("");
        System.out.println("");
        System.out.println("");
        
        Bank bankH= new Bank("Hard Bank");
        
        Customer samuelC = new Customer("Samuel", "C001");
        Customer calvinC = new Customer("Calvin", "C002");
        bankH.addCustomer(samuelC);
        bankH.addCustomer(calvinC);
        
        BankAccount samuelBA1 = new BankAccount("A1001","Samuel",500);
        BankAccount samuelBA2 = new BankAccount("A1002","Samuel",5000);
        BankAccount calvinBA1 = new BankAccount("A1003","Calvin",1000);
        samuelC.addAccount(samuelBA1);
        samuelC.addAccount(samuelBA2);
        calvinC.addAccount(calvinBA1);
        
        samuelBA1.deposit(200);
        System.out.println("New balance: $"+ samuelBA1.getBalance());
        samuelBA2.deposit(600);
        System.out.println("New balance: $"+ samuelBA2.getBalance());
        calvinBA1.deposit(200);
        System.out.println("New balance: $"+ calvinBA1.getBalance());
        
        if(!samuelBA1.withdraw(100)){
            System.out.println("insufficient amount.");
        }
        System.out.println("New balance: $"+ samuelBA1.getBalance());
        if(!samuelBA2.withdraw(10000)){
            System.out.println("insufficient amount.");
        }
        System.out.println("New balance: $"+ samuelBA2.getBalance());
        if(!calvinBA1.withdraw(100)){
            System.out.println("insufficient amount.");
        }
        System.out.println("New balance: $"+ calvinBA1.getBalance());
        
        samuelC.displayAccounts();
        calvinC.displayAccounts();
        bankH.displayAllCustomers();
    }
}
