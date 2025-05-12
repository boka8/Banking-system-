import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        UserManager userManager = new UserManager();
        Scanner scanner = new Scanner(System.in);
        AssetManager assetManager = new AssetManager();

        // Dummy data for demonstration
        List<Transaction> transactions = new ArrayList<>();
        List<Budget> budgets = new ArrayList<>();
        // You can add logic to add transactions/budgets as needed

        while (true) {
            // Show login/signup menu until user is signed in
            while (userManager.getCurrentUser() == null) {
                System.out.println("1. Sign Up");
                System.out.println("2. Sign In");
                System.out.println("3. Exit");
                System.out.print("Choose an option: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // consume newline

                if (choice == 1) {
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter email: ");
                    String email = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String password = scanner.nextLine();
                    userManager.signUp(name, email, password);
                } else if (choice == 2) {
                    System.out.print("Enter email: ");
                    String email = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String password = scanner.nextLine();
                    userManager.signIn(email, password);
                } else if (choice == 3) {
                    System.out.println("Goodbye!");
                    scanner.close();
                    return;
                } else {
                    System.out.println("Invalid option.");
                }
            }

            // Show asset management menu after sign in/up
            while (userManager.getCurrentUser() != null) {
                System.out.println("\nAsset Management Menu");
                System.out.println("1. Add Asset");
                System.out.println("2. Edit or Remove Asset");
                System.out.println("3. Sign Out");
                System.out.println("4. Get Report");
                System.out.print("Choose an option: ");
                int assetChoice = scanner.nextInt();
                scanner.nextLine(); // consume newline

                if (assetChoice == 1) {
                    assetManager.addAsset(userManager.getCurrentUser());
                } else if (assetChoice == 2) {
                    assetManager.editOrRemoveAsset(userManager.getCurrentUser());
                } else if (assetChoice == 3) {
                    userManager.signOut();
                    System.out.println("Signed out successfully.");
                } else if (assetChoice == 4) {
                    // --- GET REPORT LOGIC ---
                    try {
                        System.out.print("Enter start date (yyyy-mm-dd): ");
                        String start = scanner.nextLine();
                        System.out.print("Enter end date (yyyy-mm-dd): ");
                        String end = scanner.nextLine();
                        System.out.print("Enter report type (Summary/Detail): ");
                        String reportType = scanner.nextLine();

                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                        Date startDate = sdf.parse(start);
                        Date endDate = sdf.parse(end);

                        // Filter transactions for the current user and date range
                        int userID = userManager.getCurrentUser().getUserID();
                        List<Transaction> filtered = new ArrayList<>();
                        for (Transaction t : transactions) {
                            if (t.userID == userID && !t.date.before(startDate) && !t.date.after(endDate)) {
                                filtered.add(t);
                            }
                        }

                        // Generate report data
                        StringBuilder reportData = new StringBuilder();
                        for (Transaction t : filtered) {
                            reportData.append(String.format("%s: %s %.2f (%s)\n", sdf.format(t.date), t.category, t.amount, t.type));
                        }
                        if (reportData.length() == 0) reportData.append("No transactions found in this range.");

                        Report report = new Report(1, userID, reportType, start + " to " + end, reportData.toString());

                        // Display report
                        report.display();

                        // Export
                        System.out.print("Export as (PDF/Excel): ");
                        String format = scanner.nextLine();
                        report.exportReport(format);

                        System.out.println("Show 'Report Exported Successfully'");
                    } catch (Exception e) {
                        System.out.println("Invalid date format or error occurred.");
                    }
                } else {
                    System.out.println("Invalid option.");
                }
            }
        }
    }
}