package inheritance;

public class User {
    protected String name;
    String email;
    String password;

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    void login() {
        System.out.println("User is logged in.");
    }



}
