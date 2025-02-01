package praktikum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import praktikum.EnvConfig;

import java.time.Duration;

public class MainPage {

    private final WebDriver driver;

    //куки-кнопка
    private final By cookiesSelector = By.id("rcc-confirm-button");
    //кнопка Заказать вверху страницы
    private final By orderButtonUp = By.xpath(".//div[@class='Header_Nav__AGCXC']/button[@class='Button_Button__ra12g']");
    //кнопка Заказать внизу страницы
    private final By orderButtonDown = By.xpath(".//div[@class='Home_FinishButton__1_cWm']/button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openMainPage() {
        driver.get(EnvConfig.BASE_URL);
        clickCookie();
    }

    public OrderPage openOrderPage() {
        driver.get(EnvConfig.ORDER_URL);
        clickCookie();
        return new OrderPage(driver);
    }

    public OrderPage clickOrderButtonUp() {
        driver.findElement(orderButtonUp).click();
        return new OrderPage(driver);
    }

    public OrderPage clickOnOrderButtonDown() {
        driver.findElement(orderButtonDown).click();
        return new OrderPage(driver);
    }

    // метод ожидания загрузки элемента
    public void waitForLoadElement(By elementId) {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(elementId));
    }

    public void waitAndClick(By selector) {
        waitForLoadElement(selector);
        driver.findElement(selector).click();
    }

    public String clickOnQuestionAndGetText(String question) {
        By questionSelector = By.xpath("//div[@class='accordion__button' and contains(text(), '" + question + "')]");
        waitAndClick(questionSelector);
        return driver.findElement(questionSelector).getText();
    }

    public String findAnswerAndGetText(String answer) {
        By answerSelector = By.xpath("//p[contains(text(),'" + answer + "')]");
        waitForLoadElement(answerSelector);
        return driver.findElement(answerSelector).getText();
    }

    public void clickCookie() {
        waitAndClick(cookiesSelector);
    }

}
