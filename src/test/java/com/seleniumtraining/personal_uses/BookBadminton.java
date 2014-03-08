package com.seleniumtraining.personal_uses;

import com.sun.java.swing.plaf.windows.resources.windows;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;



public class BookBadminton {
   private static WebDriver driver;

    @BeforeClass
    public static void createDriver (){
        driver = new FirefoxDriver();
        driver.get("https://gll.legendonlineservices.co.uk/enterprise/account/Login");
    }

    @Test
    public void canBookBadmintonBeforeTheForeigners(){
        //login
        WebElement emailField = driver.findElement(By.id("login_Email"));
        WebElement pwordField = driver.findElement(By.id("login_Password"));

        emailField.clear();
        pwordField.clear();

        emailField.sendKeys("macdonald.james@gmail.com");
        pwordField.sendKeys("Scotland3");

        WebElement loginButton = driver.findElement(By.id("login"));
        loginButton.click();

        //Wait for next page to load then find and click link to make booking
        new WebDriverWait(driver,5,10).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(
                "div[id='submenu'] > ul > li > a[href='/enterprise/BookingsCentre/Index']")));
        WebElement bookingLink = driver.findElement(By.cssSelector(
                "div[id='submenu'] > ul > li > a[href='/enterprise/BookingsCentre/Index']"));
        bookingLink.click();

       //check new page has loaded by looking for Other Activities radio button
        new WebDriverWait(driver,5,10).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(
                "input[value='158']")));

        //click Other Activities Radio Button
        WebElement otherActsLink = driver.findElement(By.cssSelector("input[value='-3']"));
        assertFalse(otherActsLink.isSelected());

                otherActsLink.click();

        new WebDriverWait(driver,5,10).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(
                "input[value='468']")));

        WebElement badmintonRadio = driver.findElement(By.cssSelector("input[value='468']"));
        assertFalse(badmintonRadio.isSelected());
            badmintonRadio.click();

        new WebDriverWait(driver,5,10).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(
                "iframe[id='TB_iframeContent']")));

        WebElement viewTable = driver.findElement(By.cssSelector("input[id='bottomsubmit']"));
        viewTable.click();

        new WebDriverWait(driver,5,10).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector(
                        "div[class='activityHeader']")));




    }

    @AfterClass
    public static void quitDriver(){
        driver.quit();
    }
}
                     **/