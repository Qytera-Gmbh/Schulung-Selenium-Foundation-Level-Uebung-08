import com.tngtech.junit.dataprovider.*;
import core.SingletonBrowserClass;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;

import static PageObjects.GeneralPage.generalPage;
import static org.junit.jupiter.api.TestInstance.*;

@ExtendWith({UseDataProviderExtension.class, DataProviderExtension.class})
@Epic("DataTestEpic")
public class DataDrivenTest {

    SingletonBrowserClass singletonBrowserClass = SingletonBrowserClass.getInstanceOfSingletonBrowserClass();
    WebDriver driver = singletonBrowserClass.getDriver();

    @DataProvider
    public static Object[][] dataProvider() {
        return new Object[][]{
                {"http://selenium.webtesting.eu/","Selenium"},
                {"https://de-de.facebook.com/","Facebook"},
                {"https://www.qytera.de/","Die Experten"}
        };
    }

    @UseDataProvider("dataProvider")
    @Tag("DataTest")
    @Description("Aufruf verschiedener Webseiten")
    @Feature("Aufruf Webseiten")
    @TestTemplate
    public void test(String url, String title){
        generalPage.doOpenBrowserWithLink(url);
        generalPage.assertTabTitle(title);
    }

}
