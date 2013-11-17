package com.seleniumtraining.interrogation;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


/**
 * Created with IntelliJ IDEA.
 * User: Macdonald
 * Date: 14/11/13
 * Time: 20:44
 * To change this template use File | Settings | File Templates.
 */
public class RichardsonInterrogationTest {

    @Test
    public void driverLevelPageInterrogateMethods(){
    WebDriver driver;

    final String theTestPageURL =
            "http://www.compendiumdev.co.uk/selenium/basic_web_page.html";

    driver = new FirefoxDriver();

    driver.navigate().to(theTestPageURL);

    assertEquals(driver.getTitle(), "Basic Web Page Title");
    assertEquals(driver.getCurrentUrl(), theTestPageURL);

    String pageSource = driver.getPageSource();

    assertTrue(pageSource.contains("A paragraph of text"));

    System.out.println(pageSource);

    driver.quit();
    }
}
