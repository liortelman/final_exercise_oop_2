// Abstract class or interface representing a user in the system
abstract class User {
    private String name;
    private int id;
    private boolean loggedIn; // to check if the user has logged in

    public User(String name, int id, boolean loggedIn) {
        this.name = name;
        this.id = id;
        this.loggedIn = loggedIn;
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