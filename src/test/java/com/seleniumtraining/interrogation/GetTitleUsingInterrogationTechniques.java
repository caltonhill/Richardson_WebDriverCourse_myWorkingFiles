package com.seleniumtraining.interrogation;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.startsWith;

import java.sql.Driver;

/**
 * Created by Macdonald on 25/01/14.
 */
public class GetTitleUsingInterrogationTechniques {
    public static WebDriver driver;

@BeforeClass
public static void createDriver(){
    driver = new FirefoxDriver();
    driver.get("http://www.retail-week.com");
}

@Test
public void canGetTitleByTagName (){
    WebElement pageTitle = driver.findElement(By.tagName("title"));
    assertThat ((pageTitle.getTagName()),containsString("title"));
}

@Test
public void canGetTitleUsingCssSelectors (){
    WebElement pageTitle2 = driver.findElement(By.cssSelector("html > head > title"));
    assertThat((pageTitle2.getText()), is(""));
}
@Test
public void canGetTitleUsingXpath(){
    WebElement pageTitle3 = driver.findElement(By.xpath("//title"));
    assertThat((pageTitle3.getTagName()),is("title"));
}

@AfterClass
public static void quitDriver (){
   driver.quit();
}
}


