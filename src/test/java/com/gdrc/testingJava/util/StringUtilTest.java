package com.gdrc.testingJava.util;

import org.junit.Test;

import static org.junit.Assert.*;

public class StringUtilTest {
    @Test
    public void repeatString3Times() {
        assertEquals("holaholahola", StringUtil.repeat("hola", 3));
    }

    @Test
    public void repeatStringCeroTimes() {
        assertEquals("", StringUtil.repeat("hola", 0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwExceptionIfStringRepeatsNegativeTimes() {
        StringUtil.repeat("hola", -1);
    }
}