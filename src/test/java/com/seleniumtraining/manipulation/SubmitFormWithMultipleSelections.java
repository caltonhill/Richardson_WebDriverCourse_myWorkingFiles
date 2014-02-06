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
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static junit.framework.Assert.assertTrue;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


/**
 * Created by Macdonald on 04/02/14.
 */
public class SubmitFormWithMultipleSelections {
    private static WebDriver driver;

    @BeforeClass
    public static void createDriver(){
        driver = new FirefoxDriver();
        driver.get("http://www.compendiumdev.co.uk/selenium/basic_html_form.html");
    }

    @Test
    public void canSubmitWithMultipleSelections(){
        /**WebElement multiSelect1 = driver.findElement(By.cssSelector("select > option[value='ms1']"));
        multiSelect1.click();
        WebElement multiSelect2 = driver.findElement(By.cssSelector("select > option[value='ms2']"));
        multiSelect2.click();
        WebElement multiSelect3 = driver.findElement(By.cssSelector("select > option[value='ms3']"));
        multiSelect3.click(); **/

        List<WebElement> multiSelects = driver.findElements(By.cssSelector("select > option[value^='ms']"));
        multiSelects.get(0).click();
        multiSelects.get(1).click();
        multiSelects.get(2).click();
        //and since 4 is selected by default it must be deselected
        multiSelects.get(3).click();

        WebElement submitButton = driver.findElement(By.cssSelector("input[type='submit']"));
        submitButton.click();

        new WebDriverWait(driver,2,15).until(ExpectedConditions.titleIs(
                "Processed Form Details"));

        //WebElement processedMultiSelects = driver.findElement(By.cssSelector("#_multipleselect > ul li"));
        assertThat(driver.findElement(By.id("_valuemultipleselect0")).getText(), CoreMatchers.is("ms1"));
        assertThat(driver.findElement(By.id("_valuemultipleselect1")).getText(), CoreMatchers.is("ms2"));
        assertThat(driver.findElement(By.id("_valuemultipleselect2")).getText(), CoreMatchers.is("ms3"));
        //To show 4th value is not present
        //use assertTrue and findElementS.  The latter because it doesn't throw exception. Otherwise could
        //have used findElement and caught exception
        assertTrue(driver.findElements(By.id("_valuemultipleselect3")).isEmpty());
    }

    @AfterClass
    public static void quitDriver(){
        driver.quit();
    }
}
