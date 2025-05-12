public class Asset {
    private String type;
    private String name;
    private float amount;

    public Asset(String type, String name, float amount) {
        this.type = type;
        this.name = name;
        this.amount = amount;
    }

    public String getType() { return type; }
    public String getName() { return name; }
    public float getAmount() { return amount; }
    public void setName(String name) { this.name = name; }
    public void setAmount(float amount) { this.amount = amount; }
}