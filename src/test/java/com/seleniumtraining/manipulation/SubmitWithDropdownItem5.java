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

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Macdonald on 04/02/14.
 */
public class SubmitWithDropdownItem5 {
    private static WebDriver driver;

    @BeforeClass
    public static void createDriver() {
        driver = new FirefoxDriver();
        driver.get("http://www.compendiumdev.co.uk/selenium/basic_html_form.html");
    }

    @Test
    public void canSubmitFormWithDropdownItem5() {
        WebElement dropdown5 = driver.findElement(
                By.cssSelector("table>tbody> tr> td >select[name='dropdown'] >option[value='dd5']"));
        dropdown5.click();

        WebElement submitButton = driver.findElement(By.cssSelector("input[type='submit']"));
        submitButton.click();

        new WebDriverWait(driver,2,15).until(
                ExpectedConditions.titleIs("Processed Form Details"));

        WebElement processedDropdownValue = driver.findElement(By.cssSelector("ul > li[id='_valuedropdown']"));
        assertThat(processedDropdownValue.getText(), is ("dd5"));
        }

    @AfterClass
    public static void quitDriver(){
        driver.quit();
    }
}
