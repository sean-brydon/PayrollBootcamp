import java.util.ArrayList;

public class Employees {


    //EID,forename, surname, position, rate of pay,Contracted hours , username , password,admin, hollidays[],Payments[]


    private int EID;
    private String forename, surname, position, username, password;
    private double rOfPay;
    private float contHours;
    private boolean isAdmin = false;
    ArrayList<Holidays> hollidays;
    ArrayList<Payments> payments;
    private float holidayTime;


    public Employees(int EID, String forename, String surname, String position, String username, String password, float contHours, boolean isAdmin) {

        this.EID = EID;
        this.forename = forename;
        this.surname = surname;
        this.position = position;
        this.username = username;
        this.password = password;
        this.contHours = contHours;
        this.hollidays = new ArrayList();
        this.payments = new ArrayList();
        switch (position) {
            case "HR":
                rOfPay = 11.60;
                this.isAdmin = true;
                break;
            case "Payroll":
                rOfPay = 11.40;
                this.isAdmin = true;
                break;
            case "MD":
                rOfPay = 37.50;
                this.isAdmin = true;
                break;
            case "Developer":
                rOfPay = 15.30;
            case "Lead Developer":
                rOfPay = 20.40;
            case "Admin":
                rOfPay = 16.50;
            case "Cleaner":
                rOfPay = 7.20;
            case "Apprentice":
                rOfPay = 6.80;
            default:
                rOfPay = 9.50;
                this.isAdmin = false;

        }
        if(contHours < 10){
            this.holidayTime = 8;
        }else if(contHours >= 10 && contHours <=25){
            this.holidayTime = 14;
        }else if(contHours > 26){
            this.holidayTime = 25;
        }
    }
        public int getEID () {
            return EID;
        }

        public void setEID ( int EID){
            this.EID = EID;
        }

        public String getForename () {
            return forename;
        }

        public void setForename (String forename){
            this.forename = forename;
        }

        public String getSurname () {
            return surname;
        }

        public void setSurname (String surname){
            this.surname = surname;
        }

        public String getPosition () {
            return position;
        }

        public void setPosition (String position){
            this.position = position;
        }

        public String getUsername () {
            return username;
        }

        public void setUsername (String username){
            this.username = username;
        }

        public String getPassword () {
            return password;
        }

        public void setPassword (String password){
            this.password = password;
        }

        public double getrOfPay () {
            return rOfPay;
        }

        public void setrOfPay ( double rOfPay){
            this.rOfPay = rOfPay;
        }

        public float getContHours () {
            return contHours;
        }

        public void setContHours ( float contHours){
            this.contHours = contHours;
        }

        public ArrayList<Holidays> getHollidays () {
            return hollidays;
        }

        public void setHollidays (ArrayList < Holidays > hollidays) {
            this.hollidays = hollidays;
        }

        public ArrayList<Payments> getPayments () {
            return payments;
        }

        public void setPayments (ArrayList < Payments > payments) {
            this.payments = payments;
        }

        public boolean isAdmin () {
            return isAdmin;
        }

        public void setAdmin ( boolean admin){
            isAdmin = admin;
        }

    public float getHolidayTime() {
        return holidayTime;
    }

    public void setHolidayTime(float holidayTime) {
        this.holidayTime = holidayTime;
    }
}
