import java.util.ArrayList;
import java.util.Scanner;

public class Admin {

    Employees e; // logged in
    int aChoice;
    Scanner scanner = new Scanner(System.in);

    public Admin(Employees e, int aChoice) {
        this.e = e;
        this.aChoice = aChoice;
        adminChoice(e, aChoice);
    }


    private void adminChoice(Employees e, int aChoice) {
        switch (aChoice) {
            case 1:
                newEmployee();
                break;
            case 2:
                viewEmployee(e);
                break;
            case 3:
                newPayment();
                break;
            case 4:
                pendingPayments();
                break;
            case 5:
                editEmployee();
                break;
            case 6:
                holidayRequests();
                break;
            case 7:
                viewReports();
                break;
            default:
                MainMenu mm = new MainMenu(e);
        }
    }

    private void newEmployee() {
        int EID = Login.employees.size() + 1;
        System.out.println(ConsoleColors.RED + ">>" + ConsoleColors.RESET + "Please Enter the Employees Forname");
        String fn = scanner.nextLine();
        System.out.println(ConsoleColors.RED + ">>" + ConsoleColors.RESET + "Please Enter the Employees Surname");
        String sn = scanner.nextLine();
        System.out.println(ConsoleColors.RED + ">>" + ConsoleColors.RESET + "Please Enter the Employees Position");
        String pos = scanner.nextLine();
        System.out.println(ConsoleColors.RED + ">>" + ConsoleColors.RESET + "Please Enter the Employees Username");
        String username = scanner.nextLine();
        System.out.println(ConsoleColors.RED + ">>" + ConsoleColors.RESET + "Please Enter the Employees Password");
        String password = scanner.nextLine();
        System.out.println(ConsoleColors.RED + ">>" + ConsoleColors.RESET + "Please Enter the Employees Contracted Hours");
        float cHours = Float.parseFloat(scanner.nextLine());
        Login.employees.add(new Employees(Login.employees.size() + 1, fn, sn, pos, username, password, cHours, false));
        MainMenu mm = new MainMenu(e);

    }

    private void viewEmployee(Employees e) {
        int count = 0;
        for (Employees employees : Login.employees) {
            System.out.println(ConsoleColors.RED_BOLD + "---------" + ConsoleColors.GREEN_BOLD + "User " + employees.getEID() + ConsoleColors.RED_BOLD + "-------------" + ConsoleColors.RESET);
            System.out.println("Forname: " + employees.getForename() + "\nSurname: " + employees.getSurname() + "\nPosition: " +
                    "" + employees.getPosition() + "\nUsername: " + employees.getUsername() + "\nPassword: " + employees.getPassword() + "" +
                    "\nContracted Hours: " + employees.getContHours());


//            System.out.println(ConsoleColors.RED_BOLD + "-----------------------------" + ConsoleColors.RESET);

        }
        System.out.println("Press " + ConsoleColors.RED_BOLD + "RETURN " + ConsoleColors.RESET + "to go back to the Admin Menu.");
        String anyKey = scanner.nextLine();
        switch (anyKey) {
            default:
                MainMenu mm = new MainMenu(e);
        }
    }

    private void pendingPayments() {

    }

