package pages;
import bussinessLogic.Customer;
import java.util.ArrayList;
import static pages.HomePage.doHomePage;
import static pages.Input.*;
public class CustomerPage {
    public static ArrayList<Customer> customers = new ArrayList<>();
    public static void doCustomer(){
        System.out.println("Customer page: " + EOL +
                "1. Register a new customer." + EOL +
                "2. Check if a person is already a customer." + EOL +
                "3. Show customer's details." + EOL+
                "4. Update a customer."+EOL+
                "Enter an option: ");
        int optionMenu = Input.verifyOptionInput(1, 4);
        switch (optionMenu) {

            case 1: registerCustomer();
                break;

            case 2: checkCustomer();
                break;

            case 3: printCustomer();
                break;

            case 4: updateCustomer();
                break;
        }
    }

    public static void registerCustomer (){
        String name = Input.readString("Enter name: ");
        String lastName = Input.readString("Enter last name: ");
        int ssn = Input.readInt("Enter personal number (10 digits): ");
        if(name.isBlank()||lastName.isBlank()||verify10Didigts(ssn)==false){
            System.out.println("Please enter valid information."+EOL);registerCustomer();
        }
        else if (!name.isBlank() && !lastName.isBlank()&&verify10Didigts(ssn)==true) {
            if (customers.contains(findCustomer(ssn, customers))) {
                System.out.println(findCustomer(ssn, customers).toString() + EOL + "is already a customer.");
            }else customers.add(new Customer(name, lastName, ssn));
            System.out.println(findCustomer(ssn, customers).toString() +EOL+ "was added as a customer.");

        } doHomePage();

    }
    public static void updateCustomer(){
        long ssn=Input.readLong("Enter the SSN: ");
        Input.userInput.nextLine();

        if(containCustomer(ssn,customers)==true){
            Customer desiredCustomer=findCustomer(ssn,customers);
            System.out.println(desiredCustomer.toString());
            String newName=Input.readString("Enter the new name: ");
            Input.userInput.nextLine();
            String newLastName=Input.readString("Enter the new last name: ");
            Input.userInput.nextLine();
            long newSsn=Input.readLong("Enter the new SSN: ");
            Input.userInput.nextLine();

            if (verify10Didigts(newSsn)==true){
                desiredCustomer.setLastName(newLastName);
                desiredCustomer.setName(newName);
                desiredCustomer.setSsn(newSsn);
                System.out.println("Information of the customer is updated."+EOL+
                        "Name: "+ newName+EOL+"Last name: "+newLastName+EOL+"SSN: "+newSsn+EOL);doHomePage();
            }else if(verify10Didigts(ssn)==false){
                System.out.println("Invalid SSN. Enter a 10 digits SSN: "+EOL);updateCustomer();
            }
        }else if(containCustomer(ssn,customers)==false){
            System.out.println("No customer with SSN: "+ssn+" is registered."+EOL);updateCustomer();
        }doHomePage();
    }

    public static Customer findCustomer(long requiredSsn, ArrayList<Customer>customers){
        for(Customer desiredCustomer:customers){
            if(desiredCustomer.getSsn()==requiredSsn){
                return desiredCustomer;
            }
        }return null;
    }
    public static boolean containCustomer(long ssn, ArrayList<Customer>customers){
        for(Customer desiredCustomer: customers){
            if(desiredCustomer.getSsn()==ssn){
                return true;
            } }return false;
    }

    public static void checkCustomer(){
        long ssn=Input.readLong("Enter your SSN: ");

        if(containCustomer(ssn,customers)==true){
            System.out.println("The customer "+ssn+" is registered."+EOL);

        }else if(containCustomer(ssn,customers)==false){
            System.out.println("The customer "+ssn+" is not registered."+EOL);
        }
    }
    public static void printCustomer(){
        long ssn=Input.readLong("Enter your SSN:");
        Input.userInput.nextLine();

        if(containCustomer(ssn,customers)){
            Customer desiredCustomer=findCustomer(ssn,customers);
            System.out.println(desiredCustomer.toString());

        }else if(!containCustomer(ssn,customers)){
            System.out.println("The customer is not registered in the system."+EOL);
        }
    }
}