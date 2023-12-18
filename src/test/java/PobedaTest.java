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
        wait = new WebDriverWait(driver, Duration.ofMillis(10));
    }

    @Test
    public void pobedaTestSwitchLang(){
        driver.get("https://www.google.com");
        driver.findElement(By.cssSelector("[title='Поиск']")).sendKeys("Сайт компании Победа");
        driver.findElement(By.cssSelector("[title='Поиск']")).sendKeys(Keys.ENTER);
        driver.findElement(By.cssSelector("h3")).click();

        custoWaitElement(driver.findElement(By.xpath("//div[text()='Полетели в Сочи!']")));
        Assert.assertEquals(driver.findElement(By.xpath("//div[text()='Полетели в Сочи!']")).getText(), "Полетели в Сочи!");

        List<WebElement> elements = new ArrayList<>();
        elements = driver.findElements(By.cssSelector(".dp-1c04wlv-root-root"));
        elements.get(0).click();
        custoWaitElement(driver.findElement(By.xpath("//div[text()='English']")));
        driver.findElement(By.xpath("//div[text()='English']")).click();

        List<String> engTextActual = new ArrayList<>();
        List<String> engTextExpected = Arrays.asList("Ticket search", "Online check-in", "Manage my booking");

        elements = driver.findElements(By.cssSelector(".dp-1glhebn-root-textVisible"));
        for (int i=0;i<elements.size();i++){
            WebElement elem = elements.get(i);
            wait.until(ExpectedConditions.textToBePresentInElement(elem,engTextExpected.get(i)));
            Assert.assertEquals(elements.get(i).getText(), engTextExpected.get(i));
        }
    }

    private void custoWaitElement(WebElement element) {
        float minTime = 0;
        float maxTime = 2000;
        long startLoadingTimme = System.currentTimeMillis();

        while (element.isDisplayed()){
            if(minTime <= maxTime){
                minTime = System.currentTimeMillis() - startLoadingTimme;
            }else{
                System.out.println("елемент загрузился за "+minTime+" мс");
                break;
            }
            if(!element.isDisplayed()) {
                System.out.println("елемент не загрузился за "+minTime+" мс");
            }

        }
    }

    @After
    public void tearDown(){
        driver.quit();
    }

}
