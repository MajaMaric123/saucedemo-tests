package test5pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class InventoryPage extends BasePage {

    private By burgerMenu = By.id("react-burger-menu-btn");
    private By logout = By.id("logout_sidebar_link");
    private By firstProduct = By.id("add-to-cart-sauce-labs-backpack");
    private By secondProductDetails = By.id("item_0_title_link");
    private By secondProductAddToCart = By.id("add-to-cart-sauce-labs-bike-light");
    private By cartBadge = By.className("shopping_cart_badge");

    private By removeButton = By.id("remove-sauce-labs-backpack");
    private By cart = By.id("shopping_cart_container");


    public InventoryPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    /**
     * Find first product and click on Add to cart button
     */
    public WebElement getFirstProduct() {
        return getDriver().findElement(firstProduct);
    }

    public void addFirstProduct() {
        getFirstProduct().click();
    }

    /**
     * Find Click button and click on it
     */
    public WebElement getCart() {
        return getDriver().findElement(cart);
    }

    public void clickCart() {
        getCart().click();
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
     * Confirm that is visible Cart Badge after click on Add to cart button
     */
    public boolean isVisibleCartBadge() {
        return getDriver().findElement(cartBadge).isDisplayed();
    }

    /**
     * Confirm that is visible Logout button after Login
     */
    public boolean isVisibleLogout() {
        clickBurgerMenu();
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        return getDriver().findElement(logout).isDisplayed();
    }

    /**
     * Find second product and click on name to open product details
     */
    public WebElement getSecondProductDetails() {
        return getDriver().findElement(secondProductDetails);
    }

    public void clickSecondProductDetails() {
        getSecondProductDetails().click();
    }

    /**
     * Find second product Add to cart button on click on it
     */
    public WebElement getSecondProductAddToCart() {
        return getDriver().findElement(secondProductAddToCart);
    }

    public void clickSecondProductAddToCart() {
        getSecondProductAddToCart().click();
    }
}
