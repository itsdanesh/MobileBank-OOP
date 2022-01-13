package pages;
import bussinessLogic.Account;
import java.util.Scanner;

import static pages.AccountPage.accounts;

public class Input {
    public static Scanner userInput = new Scanner(System.in);
    public static final String EOL=System.lineSeparator();

    public static int verifyOptionInput(int start, int end) {
        int optionInput = 0;
        do {
            optionInput = userInput.nextInt();
            userInput.nextLine();
            if (optionInput < start || optionInput > end) {
                System.out.println("Invalid menu option. Please type another option");
            }
        } while (optionInput < start || optionInput > end);
        return optionInput;
    }


    public static double readDouble(String message) {
        System.out.println(message);
        double value = Input.userInput.nextDouble();
        Input.userInput.nextLine();
        return value;
    }

    public static String readString(String message) {
        System.out.println(message);
        String value = Input.userInput.nextLine();
        Input.userInput.nextLine();
        return value;
    }

    public static int readInt(String message) {
        System.out.println(message);
        int value = Input.userInput.nextInt();
        Input.userInput.nextLine();
        return value;
    }
    public static long readLong(String message) {
        System.out.println(message);
        Long value = Input.userInput.nextLong();
        Input.userInput.nextLine();
        return value;
    }


    public static boolean verify10Didigts(long ssn) {
        long length = String.valueOf(ssn).length();
        if (length != 10) {return false;
        } else if (length == 10); return true;
    }


    public static boolean verify4Didigts(int password) {
        int length = String.valueOf(password).length();
        if (length != 4) {return false;
        } else if (length==4); return true;}

    public static long random10Digits(){
        long theRandomNum = (long) (Math.random()*Math.pow(10,10));
        Input.verify10Didigts(theRandomNum);
        return theRandomNum;}

    public static boolean verifyLogin(long a_n, int password){
        for(Account desiredAccount:accounts){
            if(desiredAccount.getAccountNumber()==a_n&&desiredAccount.getPassword()==password){
                return true;
            }
        }return false;}


}
