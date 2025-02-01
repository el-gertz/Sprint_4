package praktikum;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import praktikum.pages.MainPage;

public class CreateOrderTest {

    @Rule
    public DriverRule factory = new DriverRule();

    @Test
    public void upOrderButtonTest() {
        WebDriver driver = factory.getDriver();
        MainPage page = new MainPage(driver);
        page.openMainPage();

        page.clickOrderButtonUp();
        String expectedURL = EnvConfig.ORDER_URL;
        String actualURL = driver.getCurrentUrl();

        Assert.assertEquals(expectedURL, actualURL);
    }

    @Test
    public void downOrderButtonTest() {
        WebDriver driver = factory.getDriver();
        MainPage page = new MainPage(driver);
        page.openMainPage();

        page.clickOnOrderButtonDown();
        String expectedURL = EnvConfig.ORDER_URL;
        String actualURL = driver.getCurrentUrl();

        Assert.assertEquals(expectedURL, actualURL);
    }

}
