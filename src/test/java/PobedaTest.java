import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.sql.Array;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
        OrderTiket orderTiket = new OrderTiket(driver, wait);

        mainPage.siteIsOpen();
        orderTiket.searchTiketIsOpen();
        orderTiket.enterSearchCriteria();
        orderTiket.clickButtonSearch();
        orderTiket.checkFieldThere();
    }
    @After
    public void tearDown(){
        driver.quit();
    }

}
