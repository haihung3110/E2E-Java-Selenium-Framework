package pages;

import base.BasePage;
import elements.PageElements;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage {
    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public CheckoutPage fillCheckoutInfo(String firstName, String lastName, String postalCode) {
        type(PageElements.Checkout.FIRST_NAME_INPUT, firstName);
        type(PageElements.Checkout.LAST_NAME_INPUT, lastName);
        type(PageElements.Checkout.POSTAL_CODE_INPUT, postalCode);
        click(PageElements.Checkout.CONTINUE_BUTTON);
        return this;
    }

    public CheckoutPage finishOrder() {
        click(PageElements.Checkout.FINISH_BUTTON);
        return this;
    }

    public String getSuccessMessage() {
        return getText(PageElements.Checkout.SUCCESS_MESSAGE);
    }
}
