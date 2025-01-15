import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDate;
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
                Expense e = new Expense(description, amount);
                tracker.addExpense(e);
                userChoice = menu();
            } 
            // update an expense.
            else if (userChoice == 2) {
                System.out.println("enter the id of the expense: ");
                int id = scan.nextInt();
                scan.nextLine();
                tracker.updateExpense(id);
                userChoice = menu();
            }
            // delete an expense.
            else if (userChoice == 3) {
                userChoice = menu();
            }
            // view all expenses.
            else if (userChoice == 4) {
                tracker.viewAllExpenses();
                userChoice = menu();
            }
            // view a summary of all expenses.
            else if (userChoice == 5) {
                userChoice = menu();
            }
            else if (userChoice == 6) {
                System.out.println("see you next time😁");
                exit = true;
            }
        } 
    }
    private static int menu() {
        Scanner c = new Scanner(System.in);
        System.out.println("-----------------------------------");
        System.out.println("1. add an expense");
        System.out.println("2. update an expense");
        System.out.println("3. delete an expense");
        System.out.println("4. view all expenses");
        System.out.println("5. view a summary of all expenses");
        System.out.println("6. exit");
        System.out.println("-----------------------------------");
        System.out.print("enter your choice: ");
        return c.nextInt();
    }
    private static int view() {
        Scanner c = new Scanner(System.in);
        System.out.println("1. view a summary of all expenses");
        System.out.println("1. view a summary of all expenses for a specific month");
        System.out.println("3. exit");
        System.out.println("enter your choice: ");
        return c.nextInt();
    }
}
