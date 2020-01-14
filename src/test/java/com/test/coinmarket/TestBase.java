package com.test.coinmarket;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class TestBase {
    private static WebDriver driver;
    private static TestBase testBaseManager = new TestBase();

    private static final String CHROME_KEY = "webdriver.chrome.driver";
    private static final String CHROME_VALUE = "./drivers/chromedriver.exe";

    private static final String FIREFOX_KEY = "webdriver.gecko.driver";
    private static final String FIREFOX_VALUE = "./drivers/geckodriver.exe";

    private TestBase() {

    }

    private WebDriver createDriver() {
        System.setProperty(CHROME_KEY, CHROME_VALUE);

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }

    public static TestBase getInstance() {
        return testBaseManager;
    }

    public WebDriver getDriver() {
        return (driver == null) ? createDriver() : driver;
    }

    @After(order = 1)
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
            if (screenshot != null) {
                scenario.embed(screenshot, "image/png");
            }
        }
        driver.close();
    }

}
