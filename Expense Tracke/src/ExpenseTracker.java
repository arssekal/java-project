import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class ExpenseTracker {
    Scanner c = new Scanner(System.in);
    // ArrayList<Expense> userExpenses = new ArrayList<>();
    public void addExpense(Expense e) {
        // userExpenses.add(e);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("expense.csv", true))) {
            String[] line = new String[4];
            line[0] = String.valueOf(e.getId());
            line[1] = String.valueOf(e.getDescription());
            line[2] = String.valueOf(e.getAmount());
            line[3] = String.valueOf(e.getDate());
            String lineContent = String.join(",", line);
            writer.write(lineContent);
            writer.newLine();
            writer.close();
        } catch (Exception exp) {
            // do something
        }
        System.out.println("Expense added successfully");
    }
    public void updateExpense(int id) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("expense.csv"));
            String line;
            ArrayList<String> lines = new ArrayList<>();
            int i = 0;
            while((line = reader.readLine()) != null) {
                lines.add(line);
                i++;
            }
            reader.close();
            if(id <= i) {
                String[] update = new String[4]; // this will contain the information of the new updated line
                String lineToUpdate = lines.get(id-1);
                update = lineToUpdate.split(",");
                System.out.print("do you want to update description(yes = 1, no = 0): ");
                int choice = c.nextInt();
                c.nextLine();
                update[0] = String.valueOf(id);
                if (choice == 1) {
                    System.out.print("new description : ");
                    String description = c.nextLine();
                    // userExpenses.get(id-1).setDescription(description);
                    update[1] = description;
                    System.out.println("the description is updated succesfully");
                }
                System.out.print("do you want to update the amount(yes = 1, no = 0): ");
                choice = c.nextInt();
                c.nextLine();
                if (choice == 1) {
                    System.out.print("new amount : ");
                    double amount = c.nextInt();
                    update[2] = String.valueOf(amount);
                    System.out.println("the amount is updated succesfully");
                }
                for(int j = 0; j < lines.size(); j++) {
                    if(j == id -1) {
                        lines.set(j, String.join(",",update));
                    }
                }
            } else {
                System.out.println("this id does not exist");
            }
            reader.close();
            try {
                FileWriter writer = new FileWriter("expense.csv");
                writer.write("");
                for(String ligne: lines) {
                    writer.append(ligne+ "\n");
                }
                writer.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    public void deleteExpense(int id) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("expense.csv"));
            String line;
            int i = 0;
            ArrayList<String> lines = new ArrayList<>();
            while((line = reader.readLine()) != null) {
                lines.add(line);
                i++;
            }
            // test
            for(String s: lines) {
                System.out.println(s);
            }
            reader.close();
            if(id <= i) {
                if(id == i) {
                    lines.remove(id-1);
                } else {
                    String[] ligne = new String[4]; 
                    for(int j = id-1; j < lines.size(); j++) {
                        // here we update the id's
                        lines.remove(id-1);
                        ligne = lines.get(j).split(",");
                        ligne[0] = String.valueOf(j+1);
                        lines.set(j, String.join(",", ligne));
                    }
                }
                // test
                for(String s: lines) {
                    System.out.println(s);
                }
                try {
                    FileWriter writer = new FileWriter("expense.csv");
                    writer.write("");
                    for(String ligne: lines) {
                        writer.append(ligne+ "\n");
                    }
                    writer.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println("the expense is deleted succesfully");
            } else {
                System.out.println("this is does not exist!");
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void viewAllExpenses() {
        System.out.println("---------------------------------------------");
        System.out.printf("%-5s %-15s %-10s  %-10s\n","id","description","amount","date");
        System.out.println("---------------------------------------------");
        // for(Expense e: userExpenses) {
        //     DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        //     System.out.printf("%-5d %-15s $%-10.2f  %-10s\n", e.getId(), e.getDescription(), e.getAmount(), e.getDate().format(formatter));
        // }
    }
    public void viewExpensesOfMonth() {

    }
}
