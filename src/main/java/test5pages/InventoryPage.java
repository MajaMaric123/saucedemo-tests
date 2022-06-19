package test5pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class InventoryPage extends BasePage {

    private By inventoryContainer = By.id("inventory_container");
    private By product = By.id("add-to-cart-sauce-labs-backpack");

    private By removeButton = By.id("remove-sauce-labs-backpack");
    private By cart = By.id("shopping_cart_container");


    public InventoryPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public WebElement getProduct() {
        return getDriver().findElement(product);
    }

    public void addProduct() {
        getProduct().click();
    }

    public WebElement getCart() {
        return getDriver().findElement(cart);
    }

    public void clickCart() {
        getCart().click();
    }

    public boolean isVisibleInventoryContainer() {
        return getDriver().findElement(inventoryContainer).isDisplayed();
    }

    public void addProductToCart(){
        getProduct().click();
        //getDriverWait().until(ExpectedCondition.visibilityOfElementLocatedBy(removeButton));
        getCart().click();
    }

}
