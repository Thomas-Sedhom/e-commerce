package Customer;

public class Customer {
    private final String name;
    private Double balance;

    public Customer(String name, Double balance){
        this.name = name;
        this.balance = balance;
    }

    public String  getName(){
        return this.name;
    }

    public void decreaseBalance(Double money){
        this.balance -= money;
    }

    public void deposit(int money){
        this.balance += money;
    }

    public Double getBalance(){
        return this.balance;
    }
}
