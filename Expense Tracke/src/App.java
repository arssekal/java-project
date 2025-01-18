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
                System.out.print("expense amount: ");
                double amount = scan.nextDouble();
                scan.nextLine(); 
                System.out.print("expense category: ");
                String category = scan.nextLine();
                Expense e = new Expense(description, amount, category);
                tracker.addExpense(e);
                userChoice = menu();
            } 
            // update an expense.
            else if (userChoice == 2) {
                System.out.print("enter the id of the expense: ");
                int id = scan.nextInt();
                scan.nextLine();
                tracker.updateExpense(id);
                userChoice = menu();
            }
            // delete an expense.
            else if (userChoice == 3) {
                System.out.print("enter the id of the expense: ");
                int id = scan.nextInt();
                scan.nextLine();
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
                String month = scan.nextLine();
                if(month.length() == 1) {
                    month = "0"+month;
                }
                tracker.viewMonthlyExpense(month);
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
                        System.out.println("total summary expense of "+ category+" category is: "+tracker.categoryExpense(category));
                        choice = viewMenu();
                    }
                    else if(choice == 3) {  
                        System.out.print("enter a month: ");
                        String month = scan.nextLine();
                        System.out.println("total summary expense of the month "+ month + " is: "+tracker.monthExpense(month));
                        choice = viewMenu();
                    }
                    else {
                        System.out.println("exiting the view menu");
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
        System.out.print("enter your choice: ");
        String choice;
        int choix;
        try {
            choice = c.nextLine();
            choix = Integer.valueOf(choice);
        } catch (Exception InputMismatchException ) {
            System.out.println("please enter a number: ");
        }
        while (true) {
            break;
        }
        return choix;
    }
    private static int viewMenu() {
        Scanner c = new Scanner(System.in);
        System.out.println("----------------------- summary menu -------------------------------");
        System.out.println("1. view a summary of all expenses");
        System.out.println("2. view a summary of all expenses for a specific category");
        System.out.println("3. view a summary of all expenses for a specific month");
        System.out.println("4. exit");
        System.out.println("--------------------------------------------------------------------");
        System.out.print("enter your choice: ");
        return c.nextInt();
    }
}
