package com.seleniumtraining.webdriver;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.assertTrue;

/**
 * Created with IntelliJ IDEA.
 * User: Macdonald
 * Date: 11/11/13
 * Time: 21:25
 * To change this template use File | Settings | File Templates.
 */
public class NavigationExampleTest {
    private static WebDriver driver;

    @BeforeClass
    public static void createDriver(){
        driver = new FirefoxDriver();
    }
    @Test
    public void navigateWithNavigateTo(){
        driver.navigate().to(
                "http://www.retail-week.com");
        assertTrue(driver.getTitle().
                startsWith("Retail"));
    }
        @AfterClass
    public static void quitDriver(){
            driver.quit();
    }
}
