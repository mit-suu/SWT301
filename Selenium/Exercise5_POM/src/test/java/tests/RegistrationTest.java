package tests;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import pages.RegistrationPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DisplayName("Test Registration Form on demoqa.com")
public class RegistrationTest extends BaseTest {
    static RegistrationPage regPage;

    @BeforeAll
    static void init() {
        regPage = new RegistrationPage(driver);
    }

    @ParameterizedTest(name = "{index} => Test with {0} {1}")
    @CsvFileSource(resources = "/register-data.csv", numLinesToSkip = 1)
    @Order(1)
    @DisplayName("Submit registration with CSV data")
    void testFormWithCSV(String fname, String lname, String email, String phone, String gender,
                         String subject, String hobbies, String address, String state, String city) {
        regPage.navigate();
        regPage.fillForm(fname, lname, email, phone, gender, subject, hobbies, address, state, city);
        regPage.submitForm();
        assertTrue(regPage.isSuccessModalVisible(),
                "❌ Modal confirmation not visible for input: " + fname + " " + lname);
    }
}
