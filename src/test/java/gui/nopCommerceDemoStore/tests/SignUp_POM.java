package gui.nopCommerceDemoStore.tests;

import com.shaft.driver.DriverFactory;
import com.shaft.driver.SHAFT;
import gui.nopCommerceDemoStore.pages.HomePage;
import gui.nopCommerceDemoStore.pages.LoginPage;
import gui.nopCommerceDemoStore.pages.ProfilePage;
import gui.nopCommerceDemoStore.pages.SignUpPage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SignUp_POM {
    private SHAFT.GUI.WebDriver driver;
    private SHAFT.TestData.JSON testDate;
    private HomePage homePage;
    private SignUpPage signUpPage;
    private ProfilePage profilePage;
    private LoginPage loginPage;
    private final String BASE_URL = "https://demo.nopcommerce.com/";
    String user_email;
    String user_password;
    @BeforeTest
    public void setUP()
    {
        // Open the Browser
        driver = new SHAFT.GUI.WebDriver(DriverFactory.DriverType.CHROME);
        testDate = new SHAFT.TestData.JSON("simpleJSON.json");
        // Open Web Application
        driver.browser().navigateToURL(BASE_URL);

        // Initialize objects
        homePage = new HomePage(driver);
        signUpPage = new SignUpPage(driver);
        profilePage = new ProfilePage(driver);
        loginPage = new LoginPage(driver);
    }
    @Test
    public void OpenApp()
    {
        driver.browser().navigateToURL(BASE_URL);
        driver.verifyThat().browser().url().isEqualTo(driver.browser().getCurrentURL()).perform();

        homePage.navigateToRegisterPage();
        driver.verifyThat().browser().url().contains("register").perform();
        driver.browser().navigateBack();

        homePage.navigateToLoginPage();
        driver.verifyThat().browser().title().contains("Login").perform();
        driver.browser().navigateBack();

    }
    @Test
    public void testRegistrationPage()
    {
        driver.browser().navigateToURL(BASE_URL);
        homePage.navigateToRegisterPage();
        signUpPage.registration();
    }
    @Test
    public void addToCart()
    {
        driver.browser().navigateToURL(BASE_URL);
        profilePage.addProductToCart();
    }
    @Test
    public void testLoginPage()
    {
        user_email = testDate.getTestData("emailAddress");
        user_password = testDate.getTestData("password");
        homePage.navigateToLoginPage();
        loginPage.Login(user_email,user_password);
    }
    @AfterTest
    public void tearDown()
    {
        driver.quit();
    }
}
