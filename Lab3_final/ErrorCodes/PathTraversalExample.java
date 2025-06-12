import java.io.*;
import java.util.logging.Logger;

public class PathTraversalExample {
    private static final Logger logger = Logger.getLogger(PathTraversalExample.class.getName());

    public static void main(String[] args) throws IOException {
        String userInput = "../secret.txt";
        File file = new File(userInput).getCanonicalFile();

        File allowedDir = new File("safe_dir").getCanonicalFile();
        if (file.getPath().startsWith(allowedDir.getPath())) {
            if (file.exists()) {
                try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                    logger.info("Reading file: " + file.getPath());
                }
            }
        } else {
            logger.warning("Access to file outside allowed directory was blocked: " + file.getPath());
        }
    }
}
