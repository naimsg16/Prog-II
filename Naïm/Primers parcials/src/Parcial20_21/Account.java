package Parcial20_21;

public class Account {

    private int balance;
    private String id;

    public Account(String idAccount, int initialBalance){
        this.id = idAccount;
        this.balance = initialBalance;
    }

    public String getId(){
        if(this.id == null){
            return null;
        }
        return this.id;
    }

    public int getBalance(){
        return this.balance;
    }

    public void deposit(int amount){
        this.balance += amount;
    }

    public boolean withdrawal(int amount){
        if(amount > this.balance){
            return false;
        }
        this.balance -= amount;
        return true;
    }
}
