package test5pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage extends BasePage{

    private By checkoutTable = By.xpath("//*[@id=\"checkout_info_container\"]/div/form/div[1]");
    private By firstName = By.id("first-name");
    private By lastName = By.id("last-name");
    private By zipCode =By.id("postal-code");
    private By continueButton = By.id("continue");
    private By itemTotal = By.xpath("//*[@id=\"cart_contents_container\"]/div/div[1]/div[3]/div[2]/div[2]/div");
    private By checkoutTotal = By.xpath("//*[@id=\"checkout_summary_container\"]/div/div[2]/div[5]");
    private By finishButton = By.id("finish");
    private By logout = By.id("logout_sidebar_link");
    private By slideBar = By.id("react-burger-menu-btn");
    public CheckoutPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public boolean isVisibleCheckoutTable() {
        return getDriver().findElement(checkoutTable).isDisplayed();
    }

    public WebElement getFirstName() {
        return getDriver().findElement(firstName);
    }

    public WebElement getLastName() {
        return getDriver().findElement(lastName);
    }

    public WebElement getZipCode() {
        return getDriver().findElement(zipCode);
    }

    public WebElement getContinueButton() {
        return getDriver().findElement(continueButton);
    }

    public void clickContinueButton() {
        getContinueButton().click();
    }

    public void inputCheckoutForm(String firstname, String lastname, String zipcode){
        getFirstName().sendKeys(firstname);
        getLastName().sendKeys(lastname);
        getZipCode().sendKeys(zipcode);
        clickContinueButton();
    }

    public WebElement getCheckoutTotal() {
        return getDriver().findElement(checkoutTotal);
    }

    public WebElement getItemTotal() {
        return getDriver().findElement(itemTotal);
    }

    public WebElement getFinish() {
        return getDriver().findElement(finishButton);
    }

    public void clickFinish() {
        getFinish().click();
    }

    public WebElement getLogout() {
        //Select selectOption = new Select(getDriver().findElement(By.id("logout_sidebar_link")));
        //selectOption.selectBy;
        return getDriver().findElement(logout);
    }

    public void clickLogout() {
        getLogout().click();
    }

    public WebElement getSlideBar() {
        //Select selectOption = new Select(getDriver().findElement(By.id("logout_sidebar_link")));
        //selectOption.selectBy;
        return getDriver().findElement(slideBar);
    }

    public void clickSlideBar() {
        getSlideBar().click();
    }
}
