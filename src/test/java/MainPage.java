import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.junit.Assert;



import java.time.Duration;

import static com.codeborne.selenide.Selenide.*;

public class MainPage {
    private final SelenideElement logo = $x("//img[contains(@src, 'logo-rus-white')]");


    private String titleText(){
        return title();
    }

    private boolean logoOnDisplay(){
        logo.shouldBe(Condition.visible, Duration.ofSeconds(10));
        return logo.isDisplayed();
    }

    @Step("")
    public void siteIsOpen(){
        String titleTextExpected = "Авиакомпания «Победа» - купить авиабилеты онлайн, дешёвые билеты на самолёт, прямые и трансферные рейсы с пересадками";
        Assert.assertEquals(this.titleText(), titleTextExpected);
        Assert.assertTrue(this.logoOnDisplay());
    }
}
