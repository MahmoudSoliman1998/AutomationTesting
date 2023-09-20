package gui.nopCommerceDemoStore.pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class LoginPage {
    // Define driver
    private SHAFT.GUI.WebDriver driver;

    // Define Locators
    private static final By EMAIL = By.id("Email");
    private static final By PASSWORD = By.id("Password");
    private static final By REMEMBER_ME = By.id("RememberMe");
    private static final By SUBMIT_LOGIN = By.xpath("//*[@class=\"customer-blocks\"]/div[2]/form/div[3]/button");

    // Constructor
    public LoginPage(SHAFT.GUI.WebDriver driver)
    {
        this.driver = driver;
    }
    public void Login(String email, String password)
    {
        driver.element().type(EMAIL,email);
        driver.element().type(PASSWORD,password);
        driver.element().click(REMEMBER_ME);
        driver.element().click(SUBMIT_LOGIN);
    }

}
