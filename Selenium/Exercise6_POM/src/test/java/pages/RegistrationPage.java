package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class RegistrationPage extends BasePage {
    private final By usernameInput = By.xpath("//input[@placeholder='Enter username']");
    private final By emailInput = By.xpath("//input[@placeholder='Enter email address']");
    private final By passwordInput = By.xpath("//input[@placeholder='Enter password']");
    private final By registerButton = By.xpath("//button[text()='Register']");

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    public void navigate() {
        navigateTo("http://localhost:3000/register");
    }

    public void fillForm(String username, String email, String password) {
        type(usernameInput, username);
        type(emailInput, email);
        type(passwordInput, password);
    }

    public boolean submitFormAndCheckSuccess() {
        click(registerButton);

        try {
            // Đợi alert trong 4s (React app có thể load chậm)
            Alert alert = wait.withTimeout(Duration.ofSeconds(4))
                    .until(ExpectedConditions.alertIsPresent());
            String text = alert.getText();
            alert.accept();

            // ✅ Nếu alert có chứa từ "Đăng ký thành công" thì là thành công
            if (text.contains("Đăng ký thành công")) {
                System.out.println("✅ Đăng ký thành công với alert: " + text);

                // Đợi chuyển trang để chắc chắn
                return wait.until(ExpectedConditions.urlContains("/login"));
            } else {
                System.out.println("❌ Đăng ký thất bại với alert: " + text);
                return false;
            }

        } catch (TimeoutException e) {
            // Nếu không có alert luôn → bất thường
            System.out.println("❌ Không có alert sau khi nhấn nút đăng ký (có thể lỗi hệ thống)");
            return false;
        }
    }


}

