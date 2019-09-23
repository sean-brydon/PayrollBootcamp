import java.util.ArrayList;
import java.util.Scanner;

public class Admin {

    Employees e; // logged in
    int aChoice;
    Scanner scanner = new Scanner(System.in);
    public Admin(Employees e, int aChoice){
        this.e = e;
        this.aChoice = aChoice;
        adminChoice(e,aChoice);
    }


    private void adminChoice(Employees e, int aChoice) {
        switch (aChoice){
            case 1:
                newEmployee();
            case 2:
                viewEmployee();
            case 3:
                newPayment();
            case 4:
                pendingPayments();
            case 5:
                editEmployee();
            case 6:
                holidayRequests();
            case 7:
                viewReports();
            default:
                MainMenu mm = new MainMenu(e);
        }
    }

    private void newEmployee() {
        int EID = Login.employees.size() + 1;
        System.out.println(ConsoleColors.RED+">>"+ConsoleColors.RESET+"Please Enter the Employees Forname");
        String fn = scanner.nextLine();
        System.out.println(ConsoleColors.RED+">>"+ConsoleColors.RESET+"Please Enter the Employees Surname");
        String sn = scanner.nextLine();
        System.out.println(ConsoleColors.RED+">>"+ConsoleColors.RESET+"Please Enter the Employees Position");
        String pos = scanner.nextLine();
        System.out.println(ConsoleColors.RED+">>"+ConsoleColors.RESET+"Please Enter the Employees Username");
        String username = scanner.nextLine();
        System.out.println(ConsoleColors.RED+">>"+ConsoleColors.RESET+"Please Enter the Employees Password");
        String password = scanner.nextLine();
        System.out.println(ConsoleColors.RED+">>"+ConsoleColors.RESET+"Please Enter the Employees Contracted Hours");
        float cHours = Float.parseFloat(scanner.nextLine());
        Login.employees.add(new Employees(Login.employees.size()+1,fn,sn,pos,username,password,cHours,false));
    }

    private void viewEmployee() {
    }

    private void pendingPayments() {

    }

    private void editEmployee() {

    }

    private void newPayment() {

    }

    private void holidayRequests() {

    }

    private void viewReports() {

    }

}
