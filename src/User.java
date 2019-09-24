import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class User {

    Employees e;

    int bChoice;

    public User(Employees e, int bChoice) {
        this.e = e;
        this.bChoice = bChoice;
        userChoice(e, bChoice);
    }


    private void userChoice(Employees e, int bChoice) {
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

    private void historicalPayments(Employees e) {
        for (Payments p : Login.payments) {
            if (e.getEID() == p.getEID()) {
                System.out.println(ConsoleColors.RED_BOLD + "---------" + ConsoleColors.GREEN_BOLD + "User " + p.getEID() + ConsoleColors.RED_BOLD + "-------------" + ConsoleColors.RESET);
                System.out.println("EID: " + p.getEID() + "\nDate: " + p.getDatePayment() + "\nNet Pay: " +
                        "" + p.getNetPay() + "\nGross Pay: " + p.getGrossValue());
            }
            break;
        }
    }

}