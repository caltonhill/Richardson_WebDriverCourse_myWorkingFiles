package com.seleniumtraining.junit;

import org.junit.*;

/**
 * Created with IntelliJ IDEA.
 * User: Macdonald
 * Date: 29/10/13
 * Time: 21:17
 * To change this template use File | Settings | File Templates.
 */
public class JUnitBeforeAfterTest {
    @BeforeClass
    public static void beforeClass(){
        System.out.println("Before Class");
    }
    @Before
    public void beforeTest(){
        System.out.println("Before Test");
            }
    @After
    public void afterTest(){
        System.out.println("After Test");
    }
    @Test
    public void aUselessTest1(){
        System.out.println("This is 1 Test");
    }
    @Test
    public void aUselessTest2(){
        System.out.println("This is 2 Test");
}
    @Test
    public void aUselessTest3(){
        System.out.println("This is 3 Test");
    }
    @AfterClass
    public static void afterClass(){
        System.out.println("After Class");
    }
}
