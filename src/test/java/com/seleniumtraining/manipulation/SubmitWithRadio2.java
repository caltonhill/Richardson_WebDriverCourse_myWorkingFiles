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

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Created by Macdonald on 03/02/14.
 */
public class SubmitWithRadio2 {
    private static WebDriver driver;

    @BeforeClass
    public static void createDriver(){
        driver = new FirefoxDriver();
        driver.get("http://www.compendiumdev.co.uk/selenium/basic_html_form.html");
    }

    @Test
    public void canSubmitFormWithRadio2Selected(){
        WebElement radio2 = driver.findElement(By.cssSelector("input[value='rd2']"));
        radio2.click();

        WebElement submitButton = driver.findElement(By.cssSelector("input[type='submit']"));
        submitButton.click();

        new WebDriverWait(driver,2,15).until(
            ExpectedConditions.titleIs("Processed Form Details"));

        WebElement selectedRadio = driver.findElement(By.cssSelector("li[id='_valueradioval']"));

        assertThat(selectedRadio.getText(),is ("rd2"));
    }

    @AfterClass
    public static void quitDriver(){
        driver.quit();
    }

}
