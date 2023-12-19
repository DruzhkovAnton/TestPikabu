import com.codeborne.selenide.SelenideElement;
import org.junit.Assert;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class OrderTiketPage {

    private SelenideElement searchTicketButton = $x("//div[contains(@class, 'dp-1glhebn-root-textVisible') and text() = 'Поиск билета']");
    private SelenideElement cityFrom = $("[placeholder='Откуда'][autocomplete='off']");
    private SelenideElement cityIn = $("[placeholder='Куда'][autocomplete='off']");
    private SelenideElement departureDateThere = $("[placeholder='Туда']");
    private SelenideElement departureDateReturn = $("[placeholder='Обратно']");
    private SelenideElement searchButton = $("[type='submit']");
    private SelenideElement dataErorThere = $("[data-errored='true'] [placeholder='Туда']");

    private boolean searchTicketButtonOnDisplay(){
        return searchTicketButton.shouldBe(visible).isDisplayed();
    }

    private boolean cityFromOnDisplay(){
        return cityFrom.shouldBe(visible).isDisplayed();
    }
    private void cityFromInput(String city){
        cityFrom.setValue(city).pressEnter();
    }


    private boolean cityInOnDisplay(){
        return cityIn.shouldBe(visible).isDisplayed();
    }

    private void cityInInput(String city){
        cityIn.setValue(city).pressEnter();
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

    public void searchTiketIsOpen() {
        Assert.assertEquals(this.searchTicketButtonOnDisplay(),true);
        Assert.assertEquals(this.cityFromOnDisplay(),true);
        Assert.assertEquals(this.cityInOnDisplay(),true);
        Assert.assertEquals(this.departureDateThereOnDisplay(),true);
        Assert.assertEquals(this.departureDateReturnOnDisplay(),true);
    }

    public void enterSearchCriteria() {
        cityFromInput("Москва");
        cityInInput("Санкт-Петербург");
    }

    public void clickButtonSearch() {
        searchButton.click();
    }

    public void checkFieldThere() {
        Assert.assertEquals(dataErorThereOnDisplay(),true);
    }
}
