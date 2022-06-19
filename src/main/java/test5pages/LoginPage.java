package test5pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage{

    private By userNameField = By.id("user-name");
    private By passwordField = By.id("password");
    private By loginButton = By.id("login-button");


    public LoginPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public WebElement getUserNameField(){
        return getDriver().findElement(userNameField);
    }

    public WebElement getPasswordField(){
        return getDriver().findElement(passwordField);
    }

    public WebElement getLoginButton(){
        return getDriver().findElement(loginButton);
    }

    public void clickLoginButton(){
        getLoginButton().click();
    }

    public void inputLoginForm(String username, String password){
        getUserNameField().sendKeys(username);
        getPasswordField().sendKeys(password);
        clickLoginButton();
    }

    public boolean isVisibleLoginButton() {
        return getDriver().findElement(loginButton).isDisplayed();
    }
}
