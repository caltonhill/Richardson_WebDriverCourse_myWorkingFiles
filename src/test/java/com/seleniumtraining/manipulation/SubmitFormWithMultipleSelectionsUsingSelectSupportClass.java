package com.seleniumtraining.manipulation;

import org.hamcrest.CoreMatchers;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;
import static org.hamcrest.MatcherAssert.assertThat;


/**
 * Created by Macdonald on 04/02/14.
 */
public class SubmitFormWithMultipleSelectionsUsingSelectSupportClass {
    private static WebDriver driver;

    @BeforeClass
    public static void createDriver(){
        driver = new FirefoxDriver();
        driver.get("http://www.compendiumdev.co.uk/selenium/basic_html_form.html");
    }

    @Test
    public void canSubmitWithMultipleSelectionsUsingSelectSupportClass(){
        WebElement multipleSelectElement;
        //finding the entire multi-select element rather than individual options
        multipleSelectElement = driver.findElement(By.cssSelector("select[name='multipleselect[]']"));
        //instantiate "Select" support class by creating new Select object
        Select allSelects = new Select(multipleSelectElement);

        //now I have an object allSelects and Select class gives options I can use on it

        allSelects.selectByIndex(0);
        allSelects.selectByIndex(1);
        allSelects.selectByIndex(2);
        allSelects.deselectByVisibleText("Selection Item 4");

        WebElement submitButton = driver.findElement(By.cssSelector("input[type='submit']"));
        submitButton.click();

        new WebDriverWait(driver,2,15).until(ExpectedConditions.titleIs(
                "Processed Form Details"));

        assertThat(driver.findElement(By.id("_valuemultipleselect0")).getText(), CoreMatchers.is("ms1"));
        assertThat(driver.findElement(By.id("_valuemultipleselect1")).getText(), CoreMatchers.is("ms2"));
        assertThat(driver.findElement(By.id("_valuemultipleselect2")).getText(), CoreMatchers.is("ms3"));
        assertTrue(driver.findElements(By.id("_valuemultipleselect3")).isEmpty());
    }

    @AfterClass
    public static void quitDriver(){
        driver.quit();
    }
}
