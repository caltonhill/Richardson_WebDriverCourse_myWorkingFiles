package com.seleniumtraining.windows;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Set;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


/**
 * Created by James on 10/03/14.
 */

//MISSED THE POINT HERE. CAME UP WITH COMPLICATED SEQUENCE TO FIND WINDOW
//HANDLES WHEN COULD HAVE USED WINDOW NAMES SET IN THE PAGE SOURCE

public class WindowsExercise2 {
    private static WebDriver driver;
    private static String baseURL = "http://www.compendiumdev.co.uk/selenium";

    @BeforeClass
    public static void createDriver(){
        driver = new FirefoxDriver();
        driver.get(baseURL + "/frames/index.html");

    }

    @Test
    public void open2WindowsAndSwitch(){
    //check for right starting page
   assertThat(driver.getTitle(), containsString("(Example 6)"));
        //get first window handle
       String startingWindowHandle = driver.getWindowHandle();

        //switch to frame and click EvilTester link
        driver.switchTo().frame("content");

        driver.findElement(By.id("goevil")).click();

        //assert there are now two window handles available

        Set<String> windowHandles = driver.getWindowHandles();
        assertThat(windowHandles.size(), is(2));
        //set String variable to empty
        String windowHandleTwo="";
        // for each handle in the set compare the name to
        //startingWindowHandle. If it doesn't match, call it WindowHandleTwo
        for(String aHandle : windowHandles){
            if(!startingWindowHandle.contentEquals(aHandle)){
                windowHandleTwo = aHandle; break;
            }

        }
        System.out.println("starting is: " + startingWindowHandle);
        System.out.println("two is: " + windowHandleTwo);
        //switch back to startingWindow and
        //click Compendium Developments link
       driver.switchTo().window(startingWindowHandle);
        driver.switchTo().frame("content");

        driver.findElement(By.linkText("Compendium Developments")).click();
        //check for 3 window handles in total
        windowHandles = driver.getWindowHandles();
        assertThat(windowHandles.size(), is(3));

        //switch to starting window and close it
        driver.switchTo().window(startingWindowHandle).close();

        //assert there are now 2 windows
        windowHandles = driver.getWindowHandles();
        assertThat(windowHandles.size(), is(2));

        //for the 2 remaining open windows find windowhandle3
        //by identifying one which is not windowHandleTwo

       String windowHandle3 = "";

       for(String aHandle : windowHandles){
                if(!windowHandleTwo.contentEquals(aHandle)){
                    windowHandle3 = aHandle; break;
                }
            }
        System.out.println("Window Handle 2: " + windowHandleTwo);
        System.out.println("Window Handle 3: " + windowHandle3);
//switch to window handle 3 and close it
        driver.switchTo().window(windowHandle3).close();
//switch to window handle 2 and assert handle
        driver.switchTo().window(windowHandleTwo);

        assertThat(driver.getWindowHandle(), is(windowHandleTwo));

        }


    @AfterClass
    public static void quitDriver(){
        driver.quit();
    }
}
