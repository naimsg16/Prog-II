

public class Account{
    private String idAccount;
    private int balance;
    public Account(String idAccount, int initialBalance){ //CONSTRUCTOR
        this.idAccount = idAccount;
        this.balance = initialBalance;
    }
    public String getId(){
       return this.idAccount;
    }
    public int getBalance(){
        return this.balance;
    }
    //DEPOSITA LA CANTIDAD DADA EN LA CUENTA
    public void deposit(int amount){
         this.balance += amount;
    }
    public boolean withdrawal(int amount){
       if(this.balance < amount) {
           return false;
       } //si lo hay, retira la cantidad dada de la cuenta y devuelve cierto
           this.balance = this.balance - amount;
           return true;

    }

}