package gui.phptravels.pages;

import com.shaft.gui.element.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class HomePage {
    private WebDriver driver;
    private ElementActions elementActions;
    public HomePage(WebDriver driver)
    {
        this.driver=driver;
        this.elementActions= new ElementActions();
    }
    // Elements Locators
    private static final By ACCOUNT_DROPDOWN_BUTTON = By.cssSelector(".nav-item--right > ul > li:nth-of-type(3)");
    private static final By SIGN_UP_BUTTON = By.cssSelector(".nav-item--right > ul > li:nth-of-type(3) > ul > li:nth-of-type(2)");
    // Actions
    private static final By LOGIN_BUTTON = By.cssSelector(".nav-item--right > ul > li:nth-of-type(3) > ul > li:nth-of-type(1)");
    public void navigateToSignUpPage()
    {
        elementActions.click(ACCOUNT_DROPDOWN_BUTTON);
        elementActions.click(SIGN_UP_BUTTON);
    }
    public void navigateToLoginPage()
    {
        elementActions.click(ACCOUNT_DROPDOWN_BUTTON);
        elementActions.click(LOGIN_BUTTON);
    }
}
