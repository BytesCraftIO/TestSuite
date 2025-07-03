package com.bytescraft.math;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author vicky.thakor
 * @since 2025-07-03
 */
public class NumbersTests {

    @Test
    public void isOdd_test(){
        Assert.assertTrue(Numbers.isOdd(3));
    }
}
