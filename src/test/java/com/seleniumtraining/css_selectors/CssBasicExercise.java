package com.seleniumtraining.css_selectors;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import static junit.framework.Assert.assertTrue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;


public class CssBasicExercise {
        private static WebDriver driver;

        @BeforeClass
        public static void createDriver(){
            driver = new FirefoxDriver();
            driver.get("http://www.compendiumdev.co.uk/selenium/find_by_playground.php");
        }
    @Test
    public void canFindP31(){
        WebElement p31 = driver.findElement(By.cssSelector("#p31"));
        assertThat((p31.getAttribute("name")),is("pName31"));
    }
    @Test
    public void canFindNameulName1(){
        WebElement ulName1 = driver.findElement(By.cssSelector("[name='ulName1']"));
        assertThat(ulName1.getAttribute("id"),is ("ul1"));
    }
    @Test
    public void canFindClassSpecialDiv(){
        WebElement SpecialDiv = driver.findElement(By.cssSelector(".specialDiv"));
        assertThat(SpecialDiv.getAttribute("id"),is("div1"));
    }
    @Test
    public void canFindTagName(){
        WebElement tagName = driver.findElement(By.cssSelector("[name='liName1']"));
        assertThat(tagName.getAttribute("name"),is("liName1"));
    }


        @AfterClass
        public static void quitDriver(){
            driver.quit();
        }
}

