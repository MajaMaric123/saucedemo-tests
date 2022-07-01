package pages;

import lombok.Data;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

@Data
public class LoginPage extends BasePage {

    private By userNameField = By.id("user-name");
    private By passwordField = By.id("password");
    private By loginButton = By.id("login-button");

    public LoginPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    /**
     * Find username field
     */
    public WebElement getUserNameField() {
        return getDriver().findElement(userNameField);
    }

    /**
     * Find password field
     */
    public WebElement getPasswordField() {
        return getDriver().findElement(passwordField);
    }

    /**
     * Find and click on Login button
     */
    public WebElement getLoginButton() {
        return getDriver().findElement(loginButton);
    }

    public void clickLoginButton() {
        getLoginButton().click();
    }

    /**
     * Input Login form with valid credentials and click on Login button
     */
    public void inputLoginForm(String username, String password) {
        getUserNameField().sendKeys(username);
        getPasswordField().sendKeys(password);
        clickLoginButton();
    }

    /**
     * Confirm that is visible Login button after click on Logout button
     */
    public boolean isVisibleLoginButton() {
        return getDriver().findElement(loginButton).isDisplayed();
    }
}
