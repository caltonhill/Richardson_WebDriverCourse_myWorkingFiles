package com.seleniumtraining.user_interactions;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static junit.framework.Assert.assertEquals;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Macdonald on 20/02/14.
 */
public class UserInteractionsExercises {
    private static WebDriver driver;

    @BeforeClass
    public static void createDriver(){
        driver = new FirefoxDriver();
        driver.get("http://www.compendiumdev.co.uk/selenium/gui_user_interactions.html");
    }

    @Test
    public void canDragAndDropAndAssertTextChange (){

        new Actions(driver).dragAndDrop(driver.findElement(By.cssSelector("div[id='draggable1']")),
                driver.findElement(By.cssSelector("div[id='droppable1']"))).perform();

       new WebDriverWait(driver,2,10);

        assertThat(driver.findElement(By.cssSelector("div[id='droppable1'] > p")).getText(), is("Dropped!"));

    }

    @Test
    public void canDragAndDropAndAssertTextChange2() {

        new Actions(driver).dragAndDrop(driver.findElement(By.cssSelector("div[id='draggable2']")),
                driver.findElement(By.cssSelector("div[id='droppable1']"))).perform();

        new WebDriverWait(driver,2,10);

        assertThat(driver.findElement(By.cssSelector("div[id='droppable1'] > p")).getText(), is("Get Off Me!"));

    }

    @Test
    public void canSimulateKeyStrokesAndAssertTextChange(){

        new Actions(driver).keyDown(Keys.CONTROL).sendKeys("B").perform();

        assertThat(driver.findElement(By.cssSelector("div[id='draggable1'] > p")).getText(), is("Bwa! Ha! Ha!"));
    }

   /* @Test
    public void canGoForABonus1(){

        new Actions(driver).keyDown(Keys.CONTROL).keyDown(Keys.SPACE).perform();

        List<WebElement> redSquares = driver.findElements(By.cssSelector("div[id^='droppable']"));

        assertEquals("Let GO!!!",redSquares.get(0).getText());
        assertEquals("Let GO!!!",redSquares.get(1).getText());
    }        */


    @AfterClass
    public static void quitDriver(){
        driver.quit();
    }

}
