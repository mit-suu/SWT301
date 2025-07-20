package tests;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import pages.LoginPage;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DisplayName("Test Login Page")
public class LoginTest extends BaseTest {
    static LoginPage loginPage;

    @BeforeAll
    static void init() {
        loginPage = new LoginPage(driver);
    }

    @BeforeEach
    void resetLoginState() {
        loginPage.logoutIfAlreadyLoggedIn(); // Đảm bảo bắt đầu từ trạng thái đã logout
    }

    @ParameterizedTest(name = "{index} => Login with username={0}, password={1}")
    @CsvFileSource(resources = "/login-data.csv", numLinesToSkip = 1)
    @Order(1)
    @DisplayName("Test login function with CSV data")
    void testLogin(String username, String password, String expectedResult) {
        loginPage.navigate();
        loginPage.fillLoginForm(username, password);
        loginPage.submitLogin();

        boolean actual = loginPage.isLoginSuccessful();

        if (expectedResult.equalsIgnoreCase("pass")) {
            assertTrue(actual, "Expected login to succeed but it failed.");
        } else {
            assertFalse(actual, "Expected login to fail but it succeeded.");
        }
    }
}
