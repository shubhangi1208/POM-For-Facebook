package com.crm.base;

import com.crm.util.TestUtil;
import com.crm.util.WebEventListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {
   public static WebDriver driver;
   public static Properties prop;
    public  static EventFiringWebDriver e_driver;
    public static WebEventListener eventListener;

    public TestBase() {
        try {
            prop = new Properties();
            FileInputStream ip = new FileInputStream("src/main/java/com/crm/config/config.properties");
            prop.load(ip);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void initialization(){
        String browserName= prop.getProperty("browser");
        if (browserName.equals("chrome")){
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-notifications");
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\Hp\\IdeaProjects\\POMOfFacebook\\src\\main\\Driver\\chromedriver.exe");
            driver = new ChromeDriver(options);
            driver.manage().window().maximize();
        }else if (browserName.equals("firefox")){
            System.setProperty("webdriver.gecko.driver", "C:\\Users\\Hp\\IdeaProjects\\ProjectObjectFramework\\src\\main\\driver\\geckodriver.exe");
            WebDriver driver = new FirefoxDriver();
        }

        e_driver = new EventFiringWebDriver(driver);
        // Now create object of EventListerHandler to register it with EventFiringWebDriver
        eventListener = new WebEventListener();
        e_driver.register(eventListener);
        driver = e_driver;

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT,TimeUnit.SECONDS);
        driver.get(prop.getProperty("url"));

    }
}