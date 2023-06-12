package PageObjects;

import core.SingletonBrowserClass;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static PageObjects.GeneralPage.generalPage;

public class StartPage  {
    public static final StartPage startPage = new StartPage();

    SingletonBrowserClass singletonBrowserClass = SingletonBrowserClass.getInstanceOfSingletonBrowserClass();
    WebDriver driver = singletonBrowserClass.getDriver();

    public static final By newEntries = By.xpath("//h2[contains(text(),'Neue Beiträge')]");

    @Step("Prüfe, ob der Text 'Neue Beiträge' angezeigt wird")
    public void checkHeaderContributionsIsShown(){
        generalPage.waitUntilElementClickable(driver.findElement(newEntries),10).isDisplayed();
    }
}
