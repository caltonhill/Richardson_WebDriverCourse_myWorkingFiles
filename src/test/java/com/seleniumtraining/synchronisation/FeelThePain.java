package com.seleniumtraining.synchronisation;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by James on 12/03/14.
 */
public class FeelThePain {
    private static WebDriver driver;
    private static String baseUrl="http:www.compendiumdev.co.uk/selenium/basic_ajax.html";
    private static WebDriverWait wait;

    @BeforeClass
    public static void createDriver(){
        driver = new FirefoxDriver();
        driver.get(baseUrl);
        wait = new WebDriverWait(driver,10,20);
    }

    @Test
    public void failsWithoutSync(){
        //select Server from dropdown1
        driver.findElement(By.cssSelector(
                "select[id='combo1'] > option[value='3']")).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(
                "select[id='combo2'] > option[value='23']")));

        //select Java from dropdown2
        driver.findElement(By.cssSelector(
                "select[id='combo2'] > option[value='23']")).click();
        //click "Code in it" button
        driver.findElement(By.cssSelector(
                "input[name='submitbutton']")).click();

        wait.until(ExpectedConditions.titleContains("Processed Form"));
        assertThat(driver.findElement(By.id("_valuelanguage_id")).getText(),
                is("23"));
    }


    @AfterClass
    public static void quitDriver(){
        driver.quit();
    }

}
