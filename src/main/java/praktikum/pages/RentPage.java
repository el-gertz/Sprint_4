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
    private final By periodDvoeSytok = By.xpath("//div[@class='Dropdown-option' and contains(text(),'двое суток')]");
    //поле Комментарий для курьера
    private final By comment = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    //кнопка Заказать
    private final By submitOrderButton = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    //кнопка Да в модальном окне Хотите оформить заказ?
    private final By okForOrder = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and contains(text(),'Да')]");
    //локатор модального окна Хотите оформить заказ?
    private final By modalOrder = By.xpath("//div[contains(text(), 'Хотите оформить заказ?')]");
    //локатор модального окна Заказ оформлен
    private final By modalOrderSuccess = By.xpath(".//div[@class='Order_ModalHeader__3FDaJ' and contains(text(),'Заказ оформлен')]");

    public Boolean fillRentFields(String dateString, String colorString, String commetString) {
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
        return driver.findElement(modalOrderSuccess).isDisplayed();
    }


}