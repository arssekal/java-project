import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class ExpenseTracker {
    Scanner c = new Scanner(System.in);

    public void addExpense(Expense e) {
        // userExpenses.add(e);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("expense.csv", true))) {
            String[] line = new String[5];
            line[0] = String.valueOf(e.getId());
            line[1] = e.getDescription();
            line[2] = String.valueOf(e.getAmount());
            line[3] = String.valueOf(e.getDate());
            line[4] = e.getCategory();
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
                System.out.print("Update description? (yes = 1, no = 0): ");
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
                System.out.print("Update amount? (yes = 1, no = 0): ");
                choice = c.nextInt();
                c.nextLine();
                if (choice == 1) {
                    System.out.print("new amount : ");
                    double amount = c.nextInt();
                    update[2] = String.valueOf(amount);
                    System.out.println("the amount is updated succesfully");
                }
                System.out.print("Update category? (yes = 1, no = 0): ");
                choice = c.nextInt();
                c.nextLine();
                if (choice == 1) {
                    System.out.print("new category : ");
                    String category = c.nextLine();
                    update[4] = category;
                    System.out.println("the category is updated succesfully");
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
            reader.close();
            if(id <= i) {
                lines.remove(id-1);
                String[] ligne = new String[5]; 
                for(int j = id-1; j < lines.size(); j++) {
                    // here we update the id's
                    ligne = lines.get(j).split(",");
                    ligne[0] = String.valueOf(j+1);
                    lines.set(j, String.join(",", ligne));
                }
                try {
                    FileWriter writer = new FileWriter("expense.csv");
                    writer.write("");
                    for(String uneLigne: lines) {
                        writer.append(uneLigne+ "\n");
                    }
                    writer.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println("the expense is deleted succesfully");
            } else {
                System.out.println("this id does not exist!");
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void viewAllExpenses() {
        System.out.println("--------------------------------------------------------------------");
        System.out.printf("%-5s %-15s %-10s  %-20s %-10s\n","id","description","amount","date", "category");
        System.out.println("--------------------------------------------------------------------");
        try {
            BufferedReader reader = new BufferedReader(new FileReader("expense.csv"));
            String line;
            String[] infos = new String[5];
            while((line = reader.readLine()) != null) {
                infos = line.split(",");
                System.out.printf("%-5s %-15s DH %-10s  %-20s %-10s\n", infos[0], infos[1], infos[2], infos[3], infos[4]);
            }
            System.out.println("--------------------------------------------------------------------");
            System.out.printf("total: \t\t\t\t DH %.2f\n",totalExpense());
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void viewExpensesByCategory(String category) {
        System.out.println("--------------------------------------------------------------------");
        System.out.printf("%-5s %-15s %-10s  %-20s %-10s\n","id","description","amount","date", "category");
        System.out.println("--------------------------------------------------------------------");
        try {
            BufferedReader reader = new BufferedReader(new FileReader("expense.csv"));
            String line;
            String[] infos = new String[5];
            while((line = reader.readLine()) != null) {
                infos = line.split(",");
                if(infos[4].equalsIgnoreCase(category)) {
                    System.out.printf("%-5s %-15s  DH %-10s %-20s %-10s\n", infos[0], infos[1], infos[2], infos[3], infos[4]);
                }
            }
            System.out.println("--------------------------------------------------------------------");
            System.out.printf("total of this category: \t\t\t\t %.2f DH\n",categoryExpense(category));
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public double categoryExpense(String category) {
        Double total = 0.0;
        try {
            BufferedReader reader = new BufferedReader(new FileReader("expense.csv"));
            String line;
            String[] infos = new String[5];
            while((line = reader.readLine()) != null) {
                infos = line.split(",");
                if(infos[4].equalsIgnoreCase(category)) {
                    total += Double.valueOf(infos[2]);
                }
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return total;
    }
    
    public double totalExpense() {
        Double total = 0.0;
        try {
            BufferedReader reader = new BufferedReader(new FileReader("expense.csv"));
            String line;
            String[] infos = new String[5];
            while((line = reader.readLine()) != null) {
                infos = line.split(",");
                total += Double.valueOf(infos[2]);
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return total;
    }
    
    public void viewMonthlyExpense(String month) {
        System.out.println("--------------------------------------------------------------------");
        System.out.printf("%-5s %-15s %-10s  %-20s %-10s\n","id","description","amount","date", "category");
        System.out.println("--------------------------------------------------------------------");
        try {
            BufferedReader reader = new BufferedReader(new FileReader("expense.csv"));
            String line;
            String[] infos = new String[5];
            while((line = reader.readLine()) != null) {
                infos = line.split(",");
                String[] laDate = new String[3];
                laDate = infos[3].split("-");
                if(laDate[1].equals(month)) {
                    System.out.printf("%-5s %-15s DH %-10s  %-20s %-10s\n", infos[0], infos[1], infos[2], infos[3], infos[4]);
                }
            }
            System.out.println("--------------------------------------------------------------------");
            System.out.printf("total of this month: \t\t\t\t %.2f DH\n", monthExpense(month));
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public double monthExpense(String month) {
        Double total = 0.0;
        try {
            BufferedReader reader = new BufferedReader(new FileReader("expense.csv"));
            String line;
            String[] infos = new String[5];
            while((line = reader.readLine()) != null) {
                infos = line.split(",");
                String[] laDate = new String[3];
                laDate = infos[3].split("-");
                if(laDate[1].equals(month)) {
                    total += Double.valueOf(infos[2]);
                }
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return total;
    }
}
