import org.joda.time.DateTime;
import org.joda.time.Days;

import java.text.ParseException;
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
                holidayBal(e);
                break;
            case 4:
                viewHolidays(e);
                break;
            case 5:
                holidayReq(e);
                break;
            case 6:
                yearToDate(e);
        }
    }

    private void yearToDate(Employees e) {
        
    }

    private void holidayReq(Employees e) {
        System.out.println("Please Enter the"+ConsoleColors.GREEN_BOLD+" date"+ConsoleColors.RESET+" you would like to create a holiday on" +ConsoleColors.GREEN_BOLD+" dd/MM/yyyy"+ConsoleColors.RESET);
        String startDate = scanner.nextLine();
        DateTime dStartDate = Init.createDate(startDate);
        DateTime today = new DateTime();

        if (dStartDate.isBefore(today)) {
            System.out.println("You "+ConsoleColors.RED_BOLD+"cannot"+ConsoleColors.RESET+"place a holiday in the past");
            holidayReq(e);
        }else{
            System.out.println("Please Enter the"+ConsoleColors.GREEN_BOLD+"date"+ConsoleColors.RESET+" you would like to end the holiday on" +ConsoleColors.GREEN_BOLD+"dd/MM/yyyy"+ConsoleColors.RESET);
            String endDate = scanner.nextLine();
            DateTime dEndDate = Init.createDate(endDate);
            Days daysBtwn = Days.daysBetween(dStartDate,dEndDate);
            int intDaysBtwn = daysBtwn.getDays();
            if (intDaysBtwn < e.getHolidayTime()){
                System.out.println("Holiday Placed for "+ConsoleColors.GREEN_BOLD+dStartDate+ConsoleColors.RESET+" to the "+ConsoleColors.RED_BOLD+dEndDate+ConsoleColors.RESET);
                float hoursLeft = e.getHolidayTime() - intDaysBtwn;
                System.out.println("You now have "+ConsoleColors.GREEN_BOLD+hoursLeft+ConsoleColors.RESET+"days of holiday to take");
                System.out.println("Your holiday is now "+ConsoleColors.YELLOW_BOLD+"Pending"+ConsoleColors.RESET);
                e.setHolidayTime(hoursLeft);
                Login.holidays.add(new Holidays(dStartDate,dEndDate,e.getEID(),"Pending",Login.holidays.size()));
            }else{

            }
        }

    }

    private void viewHolidays(Employees e) throws ParseException {
        for (Holidays holidays : Login.holidays) {
            for (Employees employees : Login.employees) {
                if (holidays.getEID() == employees.getEID()) {
                    System.out.println(ConsoleColors.RED_BOLD + "---------" + ConsoleColors.GREEN_BOLD + "EID " + holidays.getEID() + ConsoleColors.RED_BOLD + "-------------" + ConsoleColors.RESET);
                    System.out.println("You are viewing the" + ConsoleColors.YELLOW_BOLD + " Pending " + ConsoleColors.RESET + "holidays for the user " + ConsoleColors.GREEN_BOLD + employees.getForename() + " " + employees.getSurname() + ConsoleColors.RESET);
                    System.out.println("Start Date : " + ConsoleColors.GREEN_BOLD + holidays.getStartDate() + ConsoleColors.RESET + "\nEnd Date: " + ConsoleColors.RED_BOLD + holidays.getEndDate() + ConsoleColors.RESET + "\nHoliday ID: " + ConsoleColors.PURPLE_BOLD + holidays.getHID() + ConsoleColors.RESET);
                }
            }

        }
        returnMenu(e);
    }


    private void holidayBal(Employees e) {
        System.out.println("You have "+ConsoleColors.GREEN_BOLD+e.getHolidayTime()+"Days "+ConsoleColors.RESET+"remaining for this year");
    }

    private void upcomingPayments(Employees e) throws ParseException {
        DateTime today = new DateTime();
        for (Payments p : Login.payments) {
            DateTime dt = p.getDatePayment();
            if (dt.isAfter(today)) {
                if (e.getEID() == p.getEID()) {
                    System.out.println(ConsoleColors.RED_BOLD + "---------" + ConsoleColors.GREEN_BOLD + " Welcome " + e.getForename() + "!" + ConsoleColors.RED_BOLD + "-------------" + ConsoleColors.RESET);
                    System.out.println("EID: " + p.getEID() + "\nDate: " + p.getDatePayment() + "\nNet Pay: " +
                            "" + p.getNetPay() + "\nGross Pay: " + p.getGrossValue());
                }
            }
        }
        returnMenu(e);
    }

    private void historicalPayments(Employees e) throws ParseException {
        DateTime today = new DateTime();
        for (Payments p : Login.payments) {
            DateTime dt = p.getDatePayment();
            if (dt.isBefore(today)) {
                if (e.getEID() == p.getEID()) {
                    System.out.println(ConsoleColors.RED_BOLD + "---------" + ConsoleColors.GREEN_BOLD + " Welcome " + e.getForename() + "!" + ConsoleColors.RED_BOLD + "-------------" + ConsoleColors.RESET);
                    System.out.println("EID: " + p.getEID() + "\nDate: " + p.getDatePayment() + "\nNet Pay: " +
                            "" + p.getNetPay() + "\nGross Pay: " + p.getGrossValue());
                }
            }
        }
        returnMenu(e);
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