import java.util.Date;

public class Transaction {
    int transactionID;
    int userID;
    double amount;
    String category;
    Date date;
    String type;

    public Transaction(int transactionID, int userID, double amount, String category, Date date, String type) {
        this.transactionID = transactionID;
        this.userID = userID;
        this.amount = amount;
        this.category = category;
        this.date = date;
        this.type = type;
    }
}