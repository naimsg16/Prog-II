package Parcial20_21;

public class AccountsDB {

    private Account[] database;
    private int increment;

    public AccountsDB(int initialSize, int sizeIncrement){
        this.database = new Account[initialSize];
        this.increment = sizeIncrement;
    }
    public Account getAccount(String id){
        for(int i = 0; i < this.database.length; i++){
            if (id.equals(this.database[i].getId())){
                return this.database[i];
            }
        }
        return null;
    }
    public boolean addAccount(String id, int initialBalance){
        if(canAdd(id,initialBalance)){
            this.database[emptySpace()] = new Account(id,initialBalance);
            return true;
        }
        return false;
    }

    public boolean transfer(String idFrom, String idTo, int amount){
        if(canTransfer(idFrom,idTo,amount)){
            getAccount(idFrom).withdrawal(amount);
            getAccount(idTo).deposit(amount);
            return true;
        }
        return false;
    }


    private boolean canAdd(String id, int initialBalance){
        return initialBalance >= 0 && id != null && !existingAccount(id);
    }

    private boolean existingAccount(String id){
        for (int i = 0; i < this.database.length; i++){
            if(this.database[i] != null && id.equals(this.database[i].getId())){
                return true;
            }
        }
        return false;
    }

    private int emptySpace() {
        for (int i = 0; i < this.database.length; i++) {
            if (database[i] == null){
                return i;
            }
        }
        widenDatabase();
        return this.database.length - increment;

    }

    private void widenDatabase(){
        Account[] widened = new Account[this.database.length + this.increment];
        for(int i = 0; i < this.database.length; i++){
            widened[i] = this.database[i];
        }
        this.database = widened;
    }

    private boolean canTransfer(String idFrom, String idTo, int amount){
        return  idFrom != null && idTo != null &&
                existingAccount(idFrom) &&
                existingAccount(idTo) &&
                amount >= 0 &&
                amount < this.getAccount(idFrom).getBalance();

    }
}
