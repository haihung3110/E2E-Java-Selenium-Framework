package tests;

import base.BaseTest;
import models.User;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductPage;
import utils.JsonUtils;

public class LoginTest extends BaseTest {
    @Test
    public void TC01_Login_Success() {
        User user = JsonUtils.getUser("validUser");

        ProductPage productPage = new LoginPage(driver)
                .loginAs(user.getUsername(), user.getPassword());

        Assert.assertTrue(
                productPage.isProductPageDisplayed(),
                "Product page should be displayed after valid login"
        );
    }

    @DataProvider(name = "invalidLoginData")
    public Object[][] invalidLoginData() {
        return new Object[][]{
                {JsonUtils.getUser("invalidUser")},
                {JsonUtils.getUser("lockedUser")}
        };
    }

    @Test(dataProvider = "invalidLoginData")
    public void TC02_Login_InvalidPassword(User user) {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.loginAs(user.getUsername(), user.getPassword());

        Assert.assertFalse(
                loginPage.getErrorMessage().isBlank(),
                "Error message should be displayed for invalid login"
        );
    }
}
