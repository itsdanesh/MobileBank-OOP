package pages;
import bussinessLogic.Account;
import bussinessLogic.Customer;
import bussinessLogic.Transaction;

import static pages.AccountPage.accounts;
import static pages.CustomerPage.customers;
import static pages.HomePage.doHomePage;
import static pages.HomePage.transactions;

public class Main {

    public static void main(String[] args) {


        Customer customer1 = new Customer("Danesh", "Mohammadi", 1999121319);
        Customer customer2 = new Customer("John", "Hamilton", 1999022021);
        Customer customer3=new Customer("Steve","Jobs",2016100911);
        Customer customer4= new Customer("Halmet","Aniston",1470121314);
        Customer customer5=new Customer("Elon","Musk",1945030955);


        Account account1 = new Account("Danesh", "Mohammadi", 1999121319, 1234567899, 1122, 10000);
        Account account2= new Account("John", "Hamilton", 1010101011, 1123456789, 5544, 20000);
        Account account3=new Account("Steve","Jobs",2016100911,1223456789,9988,200000);
        Account account4=new Account("Elon","Musk",1945030955,1233456789,5454,120000);

        Transaction tran1=new Transaction(1234567899,200,"Withraw amount:","2021-02-13");
        Transaction tran2=new Transaction(1234567899,1000,"Deposit amount:","2021-03-12");
        Transaction tran3=new Transaction(1234567899,100,"Withdraw amount:", "2022-01-02");
        Transaction tran4=new Transaction(1234567899,1300,"Deposit amount:","2021-12-29");



        customers.add(customer1);
        customers.add(customer2);
        customers.add(customer3);
        customers.add(customer4);
        customers.add(customer5);

        accounts.add(account1);
        accounts.add(account2);
        accounts.add(account3);
        accounts.add(account4);


        transactions.add(tran1);
        transactions.add(tran2);
        transactions.add(tran3);
        transactions.add(tran4);
        doHomePage();


    }

}

