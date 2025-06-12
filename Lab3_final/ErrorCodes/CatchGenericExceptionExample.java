import java.util.logging.Logger;

public class CatchGenericExceptionExample {
    private static final Logger logger = Logger.getLogger(CatchGenericExceptionExample.class.getName());

    public static void main(String[] args) {
        try {
            String s = null;
            if (s != null) {
                logger.info("Length of string: " + s.length());
            } else {
                logger.warning("String 's' is null");
            }
        } catch (Exception e) {
            logger.severe("An exception occurred: " + e.getMessage());
        }
    }
}
