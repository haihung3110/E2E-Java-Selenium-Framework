package pages;

import base.BasePage;
import elements.PageElements;
import org.openqa.selenium.WebDriver;

public class ProductPage extends BasePage {

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public boolean isProductPageDisplayed() {
        return isDisplayed(PageElements.Product.PAGE_TITLE);
    }

    public String getFirstProductName() {
        return getText(PageElements.Product.FIRST_PRODUCT_NAME);
    }

    public ProductPage addFirstProductToCart() {
        click(PageElements.Product.ADD_FIRST_PRODUCT_BUTTON);
        return this;
    }

    public CartPage openCart() {
        click(PageElements.Product.CART_LINK);
        return new CartPage(driver);
    }
}
