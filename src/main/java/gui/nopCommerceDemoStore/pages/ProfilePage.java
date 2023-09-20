package gui.nopCommerceDemoStore.pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class ProfilePage {
    private SHAFT.GUI.WebDriver driver;
    private static final By LOG_OUT = By.className("ico-logout");
    private static final By MY_ACCOUNT = By.className("ico-account");

    private static final By BAR_NOTIFICATION = By.id("bar-notification");
    private static final By PRODUCT = By.xpath("//*[@data-productid='18']/div[2]/div[3]/div[2]");

    // constructor
    public ProfilePage(SHAFT.GUI.WebDriver driver)
    {
        this.driver=driver;
    }
    public void addProductToCart()
    {
        driver.element().click(PRODUCT);
        driver.verifyThat().element(BAR_NOTIFICATION).isVisible().perform();
        String notification = driver.element().getText(BAR_NOTIFICATION);
        driver.verifyThat().element(BAR_NOTIFICATION).text().contains(notification);
    }


}
