import java.util.*;

public class User {
    private int userID;
    private String name;
    private String email;
    private String password;
    private List<Asset> assets = new ArrayList<>();

    public User(int userID, String name, String email, String password) {
        this.userID = userID;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    // Getters and setters...
    public int getUserID() { return userID; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getPassword() { return password; }
    public List<Asset> getAssets() { return assets; }
}