    private void editEmployee() {
        System.out.println(ConsoleColors.RED_BOLD + "---------" + ConsoleColors.GREEN_BOLD + "Edit Employee Mode " + ConsoleColors.RED_BOLD + "-------------" + ConsoleColors.RESET);
        System.out.println("Please Enter the " + ConsoleColors.GREEN_BOLD + "EID" + ConsoleColors.RESET + " of the user you would like to edit.");
        int editEID = Integer.parseInt(scanner.nextLine());
        for (Employees employees : Login.employees) {
            if (employees.getEID() == editEID) {
                System.out.println("Please Select What attribute you want to edit");
                System.out.println(ConsoleColors.RED + "1) " + ConsoleColors.RESET + "Forename");
                System.out.println(ConsoleColors.RED + "2) " + ConsoleColors.RESET + "Surname");
                System.out.println(ConsoleColors.RED + "3) " + ConsoleColors.RESET + "Position");
                System.out.println(ConsoleColors.RED + "4) " + ConsoleColors.RESET + "Username");
                System.out.println(ConsoleColors.RED + "5) " + ConsoleColors.RESET + "Password");
                System.out.println(ConsoleColors.RED + "6) " + ConsoleColors.RESET + "Contracted Hours");
                byte choice = Byte.parseByte(scanner.nextLine());
                switch (choice) {
                    case 1:
                        System.out.println("Please enter a new" + ConsoleColors.RED_BOLD + " forename" + ConsoleColors.RESET + " for user " + ConsoleColors.GREEN_BOLD + employees.getEID() + ConsoleColors.RESET);
                        String aForename = scanner.nextLine();
                        employees.setForename(aForename);
                        break;
                    case 2:
                        System.out.println("Please enter a new" + ConsoleColors.RED_BOLD + " surname" + ConsoleColors.RESET + " for user " + ConsoleColors.GREEN_BOLD + employees.getEID() + ConsoleColors.RESET);
                        String aSurname = scanner.nextLine();
                        employees.setSurname(aSurname);
                        break;
                    case 3:
                        System.out.println("Please enter a new" + ConsoleColors.RED_BOLD + " position" + ConsoleColors.RESET + " for user " + ConsoleColors.GREEN_BOLD + employees.getEID() + ConsoleColors.RESET);
                        String aPos = scanner.nextLine();
                        employees.setPosition(aPos);
                        break;
                    case 4:
                        System.out.println("Please enter a new" + ConsoleColors.RED_BOLD + " Username" + ConsoleColors.RESET + " for user " + ConsoleColors.GREEN_BOLD + employees.getEID() + ConsoleColors.RESET);
                        String aUsername = scanner.nextLine();
                        employees.setUsername(aUsername);
                        break;
                    case 5:
                        System.out.println("Please enter a new" + ConsoleColors.RED_BOLD + " Password" + ConsoleColors.RESET + " for user " + ConsoleColors.GREEN_BOLD + employees.getEID() + ConsoleColors.RESET);
                        String aPassword = scanner.nextLine();
                        employees.setPassword(aPassword);
                        break;
                    case 6:
                        System.out.println("Please enter the new " + ConsoleColors.RED_BOLD + " Contracted Hours" + ConsoleColors.RESET + "for user " + ConsoleColors.GREEN_BOLD + employees.getEID() + ConsoleColors.RESET);
                        float cHours = Float.parseFloat(scanner.nextLine());
                        employees.setContHours(cHours);
                        break;
                    default:
                        System.out.println("Please enter a" + ConsoleColors.RED_BOLD + "Valid Selection " + ConsoleColors.RED_BOLD + "or type" + ConsoleColors.RED_BOLD + " exit " + ConsoleColors.RESET + "to exit the selection screen.");
                        String aDInput = scanner.nextLine();
                        if (aDInput.equalsIgnoreCase("exit")) {
                            MainMenu mm = new MainMenu(e);
                        } else {
                            editEmployee();
                        }
                }
            }
        }
        System.out.println("Please Select an Option. Type " + ConsoleColors.GREEN_BOLD + "edit "+ ConsoleColors.RESET +"to edit more attributes" + ConsoleColors.RESET + " or type" + ConsoleColors.RED_BOLD + " exit " + ConsoleColors.RESET + "to exit to the main menu.");
        String choice = scanner.nextLine();
        if (choice.equalsIgnoreCase("edit")){
            editEmployee();
        }else if(choice.equalsIgnoreCase("exit")){
            MainMenu mm = new MainMenu(e);
        }else{
            System.exit(0);
        }

    }


    private void newPayment() {

    }

    private void holidayRequests() {

    }

    private void viewReports() {

    }

}
