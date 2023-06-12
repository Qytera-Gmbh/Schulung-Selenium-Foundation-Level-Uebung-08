package PageObjects;

import core.SingletonBrowserClass;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GeneralPage    {
    public static final GeneralPage generalPage = new GeneralPage();

    SingletonBrowserClass singletonBrowserClass = SingletonBrowserClass.getInstanceOfSingletonBrowserClass();
    WebDriver driver = singletonBrowserClass.getDriver();
    @Step("Öffne die Url {url}")
    public void doOpenBrowserWithLink(String url){
        driver.get(url);
    }

    @Step("Klicke auf das Element mit der id: {id}")
    public void clickOnElementWithId(String id){
        driver.findElement(By.id(id)).click();
    }

    @Step("Prüfe ob der Tabtitle {title} enthält")
    public void assertTabTitle(String title){
        Assertions.assertTrue(driver.getTitle().contains(title));
    }

    @Step("Ich warte bis das Element klickbar ist")
    public WebElement waitUntilElementClickable(WebElement e, int duration){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
        wait.until(ExpectedConditions.elementToBeClickable(e));
        return e;
    }
}
