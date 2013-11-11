package com.seleniumtraining.webdriver;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import static junit.framework.Assert.assertTrue;
public class RealBrowser
   {
    @Test
    public void driveFirefox()
    {
        WebDriver driver = new FirefoxDriver();
        driver.get("http://www.retail-week.com");
        assertTrue( driver.getTitle().contains("news") );
        driver.quit();
    }
}
