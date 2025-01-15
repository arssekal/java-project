import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        
    }
    private static int menu() {
        Scanner c = new Scanner(System.in);
        System.out.println("1. add an expense");
        System.out.println("2. update an expense");
        System.out.println("3. delete an expense");
        System.out.println("4. view all expenses");
        System.out.println("5. exit");
        System.out.println("enter your choice: ");
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
