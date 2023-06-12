import core.SingletonBrowserClass;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;

import static PageObjects.ContactPage.contactPage;
import static PageObjects.GeneralPage.generalPage;
import static PageObjects.StartPage.startPage;

public class FirstTestCase {

    SingletonBrowserClass singletonBrowserClass = SingletonBrowserClass.getInstanceOfSingletonBrowserClass();
    WebDriver driver = singletonBrowserClass.getDriver();

    @Test
    @Description("Erster Testfall")
    @Feature("Aufruf Kontaktseite")
    @Epic("Selenium Webtestingseite")
    @Tag("MyFirstTest")
    public void firstTestCase(){
        System.out.println("FirstTest");
        generalPage.doOpenBrowserWithLink("http://selenium.webtesting.eu/");
        startPage.checkHeaderContributionsIsShown();
        generalPage.clickOnElementWithId("menu-item-134");
        generalPage.assertTabTitle("Testseite-Kontaktformular – Selenium");
        contactPage.checkBusinessIsChecked();
        contactPage.checkPrivateIsNotChecked();
    }

    @Test
    @Description("Zweiter Testfall")
    @Feature("Aufruf zweiter Test")
    @Epic("Selenium Webtestingseite")
    @Tag("MySecondTestcase")
    public void secondTestCase(){
        System.out.println("SecondTest");
        generalPage.doOpenBrowserWithLink("http://selenium.webtesting.eu/");
        startPage.checkHeaderContributionsIsShown();
        generalPage.clickOnElementWithId("menu-item-141");
    }

    @BeforeEach
    public void browserOptions(){
        driver.manage().window().maximize();
    }

    @AfterEach
    public void tearDown() {
        if(driver!=null){
            driver.quit();
        }
    }
}
