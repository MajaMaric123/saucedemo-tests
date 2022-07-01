package pages;

import lombok.Data;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

@Data
public class CartPage extends BasePage {

    private By cartFirstItem = By.id("item_4_title_link");
    private By cartSecondItem = By.id("item_0_title_link");
    private By removeSauceLabsBackpack = By.id("remove-sauce-labs-backpack");
    private By checkoutButton = By.id("checkout");

    public CartPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    /**
     * Get first item title text so that can be compared with expected results
     */
    public String confirmationFirstItemIsInCart() {
        return getDriver().findElement(cartFirstItem).getText();
    }

    /**
     * Get second item title text so that can be compared with expected results
     */
    public String confirmationSecondItemIsInCart() {
        return getDriver().findElement(cartSecondItem).getText();
    }

    /**
     * Find Sauce Labs Backpack Remove button and click on it
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

    /**
     * Confirm that there are two items on the cart list
     */
    public boolean twoItemsInCart() {
        List<WebElement> list = getDriver().findElements(By.className("cart_item"));
        return list.size() == 2;
    }

    /**
     * Confirm that there is only one item on the cart list
     */
    public boolean oneItemInCart() {
        List<WebElement> list = getDriver().findElements(By.className("cart_item"));
        return list.size() == 1;
    }
}
