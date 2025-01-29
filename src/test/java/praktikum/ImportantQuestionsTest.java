package praktikum;

import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import praktikum.pages.MainPage;

import static org.junit.Assert.assertEquals;


public class ImportantQuestionsTest {

    @Rule
    public DriverRule factory = new DriverRule();

    @Test
    public void importantQuestionsTest() {
        WebDriver driver = factory.getDriver();

        MainPage page = new MainPage(driver);
        page.openMainPage();

        //ожидаемый результат
        String expectedFirstAnswer = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
        String expectedSecondAnswer = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";

        //фактический результат
        String actualFirstAnswer = page.clickOnFirstQuestionAndGetText();
        String actualSecondAnswer = page.clickOnSecondQuestionAndGetText();

        //сравнение ожидаемого с фактическим
        assertEquals(expectedFirstAnswer, actualFirstAnswer);
        assertEquals(expectedSecondAnswer, actualSecondAnswer);
    }
}