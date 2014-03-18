package com.seleniumtraining.windows;

        import org.junit.BeforeClass;
        import org.junit.Test;

        import org.openqa.selenium.By;

        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.firefox.FirefoxDriver;

        import java.util.Iterator;
        import java.util.Set;

        import static junit.framework.Assert.assertEquals;

        import static junit.framework.Assert.assertTrue;

public class WindowsExercise1 {

    private static WebDriver driver;

    @BeforeClass
    public static void createDriver(){
        driver = new FirefoxDriver();
    }

    @Test

    public void switchToNewWindow(){

// Current bug open with chrome driver

// http://code.google.com/p/chromedriver/issues/detail?id=107

        driver.get(

                "http://www.compendiumdev.co.uk/selenium/frames/index.html");

        String framesWindowHandle = driver.getWindowHandle();
        assertEquals("Expected only 1 current window", 1, driver.getWindowHandles().size());

        driver.switchTo().frame("content");
        driver.findElement(By.cssSelector("a[href='http://www.seleniumsimplified.com']")).click();
        assertEquals("Expected a New Window opened", 2, driver.getWindowHandles().size());

        //Richardson uses iterating here to work out name
        //sort of basic Java stuff you need to learn
        String newWindowHandle=framesWindowHandle;
        Iterator<String> aHandle = driver.getWindowHandles().iterator();
        while(newWindowHandle.equals(framesWindowHandle)){
            newWindowHandle = aHandle.next();

        }

        driver.switchTo().window(newWindowHandle);

        assertTrue("Expected Selenium Simplified site",

                driver.getTitle().contains("Selenium Simplified"));

       driver.switchTo().window(framesWindowHandle);

        assertTrue("Expected Frames Site",driver.getTitle().contains("Frameset Example"));

        driver.quit();

    }

}