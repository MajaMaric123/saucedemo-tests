package pages;

import lombok.Data;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

@Data
public class CheckoutPage extends BasePage {

    private By firstNameField = By.id("first-name");
    private By lastNameField = By.id("last-name");
    private By zipCodeField = By.id("postal-code");
    private By continueButton = By.id("continue");
    private By finishButton = By.id("finish");
    private By checkoutCompleteMessage = By.className("complete-header");
    private By burgerMenu = By.id("react-burger-menu-btn");
    private By logoutButton = By.id("logout_sidebar_link");

    public CheckoutPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    /**
     * Find firstname field
     */
    public WebElement getFirstNameField() {
        return getDriver().findElement(firstNameField);
    }

    /**
     * Find lastname field
     */
    public WebElement getLastNameField() {
        return getDriver().findElement(lastNameField);
    }

    /**
     * Find zip code field
     */
    public WebElement getZipCodeField() {
        return getDriver().findElement(zipCodeField);
    }

    /**
     * Find Continue button and click on it
     */
    public WebElement getContinueButton() {
        return getDriver().findElement(continueButton);
    }

    public void clickContinueButton() {
        getContinueButton().click();
    }

    /**
     * Input Checkout form
     */
    public void inputCheckoutForm(String firstname, String lastname, String zipcode) {
        getFirstNameField().sendKeys(firstname);
        getLastNameField().sendKeys(lastname);
        getZipCodeField().sendKeys(zipcode);
        clickContinueButton();
    }

    /**
     * Find Finish button and click on it
     */
    public WebElement getFinishButton() {
        return getDriver().findElement(finishButton);
    }

    public void clickFinishButton() {
        getFinishButton().click();
    }

    /**
     * Get text from the checkout complete message so that can be compared with expected results
     */
    public String confirmationCheckoutCompleteMessage() {
        return getDriver().findElement(checkoutCompleteMessage).getText();
    }

    /**
     * Find Burger Menu and click on it
     */
    public WebElement getBurgerMenu() {
        return getDriver().findElement(burgerMenu);
    }

    public void clickBurgerMenu() {
        getBurgerMenu().click();
    }

    /**
     * Find and click on Logout button
     */
    public WebElement getLogoutButton() {
        return getDriver().findElement(logoutButton);
    }

    public void clickLogoutButton() {
        getLogoutButton().click();
    }
}
