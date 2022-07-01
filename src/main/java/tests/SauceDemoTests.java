package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SauceDemoTests extends BaseTests {

    /**
     * Verify that the cart badge in the left corner on the top of the page is updated correctly after adding one item
     * from a list to the cart
     */
    @Test(priority = 1)
    public void verifyThatTheCartBadgeIsUpdatedCorrectly() {
        getLoginPage().inputLoginForm("standard_user", "secret_sauce");
        getInventoryPage().addSauceLabsBackpackItem();
        Assert.assertTrue(getInventoryPage().isVisibleCartBadge());
    }

    /**
     * Verify that the correct two different items are present in the cart after adding a second item to the cart
     */
    @Test(priority = 2)
    public void verifyThatTheCorrectItemsArePresent() {
        getInventoryPage().openSauceLabsBikeLightDetails();
        getInventoryPage().addSauceLabsBikeLightItem();
        getInventoryPage().openCart();
        Assert.assertTrue(getCartPage().twoItemsInCart());
        Assert.assertEquals(getCartPage().confirmationFirstItemIsInCart(), "Sauce Labs Backpack");
        Assert.assertEquals(getCartPage().confirmationSecondItemIsInCart(), "Sauce Labs Bike Light");
    }

    /**
     * Verify that the correct item is present in the cart after removing first item from cart
     */
    @Test(priority = 3)
    public void verifyThatTheCorrectItemIsPresent() {
        getCartPage().clickRemoveSauceLabsBackpack();
        Assert.assertTrue(getCartPage().oneItemInCart());
        Assert.assertEquals(getCartPage().confirmationSecondItemIsInCart(), "Sauce Labs Bike Light");
    }

    /**
     * Verify that the order is completed successfully with the displayed message
     */
    @Test(priority = 4)
    public void verifyThatTheOrderIsCompletedSuccessfully() {
        getCartPage().clickCheckoutButton();
        getCheckoutPage().inputCheckoutForm("Maja", "Maric", "21300");
        getCheckoutPage().clickFinishButton();
        Assert.assertEquals(getCheckoutPage().confirmationCheckoutCompleteMessage(), "THANK YOU FOR YOUR ORDER");
    }

    /**
     * Verify that the login button is visible after click on logout button
     */
    @Test(priority = 5)
    public void verifyThatLogoutIsSuccessful() {
        getCheckoutPage().clickBurgerMenu();
        getCheckoutPage().clickLogoutButton();
        Assert.assertTrue(getLoginPage().isVisibleLoginButton());
    }
}
