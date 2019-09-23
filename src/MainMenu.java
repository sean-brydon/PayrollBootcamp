import java.util.Scanner;

public class MainMenu {
    //Login
        //Check if user name and password is correct.
        // Check if user is Admin.
    // present correct menu


    // Admin
        /** Add new employee
         * View all employee's
         * Make new payments
         * View and edit payments
         * View history of payments
         * View and edit employee's but NOT themselves
         * View holiday requests
        *
        */

        Scanner scanner = new Scanner(System.in);
        Employees e;
        public MainMenu(Employees e){
            this.e = e;
            openMenu(e);
        }


    private void openMenu(Employees e) {
        if (e.isAdmin()){
            adminMenu(e);
        }else{
            employeeMenu(e);
        }
    }

    private void adminMenu(Employees e) {
        System.out.println(ConsoleColors.RED_BOLD+"----------"+ConsoleColors.RESET);
        System.out.println(ConsoleColors.RED_BOLD+"Admin Menu"+ConsoleColors.RESET);
        System.out.println(ConsoleColors.RED_BOLD+"----------"+ConsoleColors.RESET);
        System.out.println(ConsoleColors.RED_BOLD+"1)"+ConsoleColors.RESET + " Add New Employee");
        System.out.println(ConsoleColors.RED_BOLD+"2)"+ConsoleColors.RESET + " View List Of Employee's");
        System.out.println(ConsoleColors.RED_BOLD+"3)"+ConsoleColors.RESET + " Process A New Payment");
        System.out.println(ConsoleColors.RED_BOLD+"4)"+ConsoleColors.RESET + " View and Edit Pending Payments");
        System.out.println(ConsoleColors.RED_BOLD+"5)"+ConsoleColors.RESET + " View and Edit Employee's");
        System.out.println(ConsoleColors.RED_BOLD+"6)"+ConsoleColors.RESET + " Holiday Requests");
        System.out.println(ConsoleColors.RED_BOLD+"7)"+ConsoleColors.RESET + " View Reports");
        int aChoice = Integer.parseInt(scanner.nextLine());
        Admin admin = new Admin(e,aChoice);
    }

    private void employeeMenu(Employees e) {
        System.out.println(ConsoleColors.GREEN_BOLD+"----------"+ConsoleColors.RESET);
        System.out.println(ConsoleColors.GREEN_BOLD+"Employee Menu"+ConsoleColors.RESET);
        System.out.println(ConsoleColors.GREEN_BOLD+"----------"+ConsoleColors.RESET);
        System.out.println(ConsoleColors.GREEN_BOLD+"1)"+ConsoleColors.RESET + " View Historical Payments");
        System.out.println(ConsoleColors.GREEN_BOLD+"2)"+ConsoleColors.RESET + " View Upcoming Payments");
        System.out.println(ConsoleColors.GREEN_BOLD+"3)"+ConsoleColors.RESET + " Check a Year-To-Date Summary");
        System.out.println(ConsoleColors.GREEN_BOLD+"4)"+ConsoleColors.RESET + " Holiday Balance");
        System.out.println(ConsoleColors.GREEN_BOLD+"5)"+ConsoleColors.RESET + " View Holidays");
        System.out.println(ConsoleColors.GREEN_BOLD+"6)"+ConsoleColors.RESET + " Holiday Requests");

    }
}
