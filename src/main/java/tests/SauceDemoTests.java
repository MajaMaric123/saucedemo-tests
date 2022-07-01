package test5tests;

import org.testng.Assert;
import org.testng.annotations.Test;


public class Tests extends BaseTests {

    /**
     * Verify that the cart badge is updated correctly after click on Add to cart button
     */
    @Test(priority = 1)
    public void verifyThatTheCartBadgeIsUpdatedCorrectly() {
        getLoginPage().inputLoginForm("standard_user", "secret_sauce");
        //Assert.assertTrue(getInventoryPage().isVisibleLogout());
        getInventoryPage().addFirstProduct();
        Assert.assertTrue(getInventoryPage().isVisibleCartBadge());
    }

    /**
     * Verify that the correct items are present in the cart after adding two products to cart
     */
    @Test(priority = 2)
    public void verifyThatTheCorrectItemsArePresent() {
        getInventoryPage().clickSecondProductDetails();
        getInventoryPage().clickSecondProductAddToCart();
        getInventoryPage().clickCart();
        Assert.assertEquals(getCartPage().confirmationFirstProductIsInCart(), "Sauce Labs Backpack");
        Assert.assertEquals(getCartPage().confirmationSecondProductIsInCart(), "Sauce Labs Bike Light");
    }

    /**
     * Verify that the correct item is present in the cart after removing first product from cart
     */
    @Test(priority = 3)
    public void verifyThatTheCorrectItemIsPresent(){
        getCartPage().clickRemoveSauceLabsBackpack();
        Assert.assertEquals(getCartPage().confirmationSecondProductIsInCart(), "Sauce Labs Bike Light");
    }

    /**
     * Verify that the correct item is present in the cart after removing first product from cart
     */
    @Test(priority = 4)
    public void verifyThatTheOrderIsCompletedSuccessfullyWithTheDisplayedMessage()  {
        getCartPage().clickCheckoutButton();
        Assert.assertTrue(getCheckoutPage().isVisibleCheckoutTable());
        getCheckoutPage().inputCheckoutForm("Maja", "Maric", "21300");
        //Assert.assertTrue(getCheckoutPage().getCheckoutTotal().getText().contains(getCheckoutPage().getItemTotal().getText()));
        getCheckoutPage().clickFinish();
        Assert.assertEquals(getCheckoutPage().confirmationCheckoutCompleteMessage(), "THANK YOU FOR YOUR ORDER");
    }

    @Test(priority = 5)
    public void logout()  {
        getCheckoutPage().clickBurgerMenu();
        getCheckoutPage().clickLogout();
        Assert.assertTrue(getLoginPage().isVisibleLoginButton());
    }
}
