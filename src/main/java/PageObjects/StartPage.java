package PageObjects;

import core.GeneralHelper;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class StartPage extends GeneralHelper {
    public static final StartPage startPage = new StartPage();
    public static StartPage getInstance(){
        return startPage;
    }

    public static final By newEntries = By.xpath("//h2[contains(text(),'Neue Beiträge')]");

    @Step("Prüfe das der Text Neue Beiträge angezeigt wird")
    public void checkHeaderContributionsIsShown(){
        WebElement text = generalPage.waitUntilElementClickable(driver.findElement(newEntries),10);
        Assertions.assertTrue(text.isDisplayed());
    }
}
