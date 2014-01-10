package com.seleniumtraining.interrogation;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/*
 *THIS IS A VERY ROUGH, BASIC ATTEMPT. RICHARDSON ASSUMES DEEPER JAVA KNOWLEDGE
 * User: Macdonald
 * Date: 24/11/13
 * Time: 15:04
 * To change this template use File | Settings | File Templates.
 */
public class FindElementsExercise {
    private static WebDriver driver;

    @BeforeClass
    public static void createDriver(){
        driver = new FirefoxDriver();
        driver.get("http://www.compendiumdev.co.uk/selenium/find_by_playground.php");
    }
    // "findelement" finds a single element
    // "findelements" will find ALL matching elements

    @Test
    public void returnAListOfElementsByTagNameAndAssertHowManyDivs(){
            List<WebElement> divs = driver.findElements(By.tagName("div"));
            assertTrue(divs.size()== 19);
    }
    @Test
        public void returnAListOfElementsByTagNameAndAssertHowManyAnchorsToParas(){
            List<WebElement> anchors = driver.findElements(By.tagName("a"));
            assertTrue(anchors.size()>= 40);
    }
    @Test
        public void returnAListofElementsByPartialLinkTextAndAssertSize(){
            List<WebElement> paraLinks = driver.findElements(By.partialLinkText("jump to para"));
            assertEquals(25,paraLinks.size());
    }
    @AfterClass
    public static void quitDriver(){
        driver.quit();
    }
}
