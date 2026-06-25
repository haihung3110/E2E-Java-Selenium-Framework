package pages;

import base.BasePage;
import elements.PageElements;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {
    public CartPage(WebDriver driver) {
        super(driver);
    }

    public String getProductNameInCart() {
        return getText(PageElements.Cart.PRODUCT_NAME);
    }

    public boolean isProductDisplayed(String productName) {
        return getProductNameInCart().equals(productName);
    }

    public CartPage removeProduct() {
        click(PageElements.Cart.REMOVE_BUTTON);
        return this;
    }

    public boolean isCartEmpty() {
        return !isDisplayed(PageElements.Cart.PRODUCT_NAME);
    }

    public CheckoutPage proceedToCheckout() {
        click(PageElements.Cart.CHECKOUT_BUTTON);
        return new CheckoutPage(driver);
    }
}
