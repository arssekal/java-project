import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDate;

public class Expense {
    static int autoIncrementId;
    private int id;
    private String description;
    private double amount;
    private LocalDate date;
    private String category;

    
    Expense(String desc, double amount, String category) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("expense.csv"));
            String line;
            int i = 0;
            while((line = reader.readLine()) != null) {
                i++;
            }
            autoIncrementId = i;
        }
        catch (Exception e) {
            // do something
        }
        setDescription(desc);
        setAmount(amount);
        setCategory(category);
        this.date = LocalDate.now();
        this.id = ++autoIncrementId;
    }
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public double getAmount() {
        return amount;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }
    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }
    public String getCategory() {
        return category;
    }
    
    public void setCategory(String category) {
        this.category = category;
    }
}
