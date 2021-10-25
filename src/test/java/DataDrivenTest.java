import com.tngtech.junit.dataprovider.*;
import core.GeneralHelper;
import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith({UseDataProviderExtension.class, DataProviderExtension.class})
@Epic("DataTestEpic")
public class DataDrivenTest extends GeneralHelper {
    @DataProvider
    public static Object[][] dataProvider() {
        return new Object[][]{
                {"http://selenium.webtesting.eu/","selenium"},
                {"https://de-de.facebook.com/","facebook"},
                {"https://www.qytera.de/","die experten"}
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
