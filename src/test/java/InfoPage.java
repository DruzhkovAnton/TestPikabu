import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InfoPage {
    private WebDriver driver;
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

    private void moveMouseInformation(){
        Actions action = new Actions(driver);
        action.moveToElement(information).build().perform();
    }

    private boolean informationFlyOnDisplay(){
        return informationFly.isDisplayed();
    }

    private boolean informationUseFulOnDisplay(){
        return informationUseFul.isDisplayed();
    }

    private boolean informationCompanyOnDisplay(){
        return informationCompany.isDisplayed();
    }

    public void informationMenuIsOpen(){
        this.moveMouseInformation();
        Assert.assertEquals(this.informationFlyOnDisplay(),true);
        Assert.assertEquals(this.informationUseFulOnDisplay(),true);
        Assert.assertEquals(this.informationCompanyOnDisplay(),true);
    }
}
