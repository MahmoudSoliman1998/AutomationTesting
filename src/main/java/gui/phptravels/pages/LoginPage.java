package gui.phptravels.pages;

import com.shaft.gui.element.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    // Define objects
    private WebDriver driver;
    private ElementActions elementActions;

    // Define constants locators
    private static final By EMAIL_ADDRESS = By.id("email");
    private static final By PASSWORD = By.id("password");
    private static final By REMEMBER_ME = By.xpath("//input[@id='rememberchb']");
    private static final By RESET_PASSWORD = By.xpath("//*[@data-bs-target='#reset']");
    private static final By SUBMIT_BUTTON = By.id("submitBTN");
    private static final By SIGNUP_BUTTON = By.cssSelector(".col-md-12 > a");
    private static final By SIGN_IN_WITH_GOOGLE = By.xpath("//span[@class='nsm7Bb-HzV7m-LgbsSe-BPrWId']");
    //Constructor
    public LoginPage(WebDriver driver)
    {
        this.driver = driver;
        this.elementActions = new ElementActions();
    }

    // Actions
    public void userLogInSteps()
    {
        elementActions.clear(EMAIL_ADDRESS);
        elementActions.type(EMAIL_ADDRESS,"test1223@test.com");
        elementActions.type(PASSWORD,"123456789");
        elementActions.click(REMEMBER_ME);
    }

}
