package pages;
import bussinessLogic.Account;
import java.text.DecimalFormat;
import java.util.ArrayList;
import static pages.CustomerPage.*;
import static pages.HomePage.doHomePage;
import static pages.Input.*;
import static pages.Input.EOL;
public class AccountPage {
    public static final DecimalFormat df = new DecimalFormat("0.00");
    public static ArrayList<Account> accounts=new ArrayList<Account>();
    public static void doAccount(){
        System.out.println("Account page: "+EOL+
                "1. Create an account."+EOL+
                "2. Log in"+EOL+
                "3. Change password"+EOL+
                "Enter an option: "+EOL);
        int option=Input.verifyOptionInput(1,3);
        switch (option){
            case 1:
                createAccount();
                break;

            case 2:
                loginAccount();
                break;
            case 3:
                changePassword();
                break;
        }}

    public static void createAccount(){
        long ssn = Input.readLong("Enter the personal number of the person you want to create account for : ");
        Input.userInput.nextLine();
        if (containCustomer(ssn, customers) == false) {
            System.out.println("Customer was not found. You have to register the customer first!"+EOL);
            registerCustomer();
        } else if (containCustomer(ssn, customers) == true) {
            String name=findCustomer(ssn, customers).getName();
            String lastName=findCustomer(ssn,customers).getLastName();
            System.out.println("Your bank account number will be the following number: ");
            long accountNum = Input.random10Digits();
            System.out.println(accountNum);
            int password = Input.readInt("Enter a four digits password: ");
            Input.userInput.nextLine();
            if(verify4Didigts(password)==false){
                System.out.println("The password must be 4 digits. Try again!");
                createAccount();
            }
            if(verify4Didigts(password)==true) {
                double balance = 0.0;
                accounts.add(new Account(name, lastName, ssn, accountNum, password, balance));
                System.out.println("Account was successfully created"+EOL+
                        findAccount(accountNum,accounts).toString()+EOL); doHomePage();

            }}}
    public static void changePassword(){
        long an=Input.readLong("Enter your account number");
        userInput.nextLine();
        int password=Input.readInt("Enter your password: ");
        userInput.nextLine();
        if(verifyLogin(an,password)==false){
            System.out.println("Invalid Login information. Please try again!"+EOL);changePassword();
        }else if(verifyLogin(an,password)==true){
            int newPass=Input.readInt("Enter new password (must be 4 digits): ");
            userInput.nextLine();
            if(verify4Didigts(newPass)==true){
                Account thisAccount= findAccount(an,accounts);
                thisAccount.setPassword(newPass);
                System.out.println("Your new password is: "+newPass+EOL);
            }else if(verify4Didigts(newPass)==false){
                System.out.println("Invalid password. Try again! "+EOL);doAccount();
            }
        }}
    public static void loginAccount(){
        long an=Input.readLong("Enter account number:");
        Input.userInput.nextLine();
        int password=Input.readInt("Enter you password: ");
        userInput.nextLine();
        if(verifyLogin(an,password)==true){
            Account desiredAccount=findAccount(an,accounts);
            System.out.println(desiredAccount.toString());
        }else if(verifyLogin(an,password)==false){
            System.out.println("Log ing was not successful. Try again! "+EOL);doAccount();
        }
    }
    public static Account findAccount(long a_n,ArrayList<Account>accounts){
        for(Account desiredAccount:accounts){
            if(desiredAccount.getAccountNumber()==a_n){
                return desiredAccount;
            }
        }return null; }
    public static boolean containsAccount(long a_n, ArrayList<Account>accounts){
        for(Account desiredAccount:accounts){
            if(desiredAccount.getAccountNumber()==a_n){
                return true;
            }
        }return false;}

}

