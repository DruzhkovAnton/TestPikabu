import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HelperPage {
    private WebDriver driver;
    public HelperPage(WebDriver driver){
        this.driver = driver;
    }
    public void custoWaitElement(WebElement element) {
        float minTime = 0;
        float maxTime = 2000;
        long startLoadingTimme = System.currentTimeMillis();

        while (element.isDisplayed()) {
            if (minTime <= maxTime) {
                minTime = System.currentTimeMillis() - startLoadingTimme;
            } else {
                System.out.println("елемент загрузился за " + minTime + " мс");
                break;
            }
            if (!element.isDisplayed()) {
                System.out.println("елемент не загрузился за " + minTime + " мс");
            }

        }
    }
}
