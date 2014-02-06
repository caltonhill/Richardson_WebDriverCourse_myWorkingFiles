package com.seleniumtraining.manipulation;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;


/**
 * Created by Macdonald on 03/02/14.
 */
public class ClearCommentTypeSubmitCheck {
    private static WebDriver driver;

    @BeforeClass
    public static void createDriver (){
        driver = new FirefoxDriver();
    driver.get("http://www.compendiumdev.co.uk/selenium/basic_html_form.html");
}
    @Test
    public void canClearForm (){
        List<WebElement> formElements = driver.findElements(By.cssSelector("input"));
        formElements.clear();
    }

    @Test
    public void canAddComment(){
        WebElement textArea = driver.findElement(By.cssSelector("textarea[name='comments']"));
        textArea.sendKeys("User adds comment here");

        WebElement submitButton = driver.findElement(By.cssSelector("input[type='submit']"));
        submitButton.click();

        new WebDriverWait(driver,2,25).until(
                ExpectedConditions.titleContains("Processed Form"));

        WebElement processedComment = driver.findElement(By.cssSelector("li[id='_valuecomments']"));
        assertThat(processedComment.getText(), containsString("User adds comment here"));
        System.out.println(processedComment.getText());
    }

    @AfterClass
    public static void quitDriver(){
        driver.quit();
    }
}
