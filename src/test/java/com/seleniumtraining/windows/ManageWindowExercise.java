package com.seleniumtraining.windows;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.awt.*;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

/**
 * Created by James on 10/03/14.
 */
public class ManageWindowExercise {
    private static WebDriver driver;
    private static String baseURL = "http://www.compendiumdev.co.uk/selenium/bounce.html";

    @BeforeClass
    public static void createDriver(){
        driver = new FirefoxDriver();
        driver.get(baseURL);
    }

    @Test
    public void canManageWindow(){

        assertThat(driver.getTitle(), is("Bounce"));

        WebDriver.Window testWindow = driver.manage().window();

        testWindow.maximize();
        Dimension winFullSize = testWindow.getSize();

        assertEquals(744,winFullSize.getHeight());
        assertEquals(1382,winFullSize.getWidth());

        //reduce window to half size
        testWindow.setSize(new Dimension(winFullSize.getWidth()/2,winFullSize.getHeight()/2));

        Dimension newWinSize = testWindow.getSize();
        assertEquals(744/2,newWinSize.getHeight());
        assertEquals(1382/2,newWinSize.getWidth());

        //get position of half size window
        org.openqa.selenium.Point pos = testWindow.getPosition();



    }


    @AfterClass

    public static void quitDriver(){
        driver.quit();
    }

}
