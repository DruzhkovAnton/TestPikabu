import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
//import io.qameta.allure.Step;
import io.qameta.allure.Step;
import org.junit.Assert;
import java.time.Duration;
import static com.codeborne.selenide.Selenide.$;

public class InfoPage {

    private final SelenideElement information = $("[href='/information']");
    private final SelenideElement informationFly = $("[href='/information#flight']");
    private final SelenideElement informationUseFul = $("[href='/information#useful']");
    private final SelenideElement informationCompany = $("[href='/information#company']");

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

    @Step("Навести мышку на пункт «Информация»")
    public void mouseOverOnInformation(){
        this.moveMouseInformation();
    }
    @Step("Убедиться, что появилось всплывающее окно")
    public void informationMenuIsOpen(){
        Assert.assertTrue(this.informationFlyOnDisplay());
        Assert.assertTrue(this.informationUseFulOnDisplay());
        Assert.assertTrue(this.informationCompanyOnDisplay());
    }
}
