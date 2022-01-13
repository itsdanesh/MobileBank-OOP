package bussinessLogic;

import static pages.AccountPage.df;
import static pages.Input.EOL;
public class Transaction{
    private final long an;
    private double transAmount;
    private String type;
    private String date;
    public Transaction(long an, double transAmount, String type,String date){
        this.an=an;
        this.date=date;
        this.transAmount =transAmount;
        this.type=type;


    }
    public long getAn() {
        return an;
    }
    public double getTransAmount() {
        return transAmount;
    }
    public String getType() {
        return type;}
    public String getDate() {
        return date;}







    @Override
    public String toString() {
        String message= getType()+": "+df.format(getTransAmount()) +" SEK."+EOL+
                "Date:"+getDate()+EOL;

        return message;}
}
