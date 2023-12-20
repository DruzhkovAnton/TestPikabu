import io.qameta.allure.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import io.qameta.allure.Epic;
import io.qameta.allure.Description;

import static com.codeborne.selenide.Selenide.open;

@Epic("Тестирование сайта победа")
public class PobedaTest {
    @Before
    @Step("Перейти на сайт pobeda.aero.")
    public void setUp(){
        open("https://pobeda.aero/");
    }
    @Test
    @DisplayName("проверка блока Информация")
    @Description("проверка блока Информация")
    @Feature("проверка блока Информация")
    public void testInformationMenu(){
        MainPage mainPage = new MainPage();
        InfoPage infoPage = new InfoPage();

        mainPage.siteIsOpen("Авиакомпания «Победа» - купить авиабилеты онлайн, дешёвые билеты на самолёт, прямые и трансферные рейсы с пересадками");
        infoPage.mouseOverOnInformation();
        infoPage.informationMenuIsOpen();
    }
    @Test
    @DisplayName("Проверка блока поиска билетов")
    @Description("Проверка блока поиска билетов")
    @Feature("Проверка блока поиска билетов")
    public void testInValidSearchTicket(){
        MainPage mainPage = new MainPage();
        OrderTiketPage orderTiket = new OrderTiketPage();

        mainPage.siteIsOpen("Авиакомпания «Победа» - купить авиабилеты онлайн, дешёвые билеты на самолёт, прямые и трансферные рейсы с пересадками");
        orderTiket.searchTiketIsOpen();
        orderTiket.enterSearchCriteria();
        orderTiket.clickButtonSearch();
        orderTiket.checkFieldThere();
    }

    @Test
    @DisplayName("Проверка блока Управление бронированием")
    @Description("Проверка блока Управление бронированием")
    @Feature("Проверка блока Управление бронированием")
    public void testBookingManagement(){
        MainPage mainPage = new MainPage();
        BookingManagementPage bookingManagementPage = new BookingManagementPage();

        mainPage.siteIsOpen("Авиакомпания «Победа» - купить авиабилеты онлайн, дешёвые билеты на самолёт, прямые и трансферные рейсы с пересадками");
        bookingManagementPage.clickBookingManagementPage();
        bookingManagementPage.bookingManagementPageIsOpen();
        bookingManagementPage.inputData();
        bookingManagementPage.checkErrorOnDisplay();
    }

    @Test
    @DisplayName("Проверка блока Управление бронированием")
    @Description("Проверка блока Управление бронированием с ошибкой в проверке заголовка")
    @Feature("Проверка блока Управление бронированием")
    public void testBookingManagementError(){
        MainPage mainPage = new MainPage();
        BookingManagementPage bookingManagementPage = new BookingManagementPage();

        mainPage.siteIsOpen("Авиакомпания «Победа» - купить авиабилеты онлайн, дешёвые билеты на самолёт, прямые и трансферные рейсы с пересадками123");
        bookingManagementPage.clickBookingManagementPage();
        bookingManagementPage.bookingManagementPageIsOpen();
        bookingManagementPage.inputData();
        bookingManagementPage.checkErrorOnDisplay();
    }

}