package test5pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage extends BasePage{

    private By cartFirstProduct = By.id("item_4_title_link");
    private By cartSecondProduct = By.id("item_0_title_link");
    private By removeSauceLabsBackpack =  By.id("remove-sauce-labs-backpack");
    private By checkoutButton = By.id("checkout");

    public CartPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    /**
     * Get text from the title of first product and compare it with the expected results
     */
    public String confirmationFirstProductIsInCart() {
        return getDriver().findElement(cartFirstProduct).getText();
    }

    /**
     * Get text from the title of second product and compare it with the expected results
     */
    public String confirmationSecondProductIsInCart() {
        return getDriver().findElement(cartSecondProduct).getText();
    }

    /**
     * Find Remove sauce labs backpack button and click on it
     */
    public WebElement getRemoveSauceLabsBackpack() {
        return getDriver().findElement(removeSauceLabsBackpack);
    }

    public void clickRemoveSauceLabsBackpack() {
        getRemoveSauceLabsBackpack().click();
    }

    /**
     * Find Checkout button and click on it
     */
    public WebElement getCheckoutButton() {
        return getDriver().findElement(checkoutButton);
    }

    public void clickCheckoutButton() {
        getCheckoutButton().click();
    }
}
