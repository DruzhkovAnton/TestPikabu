import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.junit.Assert;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class OrderTiketPage {

    private final SelenideElement searchTicketButton = $x("//div[contains(@class, 'dp-1glhebn-root-textVisible') and text() = 'Поиск билета']");
    private final SelenideElement cityFrom = $("[placeholder='Откуда'][autocomplete='off']");
    private final SelenideElement cityIn = $("[placeholder='Куда'][autocomplete='off']");
    private final SelenideElement departureDateThere = $("[placeholder='Туда']");
    private final SelenideElement departureDateReturn = $("[placeholder='Обратно']");
    private final SelenideElement searchButton = $("[type='submit']");
    private final SelenideElement dataErorThere = $("[data-errored='true'] [placeholder='Туда']");

    private boolean searchTicketButtonOnDisplay(){
        return searchTicketButton.shouldBe(visible).isDisplayed();
    }

    private boolean cityFromOnDisplay(){
        return cityFrom.shouldBe(visible).isDisplayed();
    }
    private void cityFromInput(){
        cityFrom.setValue("Москва").pressEnter();
    }


    private boolean cityInOnDisplay(){
        return cityIn.shouldBe(visible).isDisplayed();
    }

    private void cityInInput(){
        cityIn.setValue("Санкт-Петербург").pressEnter();
    }

    private boolean departureDateThereOnDisplay(){
        return departureDateThere.shouldBe(visible).isDisplayed();
    }

    private boolean departureDateReturnOnDisplay(){
        return departureDateReturn.shouldBe(visible).isDisplayed();
    }

    private boolean dataErorThereOnDisplay(){
        return dataErorThere.shouldBe(visible).isDisplayed();
    }

    @Step("123")
    public void searchTiketIsOpen() {
        Assert.assertTrue(this.searchTicketButtonOnDisplay());
        Assert.assertTrue(this.cityFromOnDisplay());
        Assert.assertTrue(this.cityInOnDisplay());
        Assert.assertTrue(this.departureDateThereOnDisplay());
        Assert.assertTrue(this.departureDateReturnOnDisplay());
    }
    @Step("123123")
    public void enterSearchCriteria() {
        cityFromInput();
        cityInInput();
    }
    @Step("123123123")
    public void clickButtonSearch() {
        searchButton.click();
    }
    @Step("312312")
    public void checkFieldThere() {
        Assert.assertTrue(dataErorThereOnDisplay());
    }
}
