package com.seleniumtraining.exercises;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created with IntelliJ IDEA.
 * User: JamesMacdonald
 * Date: 11/11/13
 * Time: 10:45 PM
 * To change this template use File | Settings | File Templates.
 */
public class Section8NavigationExercisesTest {
    private static WebDriver driver;

    @BeforeClass
    public static void createDriver(){
        driver = new FirefoxDriver();
    }
    @Test
    public void navigateWithNavigateTo(){
        driver.navigate().to(
                "http://compendiumdev.co.uk");
        assertTrue(driver.getTitle().
                startsWith("Software Testing"));
    }
    @Test
    public void navigateToFirstSubPage(){
         driver.navigate().to(
                 "http://compendiumdev.co.uk/selenium");
        assertTrue(driver.getTitle().
                contains("Selenium Simplified"));
    }
    @Test
    public void navigateVariousAndAssert(){
         driver.navigate().to(
                 "http://compendiumdev.co.uk/selenium/basic_html_form.html");
         assertTrue(driver.getTitle().
                 contains("Elements"));
         driver.navigate().to(
                 "http://compendiumdev.co.uk/selenium/search.php");
         driver.navigate().to(
                 "http://compendiumdev.co.uk/selenium/basic_web_page.html");
         driver.navigate().back();
        assertTrue(driver.getTitle().
                contains("Search Engine"));
        driver.navigate().forward();
        assertTrue(driver.getTitle().
                contains("Basic Web Page"));
    }
    @Test
    public void navigateRefreshTest(){
        driver.navigate().to(
                "http://compendiumdev.co.uk/selenium/refresh.php");
        assertFalse(driver.getTitle().
                contains("Plum Duff"));
        driver.navigate().refresh();
        assertTrue(driver.getTitle().
                contains("Refreshed Page"));
    }

    @AfterClass
    public static void quitDriver(){
        driver.quit();
    }
}

