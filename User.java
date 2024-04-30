// Abstract class or interface representing a user in the system
abstract class User {
    private String name;
    private int id;
    private boolean loggedIn; // to check if the user has logged in
    private String password; // user password

    public User(String name, int id, boolean loggedIn, String password) {
        this.name = name;
        this.id = id;
        this.loggedIn = loggedIn;
        this.password = password;
    }

    public void login(String enteredPassword) {
        // Check if entered password matches the user's password
        if (enteredPassword.equals(password)) {
            loggedIn = true;
        } else {
            System.out.println("Incorrect password. Please try again.");
        }
    }

    public void changePassword(String oldPassword, String newPassword) {
        // Check if entered old password matches the user's current password
        if (oldPassword.equals(password)) {
            password = newPassword;
            System.out.println("Password changed successfully.");
        } else {
            System.out.println("Incorrect old password. Password change failed.");
        }
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void login() {
        loggedIn = true;
    }

    public void logout() {
        loggedIn = false;
    }

    public String getName(){
        return this.name;
    }

    public int getId(){
        return this.id;
    }

}