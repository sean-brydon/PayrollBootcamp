import com.sun.tools.javac.Main;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class Admin {

    Employees e; // logged in
    int aChoice;
    Scanner scanner = new Scanner(System.in);

    public Admin(Employees e, int aChoice) throws ParseException {
        this.e = e;
        this.aChoice = aChoice;
        adminChoice(e, aChoice);
    }


    private void adminChoice(Employees e, int aChoice) throws ParseException {
        switch (aChoice) {
            case 1:
                newEmployee();
                break;
            case 2:
                viewEmployee(e);
                break;
            case 3:
                newPayment(e);
                break;
            case 4:
                viewPayments(e);
                break;
            case 5:
                editEmployee(e);
                break;
            case 6:
                holidayRequests(e);
                break;
            case 7:
                viewReports();
                break;
            default:
                MainMenu mm = new MainMenu(e);
        }
    }

    private void newEmployee() throws ParseException {
        int EID = Login.employees.size() + 1;
        System.out.println(ConsoleColors.RED + ">>" + ConsoleColors.RESET + "Please Enter the Employees Forname");
        String fn = scanner.nextLine();
        System.out.println(ConsoleColors.RED + ">>" + ConsoleColors.RESET + "Please Enter the Employees Surname");
        String sn = scanner.nextLine();
        String pos = posMenu();
        System.out.println(ConsoleColors.RED + ">>" + ConsoleColors.RESET + "Please Enter the Employees Username");
        String username = scanner.nextLine();
        System.out.println(ConsoleColors.RED + ">>" + ConsoleColors.RESET + "Please Enter the Employees Password");
        String password = scanner.nextLine();
        System.out.println(ConsoleColors.RED + ">>" + ConsoleColors.RESET + "Please Enter the Employees Contracted Hours");
        float cHours = Float.parseFloat(scanner.nextLine());
        Login.employees.add(new Employees(Login.employees.size() + 1, fn, sn, pos, username, password, cHours, false));
        returnMenu(e);


    }

    private void viewEmployee(Employees e) throws ParseException {
        int count = 0;
        for (Employees employees : Login.employees) {
            System.out.println(ConsoleColors.RED_BOLD + "---------" + ConsoleColors.GREEN_BOLD + "User " + employees.getEID() + ConsoleColors.RED_BOLD + "-------------" + ConsoleColors.RESET);
            System.out.println("Forname: " + employees.getForename() + "\nSurname: " + employees.getSurname() + "\nPosition: " +
                    "" + employees.getPosition() + "\nUsername: " + employees.getUsername() + "\nPassword: " + employees.getPassword() + "" +
                    "\nContracted Hours: " + employees.getContHours());


        }
        System.out.println("Press " + ConsoleColors.RED_BOLD + "RETURN " + ConsoleColors.RESET + "to go back to the Admin Menu.");
        String anyKey = scanner.nextLine();
        switch (anyKey) {
            default:
                MainMenu mm = new MainMenu(e);
        }
    }

    private void viewPayments(Employees e) throws ParseException {
        System.out.println("Would you like to see all payments or search by " + ConsoleColors.RED_BOLD + "EID" + ConsoleColors.RESET);
        System.out.println(ConsoleColors.RED_BOLD + "1)" + ConsoleColors.RESET + " All");
        System.out.println(ConsoleColors.RED_BOLD + "2)" + ConsoleColors.RESET + " EID");
        byte choice = Byte.parseByte(scanner.nextLine());
        switch (choice) {
            case 1:
                for (Payments p : Login.payments) {
                    System.out.println(ConsoleColors.RED_BOLD + "---------" + ConsoleColors.GREEN_BOLD + "User " + p.getEID() + ConsoleColors.RED_BOLD + "-------------" + ConsoleColors.RESET);
                    System.out.println("EID: " + p.getEID() + "\nDate: " + p.getDatePayment() + "\nNet Pay: " +
                            "" + p.getNetPay() + "\nGross Pay: " + p.getGrossValue());
                }

            case 2:
                System.out.println("Please Enter the " + ConsoleColors.RED_BOLD + "EID" + ConsoleColors.RESET + " you would like to find\n" +
                        "Or type " + ConsoleColors.RED_BOLD + "EXIT " + ConsoleColors.RESET + "to return to main menu");
                String eChoice = scanner.nextLine();
                if (eChoice.equalsIgnoreCase("exit")) {
                    MainMenu mm = new MainMenu(e);
                } else {
                    for (Payments p : Login.payments) {
                        if (Integer.parseInt(eChoice) == p.getEID()) {
                            System.out.println(ConsoleColors.RED_BOLD + "---------" + ConsoleColors.GREEN_BOLD + "User " + p.getEID() + ConsoleColors.RED_BOLD + "-------------" + ConsoleColors.RESET);
                            System.out.println("EID: " + p.getEID() + "\nDate: " + p.getDatePayment() + "\nNet Pay: " +
                                    "" + p.getNetPay() + "\nGross Pay: " + p.getGrossValue());
                        }
                        break;
                    }
                }
                returnMenu(e);

        }

    }


    private void editEmployee(Employees e) throws ParseException {
        System.out.println(ConsoleColors.RED_BOLD + "---------" + ConsoleColors.GREEN_BOLD + "Edit Employee Mode " + ConsoleColors.RED_BOLD + "-------------" + ConsoleColors.RESET);
        System.out.println("Please Enter the " + ConsoleColors.GREEN_BOLD + "EID" + ConsoleColors.RESET + " of the user you would like to edit.");
        int editEID = Integer.parseInt(scanner.nextLine());
        for (Employees employees : Login.employees) {
            if (employees.getEID() == e.getEID()) {
                System.out.println(ConsoleColors.RED_BOLD + "You cannot edit your own details" + ConsoleColors.RESET);

            } else if (employees.getEID() == editEID) {
                System.out.println("You are now editing " + ConsoleColors.GREEN_BOLD + employees.getForename() + " " + employees.getSurname() + ConsoleColors.RESET + " information");
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
                        employees.setPosition(posMenu());
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
                            editEmployee(e);
                        }
                }
            }
        }
        System.out.println("Please Select an Option. Type " + ConsoleColors.GREEN_BOLD + "edit " + ConsoleColors.RESET + "to edit more attributes" + ConsoleColors.RESET + " or type" + ConsoleColors.RED_BOLD + " exit " + ConsoleColors.RESET + "to exit to the main menu.");
        String choice = scanner.nextLine();
        if (choice.equalsIgnoreCase("edit")) {
            editEmployee(e);
        } else if (choice.equalsIgnoreCase("exit")) {
            MainMenu mm = new MainMenu(e);
        } else {
            System.exit(0);
        }

    }

    private String posMenu() {
        System.out.println("Please enter a " + ConsoleColors.RED_BOLD + " position" + ConsoleColors.RESET + " for user " + ConsoleColors.RESET);
        String[] positions = new String[]{"HR", "MD", "Developer", "Admin", "Cleaner", "Apprentice"};
        System.out.println(ConsoleColors.RED + "1) " + ConsoleColors.RESET + "HR");
        System.out.println(ConsoleColors.RED + "2) " + ConsoleColors.RESET + "MD");
        System.out.println(ConsoleColors.RED + "3) " + ConsoleColors.RESET + "Developer");
        System.out.println(ConsoleColors.RED + "4) " + ConsoleColors.RESET + "Admin");
        System.out.println(ConsoleColors.RED + "5) " + ConsoleColors.RESET + "Cleaner");
        System.out.println(ConsoleColors.RED + "6) " + ConsoleColors.RESET + "Apprentice");
        Byte choice = Byte.parseByte(scanner.nextLine());
        choice--;
        if (choice <= 5) {
            String aPos = positions[choice];
            return aPos;
        } else {
            System.out.println("Please enter a" + ConsoleColors.RED_BOLD + "Valid" + ConsoleColors.RESET + "Selection");
            posMenu();
        }

        return null;
    }


    private void newPayment(Employees e) throws ParseException {
        int PID = Login.payments.size() + 1;
        System.out.println(ConsoleColors.RED + ">>" + ConsoleColors.RESET + "Please Enter the EID");
        int nEID = Integer.parseInt(scanner.nextLine());
        if (nEID == e.getEID()) {
            System.out.println(ConsoleColors.RED_BOLD + "You cannot create a new payment for yourself");
            returnMenu(e);


        } else {
            System.out.println(ConsoleColors.RED + ">>" + ConsoleColors.RESET + "Please Enter the Date dd/MM/yyyy");
            String date = scanner.nextLine();
            Login.payments.add(new Payments(nEID, Init.createDate(date), PID));
            returnMenu(e);
        }
    }

    private void holidayRequests(Employees e) throws ParseException {
        System.out.println(ConsoleColors.RED + "1) " + ConsoleColors.RESET + "View Accepted");
        System.out.println(ConsoleColors.RED + "2) " + ConsoleColors.RESET + "View Denied");
        System.out.println(ConsoleColors.RED + "3) " + ConsoleColors.RESET + "View Pending");
        int hChoice = Integer.parseInt(scanner.nextLine());
        switch (hChoice) {
            case 1:
            case 2:
            case 3:
                for (Holidays holidays : Login.holidays) {
                    if (holidays.getStatus().equalsIgnoreCase("accepted") && hChoice == 1) {
                        for (Employees employees : Login.employees) {
                            if (holidays.getEID() == employees.getEID()) {
                                System.out.println(ConsoleColors.RED_BOLD + "---------" + ConsoleColors.GREEN_BOLD + "EID " + holidays.getEID() + ConsoleColors.RED_BOLD + "-------------" + ConsoleColors.RESET);
                                System.out.println("You are viewing the" + ConsoleColors.GREEN_BOLD + " Accepted " + ConsoleColors.RESET + "holidays for the user " + ConsoleColors.GREEN_BOLD + employees.getForename() + " " + employees.getSurname()+ ConsoleColors.RESET);
                                System.out.println("Start Date : " + ConsoleColors.GREEN_BOLD + holidays.getStartDate() + ConsoleColors.RESET + "\nEnd Date: " + ConsoleColors.RED_BOLD + holidays.getEndDate() + ConsoleColors.RESET + "\nHoliday ID: " + ConsoleColors.PURPLE_BOLD + holidays.getHID() + ConsoleColors.RESET);
                            }
                        }
                    } else if (holidays.getStatus().equalsIgnoreCase("denied") && hChoice == 2) {
                        for (Employees employees : Login.employees) {
                            if (holidays.getEID() == employees.getEID()) {
                                System.out.println(ConsoleColors.RED_BOLD + "---------" + ConsoleColors.GREEN_BOLD + "EID " + holidays.getEID() + ConsoleColors.RED_BOLD + "-------------" + ConsoleColors.RESET);
                                System.out.println("You are viewing the" + ConsoleColors.RED_BOLD + " Denied " + ConsoleColors.RESET + "holidays for the user " + ConsoleColors.GREEN_BOLD + employees.getForename() + " " + employees.getSurname()+ ConsoleColors.RESET);
                                System.out.println("Start Date : " + ConsoleColors.GREEN_BOLD + holidays.getStartDate() + ConsoleColors.RESET + "\nEnd Date: " + ConsoleColors.RED_BOLD + holidays.getEndDate() + ConsoleColors.RESET + "\nHoliday ID: " + ConsoleColors.PURPLE_BOLD + holidays.getHID() + ConsoleColors.RESET);
                            }
                        }
                    } else if (holidays.getStatus().equalsIgnoreCase("Pending") && hChoice == 3) {
                        for (Employees employees : Login.employees) {
                            if (holidays.getEID() == employees.getEID()) {
                                System.out.println(ConsoleColors.RED_BOLD + "---------" + ConsoleColors.GREEN_BOLD + "EID " + holidays.getEID() + ConsoleColors.RED_BOLD + "-------------" + ConsoleColors.RESET);
                                System.out.println("You are viewing the" + ConsoleColors.YELLOW_BOLD + " Pending " + ConsoleColors.RESET + "holidays for the user " + ConsoleColors.GREEN_BOLD + employees.getForename() + " " + employees.getSurname()+ ConsoleColors.RESET);
                                System.out.println("Start Date : " + ConsoleColors.GREEN_BOLD + holidays.getStartDate() + ConsoleColors.RESET + "\nEnd Date: " + ConsoleColors.RED_BOLD + holidays.getEndDate() + ConsoleColors.RESET + "\nHoliday ID: " + ConsoleColors.PURPLE_BOLD + holidays.getHID() + ConsoleColors.RESET);

                            }
                        }
                    }
                }
                returnMenu(e);

            default:
                System.out.println(ConsoleColors.RED_BOLD + "Please enter a Correct Option" + ConsoleColors.RESET);
                holidayRequests(e);
        }
        System.out.println("Would you like to " + ConsoleColors.GREEN_BOLD + "edit " + ConsoleColors.RESET + "or " + ConsoleColors.RED_BOLD + "delete " + ConsoleColors.RESET + "a holiday?");
        String hEditChoice = scanner.nextLine();
        if (hEditChoice.equalsIgnoreCase("edit")) {
            System.out.println("Please enter the" + ConsoleColors.RED_BOLD + "HID " + ConsoleColors.RESET + "you would like to edit");
            int eHID = Integer.parseInt(scanner.nextLine());
            for (Holidays holidays : Login.holidays) {
                if (holidays.getHID() == eHID) {
                    String[] status = new String[]{"Accepted", "Denied", "Pending"};
                    System.out.println("Please select an option");
                    System.out.println(ConsoleColors.RED + "1) " + ConsoleColors.RESET + "Status: " + ConsoleColors.GREEN_BOLD + "Accepted");
                    System.out.println(ConsoleColors.RED + "2) " + ConsoleColors.RESET + "Status: " + ConsoleColors.RED_BOLD + " Denied");
                    System.out.println(ConsoleColors.RED + "3) " + ConsoleColors.RESET + "Status: " + ConsoleColors.YELLOW_BOLD + " Pending");
                    int statusInput = Integer.parseInt(scanner.nextLine());
                    holidays.setStatus(status[statusInput - 1]);
                    System.out.println("Setting Status of " + ConsoleColors.GREEN_BOLD + "HID: " + holidays.getHID() + ConsoleColors.RESET + "to" + status[statusInput - 1]);
                    break;
                }
            }
            returnMenu(e);

        }
    }

    private void viewReports() {

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
