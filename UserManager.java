import java.util.Map;
import java.util.HashMap;

public class UserManager {
    private Map<String, User> usersByEmail = new HashMap<>();
    private int nextUserID = 1;
    private User currentUser = null;

    public boolean signUp(String name, String email, String password) {
        if (usersByEmail.containsKey(email)) {
            System.out.println("Error: Email already registered.");
            return false;
        }
        User newUser = new User(nextUserID++, name, email, password);
        usersByEmail.put(email, newUser);
        currentUser = newUser;
        System.out.println("Sign up successful!");
        return true;
    }

    public boolean signIn(String email, String password) {
        User user = usersByEmail.get(email);
        if (user != null && user.getPassword().equals(password)) {
            currentUser = user;
            System.out.println("Sign in successful! Welcome, " + user.getName());
            return true;
        }
        System.out.println("Error: Invalid email or password.");
        return false;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void signOut() {
        currentUser = null;
    }
}