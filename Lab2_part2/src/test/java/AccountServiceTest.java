import de170600.example.AccountService;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AccountServiceTest {

    AccountService service = new AccountService();

    @Test
    void testRegisterSuccess() {
        boolean result = service.registerAccount("john123", "pass123", "john@example.com");
        System.out.println("✅ testRegisterSuccess: " + result);
        assertTrue(result);
    }

    @Test
    void testEmptyUsername() {
        boolean result = service.registerAccount("", "pass123", "john@example.com");
        System.out.println("✅ testEmptyUsername: " + result);
        assertFalse(result);
    }

    @Test
    void testShortPassword() {
        boolean result = service.registerAccount("alice", "short", "alice@mail.com");
        System.out.println("✅ testShortPassword: " + result);
        assertFalse(result);
    }

    @Test
    void testInvalidEmail() {
        boolean result = service.registerAccount("bob123", "password", "bobmail.com");
        System.out.println("✅ testInvalidEmail: " + result);
        assertFalse(result);
    }

    @Test
    void testAnotherSuccessCase() {
        boolean result = service.registerAccount("carol", "password", "carol@domain.com");
        System.out.println("✅ testAnotherSuccessCase: " + result);
        assertTrue(result);
    }
}

