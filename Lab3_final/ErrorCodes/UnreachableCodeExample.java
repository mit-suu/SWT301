import java.util.logging.Logger;

public class UnreachableCodeExample {
    private static final Logger logger = Logger.getLogger(UnreachableCodeExample.class.getName());

    public static int getNumber() {
        return 42;
        // logger.info("This will never execute"); // Unreachable, removed
    }

    public static void main(String[] args) {
        logger.info("Returned number: " + getNumber());
    }
}
