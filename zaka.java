import java.util.Map;


class ZakatCalculator {
    // Zakat rate is typically 2.5%
    private static final double ZAKAT_RATE = 0.025;

    // Calculate zakat for a list of assets (each asset is a name and value)
    public static double calculateZakat(Map<String, Double> assets) {
        double totalZakat = 0.0;
        for (Map.Entry<String, Double> entry : assets.entrySet()) {
            totalZakat += entry.getValue() * ZAKAT_RATE;
        }
        return totalZakat;
    }

    // Print zakat per asset
    public static void printZakatPerAsset(Map<String, Double> assets) {
        System.out.println("Zakat Calculation Per Asset:");
        for (Map.Entry<String, Double> entry : assets.entrySet()) {
            double zakat = entry.getValue() * ZAKAT_RATE;
            System.out.printf("Asset: %s, Value: %.2f, Zakat Due: %.2f\n", entry.getKey(), entry.getValue(), zakat);
        }
    }
}
