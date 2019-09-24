import com.sun.tools.javac.Main;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class Login {
    //Checks username and password against Employees data.
    // Return a bool.
    static ArrayList<Employees> employees;
    static ArrayList<Payments> payments;
    static ArrayList<Holidays> holidays;
    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws ParseException {
        Login login = new Login();
        login.init();//Fills arrays with preset data.
        login.login();
    }

    private void init() throws ParseException {
        Init init = new Init();
        employees = init.seedEmployee();
        payments = init.seedPayments();
        holidays = init.seedHolidays();
    }

    private void login() throws ParseException {
        System.out.println("Please enter a username");
        String uname = scanner.nextLine();
        System.out.println("Please Enter a password for " + uname);
        String pass = scanner.nextLine();



        int counter = 1;
//
        for (Employees e : employees) {
            if(e.getUsername().equalsIgnoreCase(uname)){
                if (e.getPassword().equals(pass)){
                    openMenu(e);
                    break;
                }
            }else if (counter == employees.size()){
                System.out.println("Incorrect username and/or password.");
                login();
            }
            counter++;
        }
    }

    private void openMenu(Employees e) throws ParseException {
        System.out.println("logging into "+ e.getUsername());
        MainMenu mm = new MainMenu(e);


    }

}
