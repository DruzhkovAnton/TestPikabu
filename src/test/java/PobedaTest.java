import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class PobedaTest {
    private WebDriver driver;
    private WebDriverWait wait;
    private WebElement exampleElement;
    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\_GIT\\TestsPikabu\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://pobeda.aero/");
    }
    @Test
    public void testInformationMenu(){
        MainPage mainPage = new MainPage(driver, wait);
        InfoPage infoPage = new InfoPage(driver, wait);

        mainPage.siteIsOpen();
        infoPage.informationMenuIsOpen();
    }
    @Test
    public void testInValidSearchTicket(){
        MainPage mainPage = new MainPage(driver, wait);
        OrderTiketPage orderTiket = new OrderTiketPage(driver, wait);

        mainPage.siteIsOpen();
        orderTiket.searchTiketIsOpen();
        orderTiket.enterSearchCriteria();
        orderTiket.clickButtonSearch();
        orderTiket.checkFieldThere();
    }

    @Test
    public void testBookingManagement(){
        MainPage mainPage = new MainPage(driver, wait);
        BookingManagementPage bookingManagementPage = new BookingManagementPage(driver, wait);

        mainPage.siteIsOpen();
        bookingManagementPage.clickBookingManagementPage();
        bookingManagementPage.bookingManagementPageIsOpen();
        bookingManagementPage.inputData();
        bookingManagementPage.checkErrorOnDisplay();
    }
    @After
    public void tearDown(){
        driver.quit();
    }

}
