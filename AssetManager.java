import java.util.*;

public class AssetManager {
    public void addAsset(User user) {
        if (user == null) {
            System.out.println("You must be signed in to add an asset.");
            return;
        }
        Scanner scanner = new Scanner(System.in);

        System.out.println("Select Asset Type:");
        System.out.println("1. Stocks");
        System.out.println("2. Real Estate");
        System.out.println("3. Crypto");
        System.out.println("4. Gold");
        System.out.print("Enter choice: ");
        String choiceStr = scanner.nextLine();

        String assetType = "";
        switch (choiceStr) {
            case "1": assetType = "Stocks"; break;
            case "2": assetType = "Real Estate"; break;
            case "3": assetType = "Crypto"; break;
            case "4": assetType = "Gold"; break;
            default: System.out.println("Invalid choice."); return;
        }

        System.out.print("Enter asset name (required): ");
        String name = scanner.nextLine();
        System.out.print("Enter asset amount/value (required): ");
        String amountStr = scanner.nextLine();

        if (name.isEmpty() || amountStr.isEmpty()) {
            System.out.println("Please fill in all required fields.");
            return;
        }

        float amount;
        try {
            amount = Float.parseFloat(amountStr);
        } catch (NumberFormatException e) {
            System.out.println("Invalid amount. Please enter a number.");
            return;
        }

        Asset asset = new Asset(assetType, name, amount);
        user.getAssets().add(asset);
        System.out.println("Asset added successfully!");
    }

    public void editOrRemoveAsset(User user) {
        if (user == null) {
            System.out.println("You must be signed in to edit or remove assets.");
            return;
        }
        List<Asset> assets = user.getAssets();
        Scanner scanner = new Scanner(System.in);

        if (assets.isEmpty()) {
            System.out.println("No assets found.");
            return;
        }

        System.out.println("Assets:");
        for (int i = 0; i < assets.size(); i++) {
            Asset asset = assets.get(i);
            System.out.println((i + 1) + ". " + asset.getType() + " - " + asset.getName() + " - " + asset.getAmount());
        }

        System.out.print("Select asset number to edit/remove: ");
        int index = scanner.nextInt() - 1;
        scanner.nextLine(); // consume newline

        if (index < 0 || index >= assets.size()) {
            System.out.println("Invalid selection.");
            return;
        }

        System.out.println("1. Edit Asset");
        System.out.println("2. Remove Asset");
        System.out.print("Choose an option: ");
        int action = scanner.nextInt();
        scanner.nextLine(); // consume newline

        if (action == 1) {
            Asset asset = assets.get(index);
            System.out.print("Enter new asset name (leave blank to keep current): ");
            String newName = scanner.nextLine();
            System.out.print("Enter new asset amount (leave blank to keep current): ");
            String newAmountStr = scanner.nextLine();

            if (!newName.isEmpty()) asset.setName(newName);
            if (!newAmountStr.isEmpty()) {
                try {
                    float newAmount = Float.parseFloat(newAmountStr);
                    asset.setAmount(newAmount);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid amount. Keeping previous value.");
                }
            }
            System.out.println("Asset updated successfully!");
        } else if (action == 2) {
            assets.remove(index);
            System.out.println("Asset removed successfully!");
        } else {
            System.out.println("Invalid option.");
        }
    }
}