package com.seleniumtraining.xpath;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Macdonald on 25/01/14.
 */
public class FindByXPathExercise {
    private static WebDriver driver;

    @BeforeClass
    public static void createDriver(){
        driver = new FirefoxDriver();
        driver.get("http://www.compendiumdev.co.uk/selenium/find_by_playground.php");
    }

    @Test
    public void canFindP31ByXpath (){
        WebElement p31 = driver.findElement(By.xpath("//p[@id='p31']"));
        assertThat((p31.getAttribute("name")),is("pName31"));
    }
    @Test
    public void canFindUlnameByXpath (){
        WebElement nextElement = driver.findElement(By.xpath("//*[@id='div18']/ul[@name='ulName1']"));
        assertThat ((nextElement.getAttribute("id")),is ("ul1") );
    }
    @Test
    public void canFindDivWithClassNameSpecialDiv (){
        WebElement targetedDiv = driver.findElement(By.xpath("//div[@class='specialDiv']"));
        assertThat ((targetedDiv.getAttribute("id")),is("div1"));
    }
    @Test
    public void canAssertNameOfTagLi () {
        WebElement leoMckern = driver.findElement(By.xpath("//li[@id='li1']"));
        assertThat((leoMckern.getAttribute("name")),is("liName1"));
    }


    @AfterClass
    public static void quitDriver(){
        driver.quit();
    }
}
