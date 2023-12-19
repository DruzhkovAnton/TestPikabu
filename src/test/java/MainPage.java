import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.Assert;
import org.openqa.selenium.By;


import java.time.Duration;

import static com.codeborne.selenide.Selenide.*;
import static java.time.Duration.ofSeconds;

public class MainPage {
    private Selenide selenide;

    private SelenideElement logo = $x("//img[contains(@src, 'logo-rus-white')]");

    private String titleTextExpected = "Авиакомпания «Победа» - купить авиабилеты онлайн, дешёвые билеты на самолёт, прямые и трансферные рейсы с пересадками";


    private String titleText(){
        return title();
    }

    private boolean logoOnDisplay(){
        logo.shouldBe(Condition.visible, Duration.ofSeconds(10));
        return logo.isDisplayed();
    }

    public void siteIsOpen(){
        Assert.assertEquals(this.titleText(),titleTextExpected);
        Assert.assertEquals(this.logoOnDisplay(),true);
    }
}
