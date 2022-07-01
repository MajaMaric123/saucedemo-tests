package test5pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage extends BasePage{

    private By checkoutTable = By.xpath("//*[@id=\"checkout_info_container\"]/div/form/div[1]");
    private By firstName = By.id("first-name");
    private By lastName = By.id("last-name");
    private By zipCode =By.id("postal-code");
    private By continueButton = By.id("continue");
    private By checkoutCompleteMessage = By.className("complete-header");
    private By itemTotal = By.xpath("//*[@id=\"cart_contents_container\"]/div/div[1]/div[3]/div[2]/div[2]/div");
    private By checkoutTotal = By.xpath("//*[@id=\"checkout_summary_container\"]/div/div[2]/div[5]");
    private By finishButton = By.id("finish");
    private By burgerMenu = By.id("react-burger-menu-btn");
    private By logout = By.id("logout_sidebar_link");

    public CheckoutPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    /**
     * Confirm that is visible Checkout table
     */
    public boolean isVisibleCheckoutTable() {
        return getDriver().findElement(checkoutTable).isDisplayed();
    }

    /**
     * Find firstname field
     */
    public WebElement getFirstName() {
        return getDriver().findElement(firstName);
    }

    /**
     * Find lastname field
     */
    public WebElement getLastName() {
        return getDriver().findElement(lastName);
    }

    /**
     * Find zip code field
     */
    public WebElement getZipCode() {
        return getDriver().findElement(zipCode);
    }

    /**
     * Input Checkout form
     */
    public void inputCheckoutForm(String firstname, String lastname, String zipcode){
        getFirstName().sendKeys(firstname);
        getLastName().sendKeys(lastname);
        getZipCode().sendKeys(zipcode);
        clickContinueButton();
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

    public WebElement getCheckoutTotal() {
        return getDriver().findElement(checkoutTotal);
    }

    public WebElement getItemTotal() {
        return getDriver().findElement(itemTotal);
    }

    /**
     * Find Finish button and click on it
     */
    public WebElement getFinish() {
        return getDriver().findElement(finishButton);
    }

    public void clickFinish() {
        getFinish().click();
    }

    /**
     * Get text from the checkout complete message and compare it with the expected results
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
    public WebElement getLogout() {
        return getDriver().findElement(logout);
    }

    public void clickLogout() {
        getLogout().click();
    }
}
