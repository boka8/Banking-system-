import java.util.Date;

public class Budget {
    int budgetID;
    int userID;
    String category;
    double amount;
    Date startDate;
    Date endDate;

    public Budget(int budgetID, int userID, String category, double amount, Date startDate, Date endDate) {
        this.budgetID = budgetID;
        this.userID = userID;
        this.category = category;
        this.amount = amount;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}