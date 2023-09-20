package gui.nopCommerceDemoStore.pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class HomePage {
    // Objects
    private SHAFT.GUI.WebDriver driver;

    // Define Elements
    private static final By REGISTER_BUTTON = By.className("ico-register");
    private static final By LOGIN_BUTTON = By.className("ico-login");
    public HomePage(SHAFT.GUI.WebDriver driver)
    {
        this.driver = driver;
    }

    public void navigateToRegisterPage()
    {
        driver.element().click(REGISTER_BUTTON);
    }
    public void navigateToLoginPage()
    {
        driver.element().click(LOGIN_BUTTON);
    }
}
