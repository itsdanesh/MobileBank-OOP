package pages;
import bussinessLogic.Account;
import bussinessLogic.Transaction;
import static pages.AccountPage.*;
import static pages.HomePage.*;
import static pages.Input.*;

public class DepositWithdraw {
    public static void deposit() {
        long an = Input.readLong("Enter an account number: ");
        Input.userInput.nextLine();
        int password = Input.readInt("Enter your password: ");
        Input.userInput.nextLine();

        if(verifyLogin(an,password)==false) {
            System.out.println("Invalid account number or password. Try again: "+EOL);deposit();

        }else if(verifyLogin(an, password)==true){
            Account desireAccount=findAccount(an,accounts);
            System.out.println(desireAccount.toString()+EOL);
            double depositAmount=Input.readDouble("Enter the amount to deposit: ");
            Input.userInput.nextLine();
            double newBalance=(desireAccount.getBalance()+depositAmount);
            desireAccount.setBalance(newBalance);
            String date=Input.readString("Enter the date: ");
            userInput.nextLine();
            System.out.println("Deposit amount : "+ depositAmount+ " SEK."+EOL+desireAccount.toString()+EOL);

            transactions.add(new Transaction(an, depositAmount,"Deposit amount: ",date));
        }}

    public static void withdraw(){
        long an = Input.readLong("Enter account number: ");
        Input.userInput.nextLine();
        int password = Input.readInt("Enter password: ");
        Input.userInput.nextLine();

        if (verifyLogin(an, password) == false) {
            System.out.println("Invalid account number or password. Try again: " + EOL);withdraw();

        } else if (verifyLogin(an, password) == true) {
            Account desiredAccount = findAccount(an, accounts);
            System.out.println("Your account: " + EOL + desiredAccount.toString() + EOL);
            double withdrawAmount = Input.readDouble("Enter the amount you want to withdraw: ");
            Input.userInput.nextLine();
            double amount=(withdrawAmount-(withdrawAmount*2));

            if (withdrawAmount > desiredAccount.getBalance()) {
                System.out.println("Your balance is not enough for this amount.Try again!" + EOL);withdraw();

            } else if (withdrawAmount <= desiredAccount.getBalance()) {
                double newBalance = (desiredAccount.getBalance() - withdrawAmount);
                desiredAccount.setBalance(newBalance);
                String date=Input.readString("Enter the date: ");
                userInput.nextLine();
                System.out.println("Amount: "+df.format(withdrawAmount)+ " SEK is withdrawn."+EOL);
                System.out.println(desiredAccount+ EOL);
                transactions.add(new Transaction(an, amount, "Withdraw amount: ",date));
            }}}

    public static void viewTransactions(){
        long an=Input.readLong("Enter account number:");
        Input.userInput.nextLine();

        if(transactions.isEmpty()){
            System.out.println("No transaction registered yet.");

        }else if(transactions.size()>0){
            System.out.println("Transactions: "+EOL+"Account number: "+an+EOL);

            for(Transaction desiredOne: transactions){
                if(desiredOne.getAn()==an){
                    System.out.println(desiredOne);
                }

            }}
    }


    public static void checkTheBalance(){
        long an=Input.readLong("Enter account number:");
        Input.userInput.nextLine();
        int password=Input.readInt("Enter password:");
        Input.userInput.nextLine();

        if(containsAccount(an,accounts)==true&&verifyLogin(an,password)==true){
            System.out.println(findAccount(an,accounts).toString());

        }else if(!containsAccount(an,accounts)||verifyLogin(an,password)==false){
            System.out.println("Invalid account number or password: "+EOL);
        }
    }}


