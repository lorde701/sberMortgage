package ru.company.autotests.steps;


import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.company.autotests.utils.TestProperties;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

/**
 * Created by Иванка on 30.10.2017.
 */
public class BaseSteps {
    static WebDriver driver;
    static String baseUrl;
    public static Properties properties = TestProperties.getInstance().getProperties();

    @Before
    public static void setUp() {
        baseUrl = properties.getProperty("app.url");
        System.setProperty("webdriver.chrome.driver", properties.getProperty("webdriver.chrome.driver"));
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }

    @After
    public static void tearDown() {
        driver.quit();
    }

    public static WebDriver getDriver() {
        return driver;
    }

}
