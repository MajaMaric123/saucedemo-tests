package test5tests;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Tests extends BaseTests {

    @Test(priority = 1)
    public void verifyLogin() {
        getLoginPage().inputLoginForm("standard_user", "secret_sauce");
        Assert.assertTrue(getInventoryPage().isVisibleInventoryContainer());
    }

    @Test(priority = 2)
    public void verifyAddProductToCart() throws InterruptedException {
        getInventoryPage().addProduct();
        Thread.sleep(2000);
        getInventoryPage().clickCart();
        Assert.assertTrue(getCartPage().isVisibleProductInCart());
    }

    @Test(priority = 3)
    public void verifyCheckout() throws InterruptedException {
        getCartPage().clickChecoutButton();
        Assert.assertTrue(getCheckoutPage().isVisibleCheckoutTable());
        getCheckoutPage().inputCheckoutForm("Maja", "Maric", "21300");
        Thread.sleep(2000);
        Assert.assertTrue(getCheckoutPage().getCheckoutTotal().getText().contains(getCheckoutPage().getItemTotal().getText()));
        getCheckoutPage().clickFinish();
    }

   @Test(priority = 4)
    public void logout()  {
        getCheckoutPage().clickLogout();
        Assert.assertTrue(getLoginPage().isVisibleLoginButton());
        getCartPage().openCartPage();
    }
}
