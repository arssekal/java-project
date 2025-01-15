import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class ExpenseTracker {
    Scanner c = new Scanner(System.in);
    ArrayList<Expense> userExpenses = new ArrayList<>();
    public void addExpense(Expense e) {
        userExpenses.add(e);
        System.out.println("Expense added successfully");
    }
    public void updateExpense(int id) {
        if(id <= userExpenses.size()) {
            System.out.println("do you want to update description(yes = 1, no = 0): ");
            int choice = c.nextInt();
            c.nextDouble();
            if (choice == 1) {
                System.out.println("new description : ");
                String description = c.nextLine();
                userExpenses.get(id-1).setDescription(description);
            }
            System.out.println("do you want to update the amount(yes = 1, no = 0): ");
            choice = c.nextInt();
            if (choice == 1) {
                System.out.println("new amount : ");
                double amount = c.nextInt();
                userExpenses.get(id-1).setAmount(amount);
            }
        } else {
            System.out.println("this id does not exist");
        }
    }
    public void deleteExpense(int id) {

    }
    public void viewAllExpenses() {
        for(Expense e: userExpenses) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            System.out.printf("%-6d %-6s %-6.2f  %-6s\n", e.getId(), e.getDescription(), e.getAmount(), e.getDate().format(formatter));
        }
    }
    public void viewExpensesOfMonth() {

    }
}
