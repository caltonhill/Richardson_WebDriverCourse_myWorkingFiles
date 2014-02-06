package com.seleniumtraining.manipulation;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;



/**
 * Created by Macdonald on 03/02/14.
 */
public class ChangeTitleOnFormSubmit  {
    private static WebDriver driver;

   @BeforeClass
    public static void createDriver(){
        driver = new FirefoxDriver();
       driver.get("http://www.compendiumdev.co.uk/selenium/basic_html_form.html");
}
    @Test
    public void AssertPageTitleChangesOnFormSubmit () {
        WebElement submitButton = driver.findElement(By.cssSelector("input[type='submit']"));
        submitButton.click();

        new WebDriverWait(driver,2,25).until(
                ExpectedConditions.titleContains("Processed Form"));

        WebElement newPageTitle = driver.findElement(By.tagName("title"));

        assertEquals("Page Title after Submit should be Processed Form Details",
                driver.getTitle(), "Processed Form Details");

    }

    @AfterClass
    public static void quitDriver (){
        driver.quit();
    }
}
