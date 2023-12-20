import io.qameta.allure.Description;
import io.qameta.allure.TmsLink;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static com.codeborne.selenide.Selenide.open;

public class PobedaTest {
    @Before
    public void setUp(){
        open("https://pobeda.aero/");
    }
    @Test
    @TmsLink("test1")
    @DisplayName("123")
    @Description("123123")
    public void testInformationMenu(){
        MainPage mainPage = new MainPage();
        InfoPage infoPage = new InfoPage();

        mainPage.siteIsOpen();
        infoPage.informationMenuIsOpen();
    }
    @Test
    @TmsLink("test2")
    @DisplayName("123")
    @Description("123123")
    public void testInValidSearchTicket(){
        MainPage mainPage = new MainPage();
        OrderTiketPage orderTiket = new OrderTiketPage();

        mainPage.siteIsOpen();
        orderTiket.searchTiketIsOpen();
        orderTiket.enterSearchCriteria();
        orderTiket.clickButtonSearch();
        orderTiket.checkFieldThere();
    }

    @Test
    @TmsLink("test3")
    @DisplayName("123")
    @Description("123123")
    public void testBookingManagement(){
        MainPage mainPage = new MainPage();
        BookingManagementPage bookingManagementPage = new BookingManagementPage();

        mainPage.siteIsOpen();
        bookingManagementPage.clickBookingManagementPage();
        bookingManagementPage.bookingManagementPageIsOpen();
        bookingManagementPage.inputData();
        bookingManagementPage.checkErrorOnDisplay();
    }

}