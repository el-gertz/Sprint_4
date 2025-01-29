package praktikum;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import praktikum.pages.MainPage;
import praktikum.pages.OrderPage;
import praktikum.pages.RentPage;

@RunWith(Parameterized.class)
public class ParametrizedCreateOrderTest {

    private final String name;
    private final String surname;
    private final String address;
    private final String telefone;
    private final String date;
    private final String color;
    private final String comment;

    public ParametrizedCreateOrderTest(
            String name,
            String surname,
            String address,
            String telefone,
            String date,
            String color,
            String comment
    ) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.telefone = telefone;
        this.date = date;
        this.color = color;
        this.comment = comment;
    }

    @Parameterized.Parameters
    public static Object[][] CreateOrderParams() {
        return new Object[][]{
                {"Поп", "Попов", "Уличная, 23", "88005553535", "28.01.2024", "black", "comment"},
                {"Маша", "Иванова", "Заграничная, 3", "89123530408", "01.02.2025", "grey", "no comment"}
        };
    }

    @Rule
    public DriverRule factory = new DriverRule();

    @Test
    public void fullFlowTest() {
        WebDriver driver = factory.getDriver();
        MainPage page = new MainPage(driver);
        page.openMainPage();

        OrderPage orderPage = page.clickOrderButtonUp();

        orderPage.fillClientFields(name, surname, address, telefone);
        RentPage rentPage = orderPage.clickNextButton();
        rentPage.fillRentFields(date, color, comment);
    }

}
