import org.junit.Before;
import org.junit.Test;
import static com.codeborne.selenide.Selenide.open;

public class PobedaTest {
    @Before
    public void setUp(){
        open("https://pobeda.aero/");
    }
    @Test
    public void testInformationMenu(){
        MainPage mainPage = new MainPage();
        InfoPage infoPage = new InfoPage();

        mainPage.siteIsOpen();
        infoPage.informationMenuIsOpen();
    }
    @Test
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
