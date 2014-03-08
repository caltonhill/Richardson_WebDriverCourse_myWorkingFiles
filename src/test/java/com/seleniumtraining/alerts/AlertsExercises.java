package com.seleniumtraining.alerts;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import static junit.framework.Assert.assertEquals;

/**
 * Created by Macdonald on 26/02/14.
 */
public class AlertsExercises {
    private static WebDriver driver;

    @BeforeClass
    public static void createDriver(){
        driver = new FirefoxDriver();
        String targetUrl = "http://www.compendiumdev.co.uk/selenium/alerts.html";
        driver.get(targetUrl);

    }

    @Test
    public void canPlayWithFirstAlert(){
      WebElement alertButton1 = driver.findElement(By.id("alertexamples"));
        alertButton1.click();

        assertEquals("I am an alert box!", driver.switchTo().alert().getText());

        driver.switchTo().alert().accept();
        alertButton1.click();
        driver.switchTo().alert().dismiss();
    }

    @Test
    public void canLaunchAcceptDismissConfirmAlert(){
        WebElement confirmButton = driver.findElement(By.id("confirmexample"));
        confirmButton.click();

        assertEquals("I am a confirm alert", driver.switchTo().alert().getText());

        driver.switchTo().alert().accept();
        assertEquals("true", driver.findElement(By.id("confirmreturn")).getText());

        confirmButton.click();
        assertEquals("I am a confirm alert", driver.switchTo().alert().getText());
        driver.switchTo().alert().dismiss();
        assertEquals("false", driver.findElement(By.id("confirmreturn")).getText());
    }

    @Test
    public void canLaunchAcceptDismissPromptBox(){
        WebElement promptBox = driver.findElement(By.id("promptexample"));
        promptBox.click();

        assertEquals("I prompt you", driver.switchTo().alert().getText());

        driver.switchTo().alert().accept();
                assertEquals("change me", driver.findElement(By.id("promptreturn")).getText());

        promptBox.click();
        driver.switchTo().alert().dismiss();
            assertEquals("change me", driver.findElement(By.id("promptreturn")).getText());

    }


    @Test
    public void canLaunchEnterTextAcceptDismissPromptBox(){
        WebElement promptBox = driver.findElement(By.id("promptexample"));
        promptBox.click();

        assertEquals("I prompt you", driver.switchTo().alert().getText());

        driver.switchTo().alert().sendKeys("Accept getting a job");
        driver.switchTo().alert().accept();
        assertEquals("Accept getting a job", driver.findElement(By.id("promptreturn")).getText());

        promptBox.click();
        driver.switchTo().alert().sendKeys("Your wife should dismiss you");
        driver.switchTo().alert().dismiss();
        assertEquals("Accept getting a job", driver.findElement(By.id("promptreturn")).getText());

    }



    @AfterClass
    public static void quitDriver(){
        driver.quit();
    }
}
