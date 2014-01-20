package com.jamestests;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.By;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.junit.Assert.assertThat;


/**
 * Created by Macdonald on 18/01/14.
 */
public class EmapFriendlyUrlChecker {
    private static WebDriver driver;

    @BeforeClass
    public static void createDriver(){
        driver = new FirefoxDriver();
    }
    @Test
    public void openAjSectionPgFriendlyUrlAndCheckForText (){
        driver.get("http://www.architectsjournal.co.uk/news/");
        WebElement AjSpinblockTitle = driver.findElement
                (By.cssSelector("div.column.columnTwo > div.style > div.colour1 > div.sectionhead " +
                        "> div.sectionhead_sleeve > h2"));
                assertThat(AjSpinblockTitle.getText(),is ("LATEST NEWS"));
    }
    @Test
    public void openArSectionPgFriendlyUrlAndCheckForText () {
        driver.get("http://www.architectural-review.com/buildings/");
        WebElement ArSpinblockTitle = driver.findElement
                (By.cssSelector("div[class='twoColumnsSmallRight'] > div[class='columnContainer'] " +
                        "div[class='column columnOne'] div[class='sectionhead_sleeve'] h2"));
                assertThat(ArSpinblockTitle.getText(),is ("BUILDINGS"));
    }
    @Test
    public void openCnSectionPgFriendlyUrlAndCheckForText () {
        driver.get("http://www.cnplus.co.uk/opinion/");
        WebElement CnSpinblockTitle = driver.findElement
                (By.cssSelector("div[class='columnContainer'] > div[class='column columnOne'] > " +
                        "div[class='htmlContent'] div[class='sectionhead_sleeve'] h2"));
        assertThat(CnSpinblockTitle.getText(),is ("TODAY'S PICKS"));
    }
    @Test
    public void openDrSectionPgFriendlyUrlAndCheckForText () {
        driver.get("http://www.drapersonline.com/fashion/");
        WebElement DrPageIntroText = driver.findElement
                (By.cssSelector("div[id='section_intro']"));
        assertThat(DrPageIntroText.getText(),is ("Fashion brand news, fashion trends"));
    }
    @Test
    public void openHsjSectionPgFriendlyUrlAndCheckForText () {
        driver.get("http://www.hsj.co.uk/news/");
        WebElement HsjPageIntroText = driver.findElement
                (By.cssSelector("div[class='column columnOne'] > div[class='htmlContent'] > p"));
        assertThat(HsjPageIntroText.getText(),is ("NHS finance, policy and performance news for healthcare leaders"));
    }
    @Test
    public void openHvnSectionPgFriendlyUrlAndCheckForText () {
        driver.get("http://www.hvnplus.co.uk/comment/");
        WebElement HvnSpinblockTitle = driver.findElement
                (By.cssSelector("div[class='colour1'] div[class='sectionhead_sleeve'] > h2"));
        assertThat(HvnSpinblockTitle.getText(),is ("YOUR VIEWS"));
    }
    @Test
    public void openLgcSectionPgFriendlyUrlAndCheckForText () {
        driver.get("http://www.lgcplus.com/opinion/");
        WebElement LgcPageIntroText = driver.findElement
                (By.cssSelector("div[id='section_intro'] > h4"));
        assertThat(LgcPageIntroText.getText(),is ("Opinion from LGC"));
    }
    @Test
    public void openLightingSectionPgFriendlyUrlAndCheckForText () {
        driver.get("http://www.lighting.co.uk/hardware");
        WebElement LightingHyperlinkedSpinblockTitle = driver.findElement
                (By.cssSelector("a[href='http://www.lighting.co.uk/section1.aspx?navCode=1244']"));
        assertThat(LightingHyperlinkedSpinblockTitle.getText(),is ("Lamps"));
    }
    @Test
    public void openMrw2ndLevelSectionPgFriendlyUrlAndCheckForText () {
        driver.get("http://www.mrw.co.uk/news/collections/");
        WebElement MrwSpinblockTitle = driver.findElement
                (By.cssSelector("div[class='section_column1'] > div[class='colour1'] h2"));
        assertThat(MrwSpinblockTitle.getText(),is ("Collections News"));
    }
    @Test
    public void openNceSectionPgFriendlyUrlAndCheckForText () {
        driver.get("http://www.nce.co.uk/features/");
        WebElement NcePageIntroText = driver.findElement
                (By.cssSelector("div[id='section_intro']"));
        assertThat(NcePageIntroText.getText(),startsWith("Features"));
    }
    @Test
    public void openNtSectionPgFriendlyUrlAndCheckForText () {
        driver.get("http://www.nursingtimes.net/nursing-practice/");
        WebElement NtHtmlBlockTitle = driver.findElement
                (By.cssSelector("div[class='section_column1'] > div[class='htmlContent'] " +
                        "div[class='sectionhead_sleeve']"));
        assertThat(NtHtmlBlockTitle.getText(),containsString("ARCHIVE"));
    }
    @Test
    public void openRacSectionPgFriendlyUrlAndCheckForText () {
        driver.get("http://www.racplus.com/features/");
        WebElement RacSpinblockTitle = driver.findElement
                (By.cssSelector("div[class='sectionhead_sleeve'] > h2"));
        assertThat(RacSpinblockTitle.getText(),startsWith("RAC"));
    }
    @Test
    public void openRjSectionPgFriendlyUrlAndCheckForText () {
        driver.get("http://www.retail-jeweller.com/products/");
        WebElement RjSpinblockTitle = driver.findElement
                (By.cssSelector("div[class='sectionhead_sleeve'] > h2"));
        assertThat(RjSpinblockTitle.getText(),is("PRODUCT NEWS"));
    }
    @Test
    public void openRw2ndLevelSectionPgFriendlyUrlAndCheckForText () {
        driver.get("http://www.retail-week.com/sectors/food/");
        WebElement RwBlockTitle = driver.findElement
                (By.cssSelector("div[class='section-header-2013']"));
        assertThat(RwBlockTitle.getText(),is("Sectors"));
    }
    @AfterClass
    public static void quitDriver(){
        driver.quit();
    }
}
