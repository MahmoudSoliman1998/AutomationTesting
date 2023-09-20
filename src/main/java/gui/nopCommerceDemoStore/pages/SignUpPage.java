package gui.nopCommerceDemoStore.pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class SignUpPage {
    // Define Objects
    private SHAFT.GUI.WebDriver driver;

    // Define Locators
    private static final By GENDER_MALE = By.id("gender-male");
    private static final By GENDER_FEMALE = By.className("female");
    private static final By FIRST_NAME = By.id("FirstName");
    private static final By LAST_NAME = By.id("LastName");
    private static final By EMAIL = By.id("Email");
    private static final By COMPANY_NAME = By.id("Company");
    private static final By NEWS_LETTER = By.id("Newsletter");
    private static final By PASSWORD = By.id("Password");
    private static final By CONFIRM_PASSWORD = By.id("ConfirmPassword");
    private static final By SUBMIT_REGISTRATION = By.id("register-button");
    private static final By CONTINUE_BUTTON = By.cssSelector(".page-body > .buttons > a");
    // Constructor
    public SignUpPage(SHAFT.GUI.WebDriver driver)
    {
        this.driver = driver;
    }
    public void registration()
    {
        driver.element().click(GENDER_MALE);
        driver.verifyThat().element(GENDER_MALE).isChecked().perform();

        driver.element().type(FIRST_NAME,"Mahmoud");
        driver.element().type(LAST_NAME,"Soliman");
        driver.element().type(EMAIL,"test125@test.com");
        driver.element().type(COMPANY_NAME,"QA Egypt");
        driver.element().type(PASSWORD,"223334444");
        driver.element().type(CONFIRM_PASSWORD,"223334444");
        driver.element().verifyThat(NEWS_LETTER).isSelected().perform();
        driver.element().click(SUBMIT_REGISTRATION);
        driver.element().waitToBeInvisible(By.cssSelector(".page-body > .result"));
        driver.verifyThat().element(By.cssSelector(".page-body > .result")).text().contains("Your registration completed").perform();
        driver.verifyThat().element(CONTINUE_BUTTON).isVisible().perform();
        driver.element().click(CONTINUE_BUTTON);


    }
}
