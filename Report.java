public class Report {
    int reportID;
    int userID;
    String reportType;
    String dateRange;
    String data;

    public Report(int reportID, int userID, String reportType, String dateRange, String data) {
        this.reportID = reportID;
        this.userID = userID;
        this.reportType = reportType;
        this.dateRange = dateRange;
        this.data = data;
    }

    public void exportReport(String format) {
        if (format.equalsIgnoreCase("PDF") || format.equalsIgnoreCase("Excel")) {
            System.out.println("Report exported as " + format + " successfully!");
        } else {
            System.out.println("Invalid export format. Please select PDF or Excel.");
        }
    }

    public void display() {
        System.out.println("Report Type: " + reportType);
        System.out.println("Date Range: " + dateRange);
        System.out.println("Data:\n" + data);
    }
}