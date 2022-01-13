package bussinessLogic;
import static pages.AccountPage.df;
import static pages.Input.*;

public class Account extends Customer{
    private long accountNumber;
    private int password;
    private double balance;
    public Account(String name,String LastName,long ssn,long accountNumber, int password, double balance){
        super(name,LastName, ssn);
        if(verify10Didigts(accountNumber)==false){
            System.out.println("The account number must be 10 digits.");}

        if(verify4Didigts(password)==false){
            System.out.println("The password must be 4 digits.");}
        if(balance<0) {
            System.out.println("The balance can not be negative. ");}
        this.accountNumber=accountNumber;
        this.password=password;
        this.balance=balance;

    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }


    public long getAccountNumber() {
        return accountNumber;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }


    @Override
    public String toString() {

        return getName()+"  "+getLastName()+EOL +
                "Account number: " + getAccountNumber()+EOL +
                "Balance: "+ df.format(getBalance())+" SEK."+EOL;
    }
}



