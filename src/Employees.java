import java.util.ArrayList;

public class Employees {


    //EID,forename, surname, position, rate of pay,Contracted hours , username , password,admin, hollidays[],Payments[]



    private int EID;
    private String forename,surname,position,username,password;
    private double rOfPay;
    private float contHours;
    ArrayList<Holidays> hollidays;
    ArrayList<Payments> payments;



    public Employees(int EID, String forename, String surname, String position, String username, String password, double rOfPay, float contHours, ArrayList<Holidays> holidays, ArrayList<Payments> payments) {

        this.EID = EID;
        this.forename = forename;
        this.surname = surname;
        this.position = position;
        this.username = username;
        this.password = password;
        this.rOfPay = rOfPay;
        this.contHours = contHours;
        this.hollidays = holidays;
        this.payments = payments;
    }

    public int getEID() {
        return EID;
    }

    public void setEID(int EID) {
        this.EID = EID;
    }

    public String getForename() {
        return forename;
    }

    public void setForename(String forename) {
        this.forename = forename;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getrOfPay() {
        return rOfPay;
    }

    public void setrOfPay(double rOfPay) {
        this.rOfPay = rOfPay;
    }

    public float getContHours() {
        return contHours;
    }

    public void setContHours(float contHours) {
        this.contHours = contHours;
    }

    public ArrayList<Holidays> getHollidays() {
        return hollidays;
    }

    public void setHollidays(ArrayList<Holidays> hollidays) {
        this.hollidays = hollidays;
    }

    public ArrayList<Payments> getPayments() {
        return payments;
    }

    public void setPayments(ArrayList<Payments> payments) {
        this.payments = payments;
    }

}
