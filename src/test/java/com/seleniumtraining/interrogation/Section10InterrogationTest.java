package com.seleniumtraining.interrogation;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.assertTrue;


/**
 * Created with IntelliJ IDEA.
 * User: Macdonald
 * Date: 13/11/13
 * Time: 20:52
 * To change this template use File | Settings | File Templates.
 */
public class Section10InterrogationTest {
private static WebDriver driver;

    @BeforeClass
    public static void createDriver(){
        driver = new FirefoxDriver();
    }

    @Test
    public void canAssertTitle(){
        driver.navigate().to
                ("http://www.compendiumdev.co.uk/selenium/basic_web_page.html");
        assertTrue(driver.getTitle().
                contentEquals("Basic Web Page Title"));
    }
    @Test
    public void canAssertCurrentURL(){
        assertTrue(driver.getCurrentUrl().
                contentEquals("http://www.compendiumdev.co.uk/selenium/basic_web_page.html"));
    }
    @Test
    public void canAssertPageSourceContent(){
        assertTrue(driver.getPageSource().
                contains("A paragraph of text"));
    }

    @AfterClass
    public static void quitDriver(){
        driver.quit();
    }
}
