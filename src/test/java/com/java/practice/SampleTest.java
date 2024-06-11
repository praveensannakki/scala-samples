package com.java.practice;


import org.junit.Assert;
import org.junit.Test;

public class SampleTest {
    @Test
    public void addition_isCorrect() {
        Assert.assertEquals(1+3, 4);
    }

    @Test
    public void addition_isIncorrect() {
        Assert.assertNotEquals(1+3, 5);
    }
}
