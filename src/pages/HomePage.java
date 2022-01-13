package pages;
import bussinessLogic.Transaction;
import java.util.ArrayList;

import static pages.DepositWithdraw.*;
import static pages.Input.EOL;
import static pages.MortgagePage.doMortgagePage;
import static pages.MortgagePage.transferMoney;

public class HomePage {
    public static ArrayList<Transaction>transactions=new ArrayList<Transaction>();
    public static void doHomePage() {
        System.out.println("Home page:" + EOL +
                "1. Customer" + EOL +
                "2. Account" + EOL +
                "3. Deposit" + EOL +
                "4. Withdraw" + EOL +
                "5. Check the balance" + EOL +
                "6. View transactions" + EOL +
                "7. Transfer money to another account" + EOL +
                "8. Apply for mortgage" + EOL +
                EOL +
                "Enter an opion number: " + EOL);

        int optionMenu = Input.verifyOptionInput(1, 8);
        switch (optionMenu) {
            case 1: CustomerPage.doCustomer();
                break;

            case 2: AccountPage.doAccount();
                break;

            case 3:DepositWithdraw.deposit();
                break;

            case 4:withdraw();
                break;

            case 5:checkTheBalance();
                break;

            case 6:viewTransactions();
                break;

            case 7:transferMoney();
                break;

            case 8:doMortgagePage();
                break;

        }}





}



