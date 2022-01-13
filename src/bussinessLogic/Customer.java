package bussinessLogic;

import pages.Input;

import static pages.Input.EOL;

public class Customer {
    private String name;
    private String LastName;
    private  long ssn;
    public Customer(String name, String LastName, long ssn){
        if(Input.verify10Didigts(ssn)==false){
            System.out.println("The SSN must be 10 digits. ");}
        this.name = name;
        this.LastName = LastName;
        this.ssn =ssn;
    }


    public String toString(){
        return getName()+" "+getLastName()+EOL+"SSN: "+getSsn();

    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }


    public long getSsn() {
        return ssn;
    }

    public void setSsn(long ssn) {
        this.ssn = ssn;
    }


}
