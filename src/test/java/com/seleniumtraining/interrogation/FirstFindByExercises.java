package com.seleniumtraining.interrogation;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

/**
 * Created with IntelliJ IDEA.
 * User: Macdonald
 * Date: 17/11/13
 * Time: 15:26
 * To change this template use File | Settings | File Templates.
 */
public class FirstFindByExercises {
    private static WebDriver driver;

    @BeforeClass
    public static void createDriver(){
        driver = new FirefoxDriver();
        driver.get("http://www.compendiumdev.co.uk/selenium/find_by_playground.php");
    }
    // "findelement" finds a single element
    // "findelements" will find ALL matching elements
    @Test
    public void canFindByIDAndAssertOnText(){
    WebElement para7 = driver.findElement(By.id("p7"));
        assertThat(para7.getText(),containsString("g paragraph"));
    }
    @Test
    public void canFindByLinkTextAndAssertOnID(){
        WebElement para4link = driver.findElement(By.linkText("jump to para 4"));
         assertThat(para4link.getAttribute("id"),is ("a30"));
    }
    @Test
    public void canFindByNameAndAssertOnTagName(){
        WebElement nestedpara40 = driver.findElement(By.name("pName40"));
    assertThat(nestedpara40.getTagName(),is ("p"));
    }
    @Test
    public void canFindByPartialLinkTextAndAssertOnName(){
        WebElement para20link = driver.findElement(By.partialLinkText("para 20"));
        assertThat(para20link.getAttribute("name"),is ("aName46"));
    }
    @Test
    public void canFindByClassNameAndAssertOn(){
        WebElement para20link = driver.findElement(By.className("normal"));
    assertThat(para20link.getText(),not("This is t paragraph text"));
    }

    @AfterClass
    public static void quitDriver(){
        driver.quit();
    }
}
