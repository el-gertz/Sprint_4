package praktikum;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import praktikum.pages.MainPage;
import praktikum.pages.OrderPage;

public class AdditionalTests {
    @Rule
    public DriverRule factory = new DriverRule();


    @Test
    public void redirectLogoTest() {
        WebDriver driver = factory.getDriver();
        MainPage mainPage = new MainPage(driver);
        OrderPage orderPage = mainPage.openOrderPage();

        orderPage.clickLogoSamokat();

        String expectedURL = EnvConfig.BASE_URL;
        String redirectURL = driver.getCurrentUrl();

        Assert.assertEquals(expectedURL, redirectURL);
    }
}

