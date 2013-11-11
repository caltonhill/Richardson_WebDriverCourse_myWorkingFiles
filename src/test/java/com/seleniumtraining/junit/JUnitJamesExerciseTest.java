package com.seleniumtraining.junit;

import org.junit.Test;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

public class JUnitJamesExerciseTest {

    @Test
    public void twoTimesThreeIsSix(){

        assertEquals("2x3=6", 6, 2*3);

    }
    @Test
    public void twoLessThanThree(){

        assertTrue("Two less than three TRUE check failed", 2<8);

    }
    @Test
    public void nineEqualsFour(){

        assertFalse("Nine equals four FALSE check failed", 9==4);

    }
}