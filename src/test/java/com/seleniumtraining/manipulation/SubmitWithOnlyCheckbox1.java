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

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

/**
 * Created by Macdonald on 03/02/14.
 */
public class SubmitWithOnlyCheckbox1 {
    private static WebDriver driver;

    @BeforeClass
    public static void createDriver(){
        driver = new FirefoxDriver();
        driver.get("http://www.compendiumdev.co.uk/selenium/basic_html_form.html");
    }

    @Test
    public void canSubmitFormWithCheckbox1Only(){
        /** locate element checkbox 1 and select, clear checkbox 2, clear checkbox 3
         * submit button.  Add wait command and verify page has updated via title
         * Assert that processed details show only checkbox 1 selected
                   **/
        List<WebElement> checkboxes = driver.findElements(By.cssSelector("input[type='checkbox']"));
        checkboxes.clear();

        WebElement checkbox1 = driver.findElement(By.cssSelector("input[value='cb1']"));
        checkbox1.click();

        WebElement submitButton = driver.findElement(By.cssSelector("input[type='submit']"));
        submitButton.click();

        new WebDriverWait(driver,2,15).until(
                ExpectedConditions.titleIs("Processed Form Details"));

        WebElement selectedCheckboxValues = driver.findElement(
                By.cssSelector("div[id='_checkboxes'] > ul > li[id='_valuecheckboxes0']"));

        assertThat(selectedCheckboxValues.getText(),is ("cb1"));
    }

    @AfterClass
    public static void quitDriver(){
        driver.quit();
    }




}
