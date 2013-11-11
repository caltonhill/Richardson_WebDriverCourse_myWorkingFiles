package com.seleniumtraining.webdriver;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import static junit.framework.Assert.assertTrue;

public class FirstTest
   {
  @Test
    public void confirmRwTitle()
    {
        WebDriver driver = new HtmlUnitDriver();
        driver.get("http://www.retail-week.com");
        assertTrue( driver.getTitle().startsWith("Retail") );
    }
}
