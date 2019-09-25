import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class User {

    Employees e;
    Scanner scanner = new Scanner(System.in);
    int bChoice;

    public User(Employees e, int bChoice) throws ParseException {
        this.e = e;
        this.bChoice = bChoice;
        userChoice(e, bChoice);
    }


    private void userChoice(Employees e, int bChoice) throws ParseException {
        switch (bChoice) {
            case 1:
                historicalPayments(e);
                break;
            case 2:
                upcomingPayments(e);
                break;
            case 3:
                yearSummary(e);
                break;
            case 4:
                holidayBal(e);
                break;
            case 5:
                viewHolidays(e);
                break;
            case 6:
                holidayReq(e);
                break;
        }
    }

    private void holidayReq(Employees e) {

    }

    private void viewHolidays(Employees e) {
    }

    private void holidayBal(Employees e) {
    }

    private void yearSummary(Employees e) {
    }

    private void upcomingPayments(Employees e) {

    }

    private void historicalPayments(Employees e) throws ParseException {
        Date today = Calendar.getInstance().getTime();
        for (Payments p : Login.payments) {

            if(Date.parse(p.getDatePayment().toString()) < today){
                //start is less than End
            }
            if (e.getEID() == p.getEID()) {
                System.out.println(ConsoleColors.RED_BOLD + "---------" + ConsoleColors.GREEN_BOLD + "Welcome" + e.getForename()+"!" + ConsoleColors.RED_BOLD + "-------------" + ConsoleColors.RESET);
                System.out.println("EID: " + p.getEID() + "\nDate: " + p.getDatePayment() + "\nNet Pay: " +
                        "" + p.getNetPay() + "\nGross Pay: " + p.getGrossValue());
            }

        }
    }

    private void returnMenu(Employees e) throws ParseException {
        System.out.println("Type" + ConsoleColors.RED_BOLD + " exit " + ConsoleColors.RESET + "to exit to the main menu.");
        String choice = scanner.nextLine();
        if (choice.equalsIgnoreCase("exit")) {
            MainMenu mm = new MainMenu(e);
        } else {
            System.exit(0);
        }

    }

}