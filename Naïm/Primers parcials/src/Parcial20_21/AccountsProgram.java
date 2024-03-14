package Parcial20_21;
import acm.program.*;

import java.util.StringTokenizer;

public class AccountsProgram extends CommandLineProgram {
    private AccountsDB accountsDB;
    private int numErrors;
    public void run() {
        initializeResults();
        String transfers = readLine("Write transfers: ");
        transfer(transfers);
        String account = readLine("Show account: ");
        println("El saldo de " + account + " es " + balance(account) + " y ha habido " + numErrors + " error/es.");
    }

    private void transfer(String transfers){
        StringTokenizer listOfTransfers = new StringTokenizer(transfers);
        while (listOfTransfers.hasMoreTokens()){
            StringTokenizer transfer = new StringTokenizer(listOfTransfers.nextToken(),"#");
            String idFrom = transfer.nextToken();
            String idTo = transfer.nextToken();
            int amount = Integer.parseInt(transfer.nextToken());
            if (!accountsDB.transfer(idFrom,idTo,amount)){
                numErrors += 1;
            }
        }
    }

    private int balance(String id){
        return accountsDB.getAccount(id).getBalance();
    }
    private void initializeResults() {
        accountsDB = loadAccounts();
        numErrors = 0;
    }

    private AccountsDB loadAccounts(){
        return new AccountsDB(3,1);
    }

    public static void main(String[] args) {
        new AccountsProgram().start(args);
    }

}
