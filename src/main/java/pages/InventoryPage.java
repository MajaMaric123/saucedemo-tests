package pages;

import lombok.Data;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

@Data
public class InventoryPage extends BasePage {

    private By sauceLabsBackpackAddToCart = By.id("add-to-cart-sauce-labs-backpack");
    private By sauceLabsBikeLightImage = By.id("item_0_img_link");
    private By sauceLabsBikeLightAddToCart = By.id("add-to-cart-sauce-labs-bike-light");
    private By cartBadge = By.className("shopping_cart_badge");
    private By cartButton = By.id("shopping_cart_container");


    public InventoryPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    /**
     * Find Sauce Labs Backpack item and click on Add to cart button
     */
    public WebElement getSauceLabsBackpackItem() {
        return getDriver().findElement(sauceLabsBackpackAddToCart);
    }

    public void addSauceLabsBackpackItem() {
        getSauceLabsBackpackItem().click();
    }

    /**
     * Confirm that is visible Cart Badge after add Sauce Labs Backpack to the cart
     */
    public boolean isVisibleCartBadge() {
        return getDriver().findElement(cartBadge).isDisplayed();
    }

    /**
     * Find Sauce Labs Bike Light item and click on the image link to open product details
     */
    public WebElement getSauceLabsBikeLightImage() {
        return getDriver().findElement(sauceLabsBikeLightImage);
    }

    public void openSauceLabsBikeLightDetails() {
        getSauceLabsBikeLightImage().click();
    }

    /**
     * Find Add to cart button for Sauce Labs Bike Light item and on click on it
     */
    public WebElement getSauceLabsBikeLightAddToCart() {
        return getDriver().findElement(sauceLabsBikeLightAddToCart);
    }

    public void addSauceLabsBikeLightItem() {
        getSauceLabsBikeLightAddToCart().click();
    }

    /**
     * Find Cart button and click on it
     */
    public WebElement getCartButton() {
        return getDriver().findElement(cartButton);
    }

    public void openCart() {
        getCartButton().click();
    }
}
