import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.Instant;

public class InfoPage {
    private WebDriver driver;
    private WebDriverWait wait;
    @FindBy(css = "[href='/information']")
    private WebElement information;
    @FindBy(css = "[href='/information#flight']")
    private WebElement informationFly;
    @FindBy(css = "[href='/information#useful']")
    private WebElement informationUseFul;
    @FindBy(css = "[href='/information#company']")
    private WebElement informationCompany;
    public InfoPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public InfoPage(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }



    private void moveMouseInformation(){
        Actions action = new Actions(driver);
        action.moveToElement(information).build().perform();
        wait.until(ExpectedConditions.visibilityOf(information));
    }

    private boolean informationFlyOnDisplay(){
        wait.until(ExpectedConditions.visibilityOf(informationFly));
        return informationFly.isDisplayed();
    }

    private boolean informationUseFulOnDisplay(){
        wait.until(ExpectedConditions.visibilityOf(informationUseFul));
        return informationUseFul.isDisplayed();
    }

    private boolean informationCompanyOnDisplay(){
        wait.until(ExpectedConditions.visibilityOf(informationCompany));
        return informationCompany.isDisplayed();
    }

    public void informationMenuIsOpen(){
        this.moveMouseInformation();
        Assert.assertEquals(this.informationFlyOnDisplay(),true);
        Assert.assertEquals(this.informationUseFulOnDisplay(),true);
        Assert.assertEquals(this.informationCompanyOnDisplay(),true);
    }
}
