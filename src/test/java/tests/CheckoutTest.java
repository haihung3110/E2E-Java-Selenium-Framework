package tests;

import base.BaseTest;
import listeners.RetryAnalyzer;
import models.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CheckoutPage;
import pages.LoginPage;
import utils.JsonUtils;

public class CheckoutTest extends BaseTest {
    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void TC05_Checkout_Success() {
        User user = JsonUtils.getUser("validUser");

        CheckoutPage checkoutPage = new LoginPage(driver)
                .loginAs(user.getUsername(), user.getPassword())
                .addFirstProductToCart()
                .openCart()
                .proceedToCheckout()
                .fillCheckoutInfo("Automation", "Tester", "550000")
                .finishOrder();

        Assert.assertEquals(
                checkoutPage.getSuccessMessage(),
                "Thank you for your order!",
                "Checkout success message should be displayed"
        );
    }
}
