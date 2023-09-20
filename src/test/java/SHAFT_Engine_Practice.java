import com.shaft.driver.SHAFT;
import org.openqa.selenium.remote.Browser;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SHAFT_Engine_Practice {
    SHAFT.GUI.WebDriver driver;
    private String BASE_URL = "https://demo.nopcommerce.com/";

    @BeforeMethod
    public void setUP() {
        SHAFT.Properties.web.set().targetBrowserName(Browser.EDGE.browserName());
        var openAllureReportAfterExecution = SHAFT.Properties.reporting.openAllureReportAfterExecution();
        SHAFT.Properties.reporting.set().openAllureReportAfterExecution(true);
        driver = new SHAFT.GUI.WebDriver();
    }
    @Test
    public void navigateToURL()
    {
        driver.browser().navigateToURL(BASE_URL);

        String currentWindowTitle = driver.browser().getCurrentWindowTitle();

        String currentURL = driver.browser().getCurrentURL();
        driver.verifyThat().browser().url().isEqualTo(currentURL).perform();
        driver.verifyThat().browser().title().isEqualTo("nopCommerce demo store").perform();
        driver.verifyThat().browser().title().contains(currentWindowTitle).perform();
    }
    @AfterTest
    public void tearDown()
    {
        driver.quit();
    }
}
