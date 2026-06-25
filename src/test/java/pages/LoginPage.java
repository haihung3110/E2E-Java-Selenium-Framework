package pages;

import base.BasePage;
import elements.PageElements;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public ProductPage loginAs(String username, String password) {
        type(PageElements.Login.USERNAME_INPUT, username);
        type(PageElements.Login.PASSWORD_INPUT, password);
        click(PageElements.Login.LOGIN_BUTTON);
        return new ProductPage(driver);
    }

    public String getErrorMessage() {
        return getText(PageElements.Login.ERROR_MESSAGE);
    }

    public boolean isLoginPageDisplayed() {
        return isDisplayed(PageElements.Login.LOGIN_BUTTON);
    }
}
