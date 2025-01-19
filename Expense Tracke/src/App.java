import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        ExpenseTracker tracker = new ExpenseTracker();
        int userChoice = menu();
        boolean exit = false;
        while(!exit) {
            // add an expanse
            if(userChoice == 1) {
                System.out.print("expense description: ");
                String description = scan.nextLine();
                // exception handling
                double amount = 0 ;
                boolean valid = false;
                do {
                    try {
                        System.out.print("expense amount: ");
                        amount = scan.nextDouble();
                        scan.nextLine();
                        valid = true;
                    } catch (InputMismatchException e) {
                        scan.next(); // this to read the \n to avoid infinite loop
                        System.out.println("the amount should be a number.");
                    }
                } while(!valid);
                System.out.print("expense category: ");
                String category = scan.nextLine();
                Expense e = new Expense(description, amount, category);
                tracker.addExpense(e);
                userChoice = menu();
            } 
            // update an expense.
            else if (userChoice == 2) {
                // exception handling
                int id = 0 ;
                boolean valid = false;
                do {
                    try {
                        System.out.print("enter the id of the expense: ");
                        id = scan.nextInt();
                        scan.nextLine();
                        if(id > 0) {
                            valid = true;
                        } else {
                            System.out.println("the id should be > 0.");
                        }
                    } catch (InputMismatchException e) {
                        scan.next(); // this to read the \n to avoid infinite loop
                        System.out.println("the id should be a number.");
                    }
                } while(!valid); 
                tracker.updateExpense(id);
                userChoice = menu();
            }
            // delete an expense.
            else if (userChoice == 3) {
                System.out.print("enter the id of the expense: ");
                // exception handling
                int id = 0 ;
                boolean valid = false;
                do {
                    try {
                        System.out.print("expense amount: ");
                        id = scan.nextInt();
                        scan.nextLine();
                        if(id > 0) {
                            valid = true;
                        } else {
                            System.out.println("the id should be > 0.");
                        }
                    } catch (InputMismatchException e) {
                        scan.next(); // this to read the \n to avoid infinite loop
                        System.out.println("the id should be a number.");
                    }
                } while(!valid);
                tracker.deleteExpense(id);
                userChoice = menu();
            }
            // view all expenses.
            else if (userChoice == 4) {
                tracker.viewAllExpenses();
                userChoice = menu();
            }
            // view an expenses of a specific category
            else if (userChoice == 5) {
                System.out.print("expense category: ");
                String category = scan.nextLine();
                tracker.viewExpensesByCategory(category);
                userChoice = menu();
            }
            // view an expenses of a specific month
            else if (userChoice == 6) {
                System.out.print("enter a month: ");
                // this need iprovement the user should pass an integer between 1 and 12
                int month = 0;
                boolean valid = false;
                do {
                    try {
                        System.out.print("enter a month (number): ");
                        month = scan.nextInt();
                        scan.nextLine();
                        if(month >= 1 && month <= 12) {
                            valid = true;
                        } else {
                            System.out.println("a month is between 1 et 12");
                        }
                    } catch (InputMismatchException ime) {
                        scan.next();
                        System.out.println("error, please enter a number.");
                    }
                } while (!valid);
                String strMonth = String.valueOf(month);
                if(strMonth.length() == 1) {
                    strMonth = "0"+strMonth;
                }
                tracker.viewMonthlyExpense(strMonth);
                userChoice = menu();
            }
            // view samary
            else if (userChoice == 7) {
                int choice = viewMenu();
                boolean exit2 = false;
                while(!exit2) {
                    if(choice == 1) {
                        System.out.println("total summary expense: "+tracker.totalExpense());
                        choice = viewMenu();
                    } else if(choice == 2) {  
                        System.out.print("enter the category: ");
                        String category = scan.nextLine();
                        System.out.println("--------------------------------------------------------------------");
                        System.out.println("total summary expense of "+ category+" category is: "+tracker.categoryExpense(category));
                        choice = viewMenu();
                    }
                    else if(choice == 3) {  
                        int month = 0;
                        boolean valid = false;
                        do {
                            try {
                                System.out.print("enter a month (number): ");
                                month = scan.nextInt();
                                scan.nextLine();
                                if(month >= 1 && month <= 12) {
                                    valid = true;
                                } else {
                                    System.out.println("a month is between 1 et 12");
                                }
                            } catch (InputMismatchException ime) {
                                scan.next();
                                System.out.println("error, please enter a number.");
                            }
                        } while (!valid);
                        String strMonth = String.valueOf(month);
                        if(strMonth.length() == 1) {
                            strMonth = "0"+strMonth;
                        }
                        System.out.println("--------------------------------------------------------------------");
                        System.out.println("total summary expense of the month "+ month + " is: "+tracker.monthExpense(strMonth));
                        choice = viewMenu();
                    }
                    else {
                        System.out.println("exiting the summary menu");
                        exit2 = true;
                    }
                }
                userChoice = menu();
            }
            else {
                System.out.println("see you next time <3");
                scan.close();
                exit = true;
            }
        } 
    }
    private static int menu() {
        Scanner c = new Scanner(System.in);
        System.out.println("--------------------------------------------------------------------");
        System.out.println("1. add an expense");
        System.out.println("2. update an expense");
        System.out.println("3. delete an expense");
        System.out.println("4. view all expenses");
        System.out.println("5. view expenses of a category");
        System.out.println("6. view expenses of a month");
        System.out.println("7. view the summary");
        System.out.println("8. exit");
        System.out.println("--------------------------------------------------------------------");
        return validateInput(9);
    }
    private static int viewMenu() {
        System.out.println("----------------------- summary menu -------------------------------");
        System.out.println("1. view a summary of all expenses");
        System.out.println("2. view a summary of all expenses for a specific category");
        System.out.println("3. view a summary of all expenses for a specific month");
        System.out.println("4. exit");
        System.out.println("--------------------------------------------------------------------");
        System.out.print("enter your choice: ");
        return validateInput(4);
    }
    private static int validateInput(int max) {
        Scanner c = new Scanner(System.in);
        int choix = 0;
        boolean valid = false;
        do {
            try {
                System.out.print("enter your choice: ");
                choix = c.nextInt();

                if(choix >= 1 && choix <= max) {
                    valid = true;
                } else {
                    System.out.println("veuillez saisir un nombre entre 1 et "+max);
                }
            } catch (InputMismatchException ime) {
                c.next();
                System.out.println("error, please enter a number.");
            }
        } while (!valid);
        return choix;
    }
}
