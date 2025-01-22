# Expense Tracker Application
## Description
The Expense Tracker Application is a command-line tool designed to help users manage their finances. Users can add, update, delete, and view expenses while also accessing summaries and tracking expenses for specific months.

## Features

### Core Functionality:
Add an expense with a description and amount.
Update an expense.
Delete an expense.
View all expenses.
View a summary of all expenses.
View a summary of expenses for a specific month (of the current year).

### Additional Features:
Add expense categories and filter expenses by category.
Set a monthly budget and receive warnings if the budget is exceeded.
Export expenses to a CSV file.
## How to Use
### Clone the repository:
git clone https://github.com/username/expense-tracker.git
### Navigate to the project directory:
cd expense-tracker
VCompile the code:
javac -d bin src/*.java
Run the application:
java -cp bin App
## Example Usage
-------------------------    Menu    ------------------------------
1. add an expense
2. update an expense
3. delete an expense
4. view all expenses
5. view expenses of a category
6. view expenses of a month
7. view the summary
8. exit
--------------------------------------------------------------------
enter your choice: 1
expense description: dinner
expense amount: 25
expense category: meal
Expense added successfully
-------------------------    Menu    ------------------------------
1. add an expense
2. update an expense
3. delete an expense
4. view all expenses
5. view expenses of a category
6. view expenses of a month
7. view the summary
8. exit
--------------------------------------------------------------------
enter your choice: 4
--------------------------------------------------------------------
id    description     amount      date                 category     
--------------------------------------------------------------------
1     fooot           DH 99.0        2025-01-17           exercise  
2     lunch           DH 25.0        2025-02-17           meal      
3     lunch           DH 30.0        2025-03-17           meal      
4     bascket         DH 76.0        2025-01-20           exercise  
5     breakfast       DH 15.0        2025-02-20           meal      
6     gym             DH 50.0        2025-03-20           fitness   
21    dinner          DH 25.0        2025-01-22           meal
--------------------------------------------------------------------
total:                           DH 807,00
--------------------------------------------------------------------
-------------------------    Menu    ------------------------------
1. add an expense
2. update an expense
3. delete an expense
4. view all expenses
5. view expenses of a category
6. view expenses of a month
7. view the summary
8. exit
--------------------------------------------------------------------
enter your choice: 5
expense category: meal
--------------------------------------------------------------------
id    description     amount      date                 category
--------------------------------------------------------------------
2     lunch            DH 25.0       2025-02-17           meal
3     lunch            DH 30.0       2025-03-17           meal
5     breakfast        DH 15.0       2025-02-20           meal
21    dinner           DH 25.0       2025-01-22           meal
--------------------------------------------------------------------
total of this category:                                  222,00 DH
--------------------------------------------------------------------
-------------------------    Menu    ------------------------------
1. add an expense
2. update an expense
3. delete an expense
4. view all expenses
5. view expenses of a category
6. view expenses of a month
7. view the summary
8. exit
--------------------------------------------------------------------
enter your choice: 8
see you next time <3
--------------------------------------------------------------------
# Contributing
Contributions are welcome! Feel free to open issues or submit pull requests.

For questions or feedback, please contact arssekall@gmail.com.
