package tests;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import pages.RegistrationPage;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DisplayName("Test Register Page")
public class RegistrationTest extends BaseTest {
    static RegistrationPage registrationPage;

    @BeforeAll
    static void init() {
        registrationPage = new RegistrationPage(driver);
    }

    @ParameterizedTest(name = "{index} => username={0}, email={1}")
    @CsvFileSource(resources = "/register-data.csv", numLinesToSkip = 1)
    @Order(1)
    @DisplayName("Register new user via CSV data")
    void testRegister(String username, String email, String password, boolean expectedSuccess) {
        registrationPage.navigate();
        registrationPage.fillForm(username, email, password);

        boolean actualSuccess = registrationPage.submitFormAndCheckSuccess();

        System.out.println("✅ Test user: " + username + " | expected=" + expectedSuccess + " | actual=" + actualSuccess);

        assertEquals(expectedSuccess, actualSuccess);
    }
}
