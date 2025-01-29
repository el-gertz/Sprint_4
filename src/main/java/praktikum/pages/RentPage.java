package praktikum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class RentPage extends MainPage {
    private final WebDriver driver;

    public RentPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    //поле Когда привезти самокат
    private final By dateDelivery = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    //поле Срок аренды
    private final By periodOfRent = By.className("Dropdown-placeholder");
    //значение Двое суток для поля Срок аренды
    private final By periodDvoeSytok = By.xpath("//*[@id='root']/div/div[2]/div[2]/div[2]/div[2]/div[2]");
    //поле Комментарий для курьера
    private final By comment = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    //кнопка Заказать
    private final By submitOrderButton = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    //кнопка Да в модальном окне Хотите оформить заказ?
    private final By okForOrder = By.xpath(".//*[@id='root']/div/div[2]/div[5]/div[2]/button[2]");
    //локатор модального окна Хотите оформить заказ?
    private final By modalOrder = By.xpath(".//div/div/div[2]/div[5]");
    //локатор модального окна Заказ оформлен
    private final By modalOrderSuccess = By.xpath(".//div/div/div[2]/div[5]");

    public void fillRentFields(String dateString, String colorString, String commetString) {
        driver.findElement(dateDelivery).sendKeys(dateString);
        driver.findElement(dateDelivery).sendKeys(Keys.RETURN);
        driver.findElement(periodOfRent).click();
        driver.findElement(periodDvoeSytok).click();
        //Выбор цвета в зависимости от параметра colorString
        driver.findElement(By.xpath(".//input[@id='" + colorString + "']")).click();
        driver.findElement(comment).sendKeys(commetString);
        driver.findElement(submitOrderButton).click();
        waitForLoadElement(modalOrder);
        driver.findElement(modalOrder).isDisplayed();
        driver.findElement(okForOrder).click();
        waitForLoadElement(modalOrderSuccess);
        driver.findElement(modalOrderSuccess).isDisplayed();
    }


}