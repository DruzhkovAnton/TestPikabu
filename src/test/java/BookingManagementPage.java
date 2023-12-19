import com.codeborne.selenide.SelenideElement;
import org.junit.Assert;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class BookingManagementPage {
    private SelenideElement bookingManagementButton = $x("//div[contains(@class, 'dp-1glhebn-root-textVisible') and text() = 'Управление бронированием']");
    private SelenideElement surnameClient = $("[placeholder='Фамилия клиента']");
    private SelenideElement orderNumber = $("[placeholder='Номер заказа или билета']");
    private SelenideElement searchButton = $x("//button[text()='Поиск']");
    private SelenideElement errorMessage = $x("//div[text()='Некорректный номер']");


    private boolean errorMessageOnDisplay(){
        return errorMessage.shouldBe(visible).isDisplayed();
    }

    private boolean searchButtonOnDisplay(){
        return searchButton.shouldBe(visible).isDisplayed();
    }

    private boolean surnameClientOnDisplay(){
        return surnameClient.shouldBe(visible).isDisplayed();
    }

    private boolean orderNumberOnDisplay(){
        return orderNumber.shouldBe(visible).isDisplayed();
    }

    private void surnameClientInput(String surname){
        surnameClient.setValue(surname);
    }

    private void orderNumberInput(String order){
        orderNumber.setValue(order);
    }


    public void clickBookingManagementPage() {
        bookingManagementButton.click();
    }

    public void bookingManagementPageIsOpen() {
        Assert.assertEquals(surnameClientOnDisplay(),true);
        Assert.assertEquals(orderNumberOnDisplay(),true);
        Assert.assertEquals(searchButtonOnDisplay(),true);
    }

    public void inputData() {
        surnameClientInput("qwerty");
        orderNumberInput("XXXXXXXX");
        searchButton.click();
    }

    public void checkErrorOnDisplay() {
        Assert.assertEquals(errorMessageOnDisplay(),true);
    }
}
