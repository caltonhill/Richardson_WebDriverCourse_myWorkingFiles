package com.seleniumtraining.Cookies;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;


public class CookiesExercises {

    private static WebDriver driver;
    private static WebDriverWait wait;
    private static String baseURL = "http://www.compendiumdev.co.uk/selenium/search.php";

    @BeforeClass
    public static void setUpDriver(){
    driver = new FirefoxDriver();
        driver.get(baseURL);
        wait = new WebDriverWait(driver,10,200);
    }

    @Test
    public void searchCheckNumVisitsIs1(){

        assertThat(driver.getTitle(), containsString("Selenium Simplified Search"));

        driver.manage().deleteAllCookies();

        //perform a search
        WebElement searchBox = driver.findElement(By.cssSelector("input[type='text']"));
            searchBox.clear();
            searchBox.sendKeys("Webdriver");
            driver.findElement(By.cssSelector("input[type='submit']")).click();

        //wait for search results
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(
                "li[class='resultlistitem']:first-of-type")));

        //find cookie in set and assert value is 1
        //don't really need to iterate through cookies
        Set<Cookie> allCookies = driver.manage().getCookies();
        for(Cookie aCookie : allCookies){
            if(aCookie.getName().contentEquals("seleniumSimplifiedSearchNumVisits")){
                assertThat(driver.manage().getCookieNamed("seleniumSimplifiedSearchNumVisits")
                        .getValue(),is ("1"));
            }
        }

    }

    @Test
    public void checkFor43VisitsByCloningCookie(){

        assertThat(driver.getTitle(), containsString("Selenium Simplified Search"));

        driver.manage().deleteAllCookies();

        driver.navigate().refresh();

        //find cookie and assert for 1 visit
        Cookie baseCookie = driver.manage().getCookieNamed("seleniumSimplifiedSearchNumVisits");

        assertThat(baseCookie.getValue(),is ("1"));

        //clone existing cookie with new value but other
        //attributes copied
        Cookie amendedCookie = new Cookie(baseCookie.getName(),
                String.valueOf(42),
                baseCookie.getDomain(),
                baseCookie.getPath(),
                baseCookie.getExpiry());

        //delete original cookie
        driver.manage().deleteCookie(baseCookie);

        //assert cookie has been deleted
        assertEquals("NumVisits cookie deleted",null, driver.manage().
                getCookieNamed("seleniumSimplifiedSearchNumVisits"));

        //add my new cookie
        driver.manage().addCookie(amendedCookie);

        //assert value is 42
        assertThat(driver.manage().getCookieNamed("seleniumSimplifiedSearchNumVisits")
                .getValue(), is("42"));

        //perform a new search
        WebElement searchBox = driver.findElement(By.cssSelector("input[type='text']"));
            searchBox.clear();
            searchBox.sendKeys("The one true answer");
        driver.findElement(By.cssSelector("input[type='submit']")).click();

        //assert cookie value is now 43
        assertThat(driver.manage().getCookieNamed("seleniumSimplifiedSearchNumVisits")
                .getValue(),is("43"));

    }

    @Test
    public void checkForNumVisitsByBuildingCookieFromScratch(){
        assertThat(driver.getTitle(), containsString("Selenium Simplified Search"));

        //find cookie and assert for 1 visit
        Cookie baseCookie = driver.manage().getCookieNamed("seleniumSimplifiedSearchNumVisits");

        assertThat(baseCookie.getValue(),is ("1"));

        //delete original cookie
        driver.manage().deleteCookie(baseCookie);

        //assert cookie has been deleted
        assertEquals("NumVisits cookie deleted",null, driver.manage().
                getCookieNamed("seleniumSimplifiedSearchNumVisits"));

        //build new cookie from scratch with cookiebuilder

        Cookie amendedCookie = new Cookie.Builder("seleniumSimplifiedSearchNumVisits","18").
                path("/selenium/").build();

        //add my new cookie
        driver.manage().addCookie(amendedCookie);

        //assert value is 18
        assertThat(driver.manage().getCookieNamed("seleniumSimplifiedSearchNumVisits")
                .getValue(), is("18"));

        //perform a new search
        WebElement searchBox = driver.findElement(By.cssSelector("input[type='text']"));
        searchBox.clear();
        searchBox.sendKeys("The one true answer");
        driver.findElement(By.cssSelector("input[type='submit']")).click();

        //assert cookie value is now 19
        assertThat(driver.manage().getCookieNamed("seleniumSimplifiedSearchNumVisits")
                .getValue(),is("19"));
    }

    @Test
    public void changeDisplayedLastSearchText(){

    }

    @AfterClass
    public static void quitDriver(){
        driver.quit();

    }
}


