package gui.phptravels.tests;

import com.shaft.driver.DriverFactory;
import com.shaft.gui.browser.BrowserActions;
import com.shaft.gui.element.ElementActions;
import gui.phptravels.pages.HomePage;
import gui.phptravels.pages.LoginPage;
import gui.phptravels.pages.SignUpPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SignUp_POM {
    private WebDriver driver;
    private HomePage homePage;
    private SignUpPage signUpPage;
    private LoginPage loginPage;
    private BrowserActions browserActions;
    private ElementActions elementActions;

    // Define constants for URLs and locators
    private static final String BASE_URL = "https://phptravels.net/";
    private static final By ACCOUNT_LINK = By.cssSelector(".nav-item--right > ul > li:nth-of-type(3)");
    private static final By SIGN_UP_BUTTON = By.xpath("//*[@class=\"nav-item--right\"]/ul/li[3]/ul/li[2]");

    @BeforeClass
    public void setUp()
    {
        driver = DriverFactory.getDriver(DriverFactory.DriverType.CHROME);
        elementActions = new ElementActions();
        browserActions = new BrowserActions();
        browserActions.navigateToURL(BASE_URL);
        browserActions.verifyThat().title().contains("PHPTRAVELS").perform();
        homePage = new HomePage(driver);
        signUpPage = new SignUpPage(driver);
        loginPage = new LoginPage(driver);
    }
    @Test
    public void navigateSignUpPage()
    {
        homePage.navigateToSignUpPage();
        signUpPage.userSignUp();
    }
    @Test
    public void navigateToLoginPage()
    {
        homePage.navigateToLoginPage();
        loginPage.userLogInSteps();
    }
    @AfterTest(alwaysRun = true)
    public void afterClass()
    {
        driver.quit();
    }

}
