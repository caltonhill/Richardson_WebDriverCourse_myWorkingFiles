package com.seleniumtraining.frames;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


/**
 * Created by Macdonald on 04/03/14.
 */
public class FramesExercises {

    private static WebDriver driver;
    private static String baseURL = "http://www.compendiumdev.co.uk/selenium";

    @BeforeClass
    public static void createDriver(){

        driver = new FirefoxDriver();
        driver.get(baseURL + "/frames/");
    }

    @Test
   public void framesTask1(){

        driver.switchTo().frame("content");

        WebElement linkToClick = driver.findElement(By.cssSelector("ul>li>a[href='green.html']"));
        linkToClick.click();

        assertEquals("h1", driver.findElement(By.id("green")).getTagName());

        WebElement nextLink = driver.findElement(By.cssSelector("a[href='content.html']"));
        nextLink.click();

        assertEquals("Content", driver.findElement(By.tagName("h1")).getText());

     }

    @Test
    public void framesTask2(){

        driver.get(baseURL + "/frames/");

        driver.switchTo().frame(driver.findElement(By.cssSelector("frameset > frame[name='menu']")));

        WebElement iframeLink = driver.findElement(By.cssSelector("html>body>a[href='iframe.html']"));
        iframeLink.click();

        driver.switchTo().frame(driver.findElement(By.tagName("iframe")));

        assertEquals("This is an iframe menu", driver.findElement(By.cssSelector(
                "html>body>p:first-of-type")).getText());

        WebElement example5Link = driver.findElement(By.cssSelector("a[href='frames_example_5.html']"));
        example5Link.click();

        Assert.assertThat(driver.getTitle(), is("Frameset Example Title (Example 5)"));

        driver.switchTo().frame("content");

        WebElement lastLink = driver.findElement(By.cssSelector(
                "html>body>ul>li>a[href='index.html']"));

        lastLink.click();

        Assert.assertThat(driver.getTitle(), is("Frameset Example Title (Example 6)"));

    }


    @AfterClass
    public static void quitDriver() {
        driver.quit();
    }


}
