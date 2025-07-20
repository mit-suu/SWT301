package pages;

import org.openqa.selenium.*;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private final By usernameInput = By.xpath("//input[@placeholder='Enter username']");
    private final By passwordInput = By.xpath("//input[@placeholder='Enter password']");
    private final By loginButton = By.xpath("//button[text()='Login']");
    private final By logoutButton = By.xpath("//button[contains(text(), 'Logout') or contains(text(),'Log out')]");

    public void navigate() {
        navigateTo("http://localhost:3000/login");

    }

    public void fillLoginForm(String username, String password) {
        type(usernameInput, username);
        type(passwordInput, password);
    }

    public void submitLogin() {
        click(loginButton);
    }

    public boolean isLoginSuccessful() {
        try {
            // Sau khi login, nếu URL không còn là /login, thì coi như thành công
            Thread.sleep(0); // đợi trang redirect
            return !driver.getCurrentUrl().contains("/login");
        } catch (Exception e) {
            return false;
        }
    }

    public void logoutIfAlreadyLoggedIn() {
        navigateTo("http://localhost:3000");
        try {
            if (isElementVisible(logoutButton)) {
                click(logoutButton);
            }
        } catch (Exception ignored) {
        }
    }
}
