package praktikum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderPage {
    private final WebDriver driver;

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    //поле Имя
    private final By nameField = By.xpath(".//input[@placeholder='* Имя']");
    //поле Фамилия
    private final By surnameField = By.xpath(".//input[@placeholder='* Фамилия']");
    //поле Адрес
    private final By addressField = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    //поле Станция метро
    private final By stationField = By.className("select-search__input");
    //значение Сокольники из выпадающего списка станции метро
    private final By stationSokolniki = By.xpath(".//button[@value='4']");
    //поле Телефон
    private final By telefoneField = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    //кнопка Далее
    private final By nextButton = By.xpath(".//div[@class='Order_NextButton__1_rCA']/button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    //лого Самокат
    private final By linkToSamokat = By.className("Header_LogoScooter__3lsAR");

    public void fillClientFields(String name, String surname, String address, String telefone) {
        driver.findElement(nameField).sendKeys(name);
        driver.findElement(surnameField).sendKeys(surname);
        driver.findElement(addressField).sendKeys(address);
        driver.findElement(stationField).click();
        driver.findElement(stationSokolniki).click();
        driver.findElement(telefoneField).sendKeys(telefone);
    }

    public RentPage clickNextButton() {
        driver.findElement(nextButton).click();
        return new RentPage(driver);
    }

    public MainPage clickLogoSamokat() {
        driver.findElement(linkToSamokat).click();
        return new MainPage(driver);
    }

}