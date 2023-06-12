package PageObjects;

import core.SingletonBrowserClass;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class ContactPage {
    public static final ContactPage contactPage = new ContactPage();

    SingletonBrowserClass singletonBrowserClass = SingletonBrowserClass.getInstanceOfSingletonBrowserClass();
    WebDriver driver = singletonBrowserClass.getDriver();

    @Step("Prüfe ob die Business Checkbox ausgewählt ist")
    public void checkBusinessIsChecked(){
        List<WebElement> radioButton = driver.findElements(By.name("your-customer-type"));
        for (WebElement e: radioButton) {
            if(e.getAttribute("value").equals("Business")){
                Assertions.assertTrue(e.isSelected());
            }
        }
    }

    @Step("Prüfe das die Privat Checkbox nicht ausgewählt ist")
    public void checkPrivateIsNotChecked(){
        List<WebElement> radioButton = driver.findElements(By.name("your-customer-type"));
        for (WebElement e: radioButton) {
            if(e.getAttribute("value").equals("Private")){
                Assertions.assertFalse(e.isSelected());
            }
        }
    }
}
