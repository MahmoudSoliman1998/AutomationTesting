package gui.phptravels.pages;

import com.shaft.gui.element.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpPage {
    private WebDriver driver;
    private ElementActions elementActions;
    // Constructor
    public SignUpPage(WebDriver driver)
    {
        this.driver=driver;
        elementActions = new ElementActions();
    }
    // Elements Locators
    private final By FIRST_NAME = By.name("first_name");
    private final By LAST_NAME = By.name("last_name");
    private final By COUNTRY_DROPDOWN = By.cssSelector(".col-md-6 > div > div");
    private final By EGYPT_COUNTRY = By.xpath("//*[@id=\"bs-select-1-63\"]");
    private final By PHONE = By.id("phone");
    private final By USER_EMAIL = By.id("user_email");
    private final By PASSWORD = By.id("password");

    // Actions
    public void userSignUp()
    {
        elementActions.type(FIRST_NAME,"Mahmoud");
        elementActions.type(LAST_NAME,"Soliman");
        elementActions.click(COUNTRY_DROPDOWN).click(EGYPT_COUNTRY);
        elementActions.type(PHONE,"01116226576");
        elementActions.type(USER_EMAIL,"test1223@test.com");
        elementActions.type(PASSWORD,"123456789");
    }
}
