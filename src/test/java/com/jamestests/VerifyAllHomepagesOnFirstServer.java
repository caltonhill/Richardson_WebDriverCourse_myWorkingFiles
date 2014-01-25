package com.jamestests;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Macdonald on 21/01/14.
 */
public class VerifyAllHomepagesOnFirstServer {
    private static WebDriver driver;

    @BeforeClass
    public static void createDriver(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void canVerifyAjHomepageOnFirstServer (){
        driver.get("http://architectslive1.architectsjournal.co.uk");
        WebElement AjSpinblockTitle = driver.findElement
                (By.cssSelector("div[class='threeColumns'] div[class='column columnThree'] div[class='sectionhead'] h2"));
        assertThat(AjSpinblockTitle.getText(),is ("FOOTPRINT"));
    }
    @Test
    public void canVerifyArHomepageOnFirstServer (){
        driver.get("http://arlive1.architectural-review.com");
        WebElement ArSpinblockTitle = driver.findElement
                (By.cssSelector("div[class='column columnTwo'] div[class='colour2'] div[class='sectionhead_sleeve'] h2"));
        assertThat(ArSpinblockTitle.getText(),is ("POPULAR"));
    }
    @Test
    public void canVerifyCnHomepageOnFirstServer (){
        driver.get("http://cnlive1.cnplus.co.uk");
        WebElement CnSpinblockTitle = driver.findElement
                (By.cssSelector("div[class='grid'] > div[class='oneColumn'] div[class='slideshow slideshowStyle2'] h2"));
        assertThat(CnSpinblockTitle.getText(),is ("TOP STORIES"));
    }
    @Test
    public void canVerifyDrHomepageOnFirstServer (){
        driver.get("http://draperslive1.drapersonline.com");
        WebElement DrSpinblockTitle = driver.findElement
                (By.cssSelector("div[class='grid'] > div[class='oneColumn'] div[class='slideshow slideshowStyle2'] h2"));
        assertThat(DrSpinblockTitle.getText(),containsString("News"));
    }
    @Test
    public void canVerifyHsjHomepageOnFirstServer (){
        driver.get("http://hsjlive1.hsj.co.uk");
        WebElement HsjNewsNavItem = driver.findElement
                (By.cssSelector("div[id='mainnav_sleeve'] > ul > li > a[href='http://hsjlive1.hsj.co.uk/news/']"));
        assertThat(HsjNewsNavItem.getText(),is("NEWS"));
    }
    @Test
    public void canVerifyHvnHomepageOnFirstServer (){
        driver.get("http://hvnlive1.hvnplus.co.uk");
        WebElement HvnNewsNavItem = driver.findElement
                (By.cssSelector("div[id='mainnav_sleeve'] > ul > li > a[href='http://hvnlive1.hvnplus.co.uk/news/']"));
        assertThat(HvnNewsNavItem.getText(),is("NEWS"));
    }
    @Test
    public void canVerifyLgcHomepageOnFirstServer (){
        driver.get("http://lgclive1.lgcplus.com");
        WebElement LgcJobsNavItem = driver.findElement
                (By.cssSelector("div[id='mainnav_sleeve'] > ul > li > a[href='http://www.lgcjobs.com/']"));
        assertThat(LgcJobsNavItem.getText(),is("JOBS"));
    }
    @Test
         public void canVerifyLightingHomepageOnFirstServer (){
        driver.get("http://lightinglive1.lighting.co.uk");
        WebElement LightingNewsNavItem = driver.findElement
                (By.cssSelector("div[id='mainnav_sleeve'] > ul > li > a[href='http://lightinglive1.lighting.co.uk/news/']"));
        assertThat(LightingNewsNavItem.getText(),is("NEWS"));
    }
    @Test
    public void canVerifyMrwHomepageOnFirstServer (){
        driver.get("http://mrwlive1.mrw.co.uk");
        WebElement MrwNewsNavItem = driver.findElement
                (By.cssSelector("div[id='mainnav_sleeve'] > ul > li > a[href='http://mrwlive1.mrw.co.uk/news/']"));
        assertThat(MrwNewsNavItem.getText(),is("News"));
    }
    @Test
    public void canVerifyNceHomepageOnFirstServer (){
        driver.get("http://ncelive1.nce.co.uk");
        WebElement NceNewsNavItem = driver.findElement
                (By.cssSelector("div[id='mainnav_sleeve'] > ul > li > a[href='http://ncelive1.nce.co.uk/news/']"));
        assertThat(NceNewsNavItem.getText(),is("NEWS"));
    }
    @Test
    public void canVerifyNtHomepageOnFirstServer (){
        driver.get("http://nursinglive1.nursingtimes.net");
        WebElement NtPracticeNavItem = driver.findElement
                (By.cssSelector("div[id='mainnav_sleeve'] > ul > li > a[href='http://nursinglive1.nursingtimes.net/nursing-practice/']"));
        assertThat(NtPracticeNavItem.getText(),containsString("PRACTICE"));
    }
    @Test
    public void canVerifyRacHomepageOnFirstServer (){
        driver.get("http://raclive1.racplus.com");
        WebElement RacNewsNavItem = driver.findElement
                (By.cssSelector("div[id='mainnav_sleeve'] > ul > li > a[href='http://raclive1.racplus.com/news/']"));
        assertThat(RacNewsNavItem.getText(),is("NEWS"));
    }
    @Test
    public void canVerifyRjHomepageOnFirstServer (){
        driver.get("http://rjlive1.retail-jeweller.com");
        WebElement RjProductsNavItem = driver.findElement
                (By.cssSelector("div[id='mainnav_sleeve'] > ul > li > a[href='http://rjlive1.retail-jeweller.com/products/']"));
        assertThat(RjProductsNavItem.getText(),is("PRODUCTS"));
    }
    @Test
    public void canVerifyRwHomepageOnFirstServer (){
        driver.get("http://retaillive1.retail-week.com");
        WebElement RwCompaniesNavItem = driver.findElement
                (By.cssSelector("div[id='mainnav_sleeve'] > ul > li > a[href='http://retaillive1.retail-week.com/companies/']"));
        assertThat(RwCompaniesNavItem.getText(),is("Companies"));
    }


    @AfterClass
    public static void quitDriver (){
        driver.quit();
    }

}
