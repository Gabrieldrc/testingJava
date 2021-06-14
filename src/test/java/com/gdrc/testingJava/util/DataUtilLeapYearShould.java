package com.gdrc.testingJava.util;

import org.junit.Test;

import static org.junit.Assert.*;

public class DataUtilLeapYearShould {
    /*
        All years divisible by 400 ARE Leap years (1600, 2000, 2400)
        All years divisible by 100 but not by 400 are NOT leap years (1700, 1800, 1900),
        All years divisible by 4 but not by 100 ARE 1eap years (1996, 2004, 2008),
        All years not divisible by 4 are NOT Leap years (2017, 2018, 2019)
     */
    @Test
    public void return_true_when_xxx() {
        assertTrue(DataUtil.isLeapYear(1600));
        assertTrue(DataUtil.isLeapYear(2000));
        assertTrue(DataUtil.isLeapYear(2400));
    }

    @Test
    public void return_false_when_year_is_divisible_by_100_but_not_by_400() {
        assertFalse(DataUtil.isLeapYear(1700));
        assertFalse(DataUtil.isLeapYear(1800));
        assertFalse(DataUtil.isLeapYear(1900));
    }

    @Test
    public void return_true_when_year_is_divisble_by_4_but_not_by_100() {
        assertTrue(DataUtil.isLeapYear(1996));
        assertTrue(DataUtil.isLeapYear(2004));
        assertTrue(DataUtil.isLeapYear(2008));
    }

    @Test
    public void return_false_when_year_is_not_divisible_by_4() {
        assertFalse(DataUtil.isLeapYear(2017));
        assertFalse(DataUtil.isLeapYear(2018));
        assertFalse(DataUtil.isLeapYear(2019));
    }
}