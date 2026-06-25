package tests;

import base.BaseTest;
import models.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.LoginPage;
import pages.ProductPage;
import utils.JsonUtils;

public class ProductTest extends BaseTest {
    @Test
    public void TC03_AddProductToCart() {
        ProductPage productPage = loginWithValidUser();
        String selectedProduct = productPage.getFirstProductName();

        CartPage cartPage = productPage
                .addFirstProductToCart()
                .openCart();

        Assert.assertTrue(
                cartPage.isProductDisplayed(selectedProduct),
                "Cart should display selected product: " + selectedProduct
        );
    }

    @Test
    public void TC04_RemoveProductFromCart() {
        CartPage cartPage = loginWithValidUser()
                .addFirstProductToCart()
                .openCart()
                .removeProduct();

        Assert.assertTrue(
                cartPage.isCartEmpty(),
                "Cart should be empty after removing product"
        );
    }

    private ProductPage loginWithValidUser() {
        User user = JsonUtils.getUser("validUser");
        return new LoginPage(driver).loginAs(user.getUsername(), user.getPassword());
    }
}
