import com.tngtech.junit.dataprovider.*;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.TestTemplate;
import org.junit.jupiter.api.extension.ExtendWith;

import static PageObjects.GeneralPage.generalPage;

@ExtendWith({UseDataProviderExtension.class, DataProviderExtension.class})
@Epic("DataTestEpic")
public class DataDrivenTest {

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
