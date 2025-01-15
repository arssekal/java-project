import java.time.LocalDate;

public class Expense {
    static int autoIncrementId = 0;
    private int id;
    private String description;
    private double amount;
    private LocalDate date;

    Expense(String desc, double amount) {
        this.description = desc;
        this.amount = amount;
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
}
