import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.junit.Assert;
import java.time.Duration;
import static com.codeborne.selenide.Selenide.$;

public class InfoPage {

    private SelenideElement information = $("[href='/information']");
    private SelenideElement informationFly = $("[href='/information#flight']");
    private SelenideElement informationUseFul = $("[href='/information#useful']");
    private SelenideElement informationCompany = $("[href='/information#company']");

    private void moveMouseInformation(){
        information.hover().shouldBe(Condition.visible,Duration.ofSeconds(10));
    }

    private boolean informationFlyOnDisplay(){
        informationFly.shouldBe(Condition.visible,Duration.ofSeconds(10));
        return informationFly.isDisplayed();
    }

    private boolean informationUseFulOnDisplay(){
        informationUseFul.shouldBe(Condition.visible,Duration.ofSeconds(10));
        return informationUseFul.isDisplayed();
    }

    private boolean informationCompanyOnDisplay(){
        informationCompany.shouldBe(Condition.visible,Duration.ofSeconds(10));
        return informationCompany.isDisplayed();
    }

    public void informationMenuIsOpen(){
        this.moveMouseInformation();
        Assert.assertEquals(this.informationFlyOnDisplay(),true);
        Assert.assertEquals(this.informationUseFulOnDisplay(),true);
        Assert.assertEquals(this.informationCompanyOnDisplay(),true);
    }
}
