package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Arrays;

public class RegistrationPage extends BasePage {

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    // Locators
    private final By firstName = By.id("firstName");
    private final By lastName = By.id("lastName");
    private final By email = By.id("userEmail");
    private final By mobile = By.id("userNumber");
    private final By subjects = By.id("subjectsInput");
    private final By address = By.id("currentAddress");
    private final By state = By.id("react-select-3-input");
    private final By city = By.id("react-select-4-input");
    private final By submitBtn = By.id("submit");
    private final By modalTitle = By.id("example-modal-sizes-title-lg");

    public void navigate() {
        navigateTo("https://demoqa.com/automation-practice-form");
        WebElement formStart = waitForVisibility(firstName);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", formStart);
    }

    public void fillForm(String fname, String lname, String emailInput, String phone, String gender,
                         String subject, String hobbies, String addressInput, String stateInput, String cityInput) {

        type(firstName, fname);
        type(lastName, lname);
        type(email, emailInput);

        // ✅ Select gender radio by label text
        click(By.xpath("//label[text()='" + gender + "']"));

        type(mobile, phone);

        // ✅ Subject + ENTER
        type(subjects, subject);
        driver.findElement(subjects).sendKeys(Keys.ENTER);

        // ✅ Select hobbies
        Arrays.stream(hobbies.split("\\|"))
                .forEach(hobby -> click(By.xpath("//label[text()='" + hobby + "']")));

        type(address, addressInput);

        // ✅ Select State & City
        type(state, stateInput);
        driver.findElement(state).sendKeys(Keys.ENTER);
        wait.until(ExpectedConditions.elementToBeClickable(city));
        type(city, cityInput);
        driver.findElement(city).sendKeys(Keys.ENTER);
    }

    public void submitForm() {
        scrollTo(submitBtn);
        click(submitBtn);
    }

    public boolean isSuccessModalVisible() {
        return isElementVisible(modalTitle);
    }

    protected void scrollTo(By locator) {
        WebElement element = waitForVisibility(locator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }
}
