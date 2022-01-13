package pages;
import bussinessLogic.Account;
import static pages.AccountPage.*;
import static pages.HomePage.doHomePage;
import static pages.Input.EOL;

public class MortgagePage {
    static double anualInterestStudent=0.035;
    static double anualInterestHouse=0.05;
    public static void doMortgagePage(){
        System.out.println("Mortgage page: "+EOL+
                "1. Apply for student loan." +EOL+
                "2. Apply for house loan."+EOL+
                "Enter an option:");
        int option=Input.verifyOptionInput(1,2);
        Input.userInput.nextLine();
        switch (option){
            case 1:
                applyStudentLoan();
                break;

            case 2:
                applyHouseLoan();
                break;
        }}

    public static void applyStudentLoan(){
        double amount=Input.readDouble("Enter the amount you want to lend: ");
        Input.userInput.nextLine();
        int duration=Input.readInt("Enter the time period (in year):");
        Input.userInput.nextLine();
        double total=(((amount*anualInterestStudent)*duration)+amount);

        System.out.println("Total to pay back:"+total+" SEK."+EOL);
        int paymentDuration= Input.readInt("Enter the time period you want to pay (in year):");
        Input.userInput.nextLine();
        double paymentAmount=(total/(paymentDuration*12));
        System.out.println("Payment per month: "+df.format(paymentAmount)+ " SEK."+EOL);
        String answer=Input.readString("Do you want the loan? ");
        Input.userInput.nextLine();
        if(answer.equals("yes")){
            long an = Input.readLong("Please enter your account number to receive your loan: ");
            Input.userInput.nextLine();
            if(containsAccount(an,accounts)==false){
                System.out.println("Enter a valid account number: "+EOL);doMortgagePage();

            }else if(containsAccount(an,accounts)==true){
                Account myAccount=findAccount(an,accounts);
                double newBalance=(myAccount.getBalance()+amount);
                System.out.println(amount+" SEK has been sent to account: "+myAccount.getAccountNumber()+EOL);
            }


        }else if(answer.equals("no")){
            doHomePage();
        }}



    public static void applyHouseLoan(){
        double amount=Input.readDouble("Enter the amount of loan: ");
        Input.userInput.nextLine();
        int duration=Input.readInt("Enter the time period (in year):");
        Input.userInput.nextLine();
        double total=(((amount*anualInterestHouse)*duration)+amount);

        System.out.println("Total to pay back:"+df.format(total)+" SEK.");
        int paymentDuration= Input.readInt("Enter the the time period you want to pay (in year):");
        Input.userInput.nextLine();
        double paymentAmount=total%(paymentDuration*12);
        System.out.println("Payment per month: "+df.format(paymentAmount)+ " SEK."+EOL);
        String answer=Input.readString("Do you want the loan? ");
        Input.userInput.nextLine();
        if(answer.equals("yes")){
            long an = Input.readLong("Please enter your account number to receive your loan: ");
            Input.userInput.nextLine();
            if(containsAccount(an,accounts)==false){
                System.out.println("Enter a valid account number: "+EOL);
                doMortgagePage();

            }else if(containsAccount(an,accounts)==true){
                Account myAccount=findAccount(an,accounts);
                double newBalance=(myAccount.getBalance()+amount);
                System.out.println(df.format(amount)+" SEK has been sent to account: "+myAccount.getAccountNumber()+EOL);
            }


        }else if(answer.equals("no")){
            doHomePage();
        }}



    public static void transferMoney(){
        Long myAccounNumber = Input.readLong("Enter the account number: ");
        Input.userInput.nextLine();
        int password = Input.readInt("Enter the password: ");
        Input.userInput.nextLine();
        if (Input.verifyLogin(myAccounNumber, password) == false){
            System.out.println("Enter valid account number and password: " + EOL);transferMoney();
        } else if (Input.verifyLogin(myAccounNumber, password) == true) {
            Account myAccount = findAccount(myAccounNumber, accounts);
            System.out.println(myAccount.toString() + EOL);
            long anotherAn = Input.readLong("Enter the account to transfer money:");
            Input.userInput.nextLine();
            if (!containsAccount(anotherAn, accounts)) {
                System.out.println("The account does not exist. Enter a valid account number:" + EOL);transferMoney();

            } else if (containsAccount(anotherAn, accounts)) {
                Account anotherAccount = findAccount(anotherAn, accounts);
                double amount = Input.readDouble("Enter the amount to transfer:");
                Input.userInput.nextLine();
                double newBalance = (anotherAccount.getBalance() + amount);
                anotherAccount.setBalance(newBalance);
                double myNewBalance = (myAccount.getBalance() - amount);
                myAccount.setBalance(myNewBalance);
                System.out.println(myAccount.toString()+EOL+"Amount transferred: "+df.format(amount)+" SEK."+EOL);


            }
        }
    }}
