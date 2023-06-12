package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SingletonBrowserClass {
    //Instance of singleton class
    private static SingletonBrowserClass instanceOfSingletonBrowserClass=null;

    //Private Wedriver variable for usage
    private WebDriver driver;

    //Constructor
    private SingletonBrowserClass() {
        var lxResourcePath = "src/test/resources/chromedriver";
        var operatingSystem = System.getProperty("os.name").toLowerCase();
        var resourcePath = operatingSystem.contains("windows") ? lxResourcePath + ".exe" : lxResourcePath;
        System.setProperty("webdriver.chrome.driver", resourcePath);
        driver = new ChromeDriver();
    }

    //To create instance of class
    public static SingletonBrowserClass getInstanceOfSingletonBrowserClass(){
        if(instanceOfSingletonBrowserClass==null){
            instanceOfSingletonBrowserClass = new SingletonBrowserClass();
        }
        return instanceOfSingletonBrowserClass;
    }

    //To get the driver
    public WebDriver getDriver()
    {
        return driver;
    }
}
