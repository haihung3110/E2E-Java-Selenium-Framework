package elements;

import org.openqa.selenium.By;

/**
 * Central XPath repository. Page Objects consume these locators; tests never
 * locate elements directly.
 */
public final class PageElements {
    private PageElements() {
    }

    public static final class Login {
        public static final By USERNAME_INPUT = By.xpath("//*[@data-test='username']");
        public static final By PASSWORD_INPUT = By.xpath("//*[@data-test='password']");
        public static final By LOGIN_BUTTON = By.xpath("//*[@data-test='login-button']");
        public static final By ERROR_MESSAGE = By.xpath("//*[@data-test='error']");

        private Login() {
        }
    }

    public static final class Product {
        public static final By PAGE_TITLE = By.xpath("//*[@data-test='title']");
        public static final By FIRST_PRODUCT_NAME = By.xpath("(//*[@data-test='inventory-item-name'])[1]");
        public static final By ADD_FIRST_PRODUCT_BUTTON = By.xpath("(//*[starts-with(@data-test,'add-to-cart')])[1]");
        public static final By CART_LINK = By.xpath("//*[@data-test='shopping-cart-link']");

        private Product() {
        }
    }

    public static final class Cart {
        public static final By PRODUCT_NAME = By.xpath("(//*[@data-test='inventory-item-name'])[1]");
        public static final By REMOVE_BUTTON = By.xpath("(//*[starts-with(@data-test,'remove')])[1]");
        public static final By CHECKOUT_BUTTON = By.xpath("//*[@data-test='checkout']");

        private Cart() {
        }
    }

    public static final class Checkout {
        public static final By FIRST_NAME_INPUT = By.xpath("//*[@data-test='firstName']");
        public static final By LAST_NAME_INPUT = By.xpath("//*[@data-test='lastName']");
        public static final By POSTAL_CODE_INPUT = By.xpath("//*[@data-test='postalCode']");
        public static final By CONTINUE_BUTTON = By.xpath("//*[@data-test='continue']");
        public static final By FINISH_BUTTON = By.xpath("//*[@data-test='finish']");
        public static final By SUCCESS_MESSAGE = By.xpath("//*[@data-test='complete-header']");

        private Checkout() {
        }
    }
}
