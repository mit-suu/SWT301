class AppConstants {
    public static final int MAX_USERS = 100;
}

public class InterfaceFieldModificationExample {
    public static void main(String[] args) {
        int limit = AppConstants.MAX_USERS;
        // AppConstants.MAX_USERS = 200; // still not allowed
    }
}
