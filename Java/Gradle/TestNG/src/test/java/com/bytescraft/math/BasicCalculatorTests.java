package com.bytescraft.math;

import org.testng.Assert;
import org.testng.annotations.*;

import java.util.logging.Logger;

/**
 * @author javaquery
 * @since 2025-07-03
 */
public class BasicCalculatorTests {

    private final Logger LOGGER = Logger.getLogger(BasicCalculatorTests.class.getName());

    private BasicCalculator basicCalculator = new BasicCalculator();

    @BeforeClass(alwaysRun = true)
    public static void loader(){
        System.out.println("static method before class");
    }

    @BeforeMethod(alwaysRun = true)
    public void setUp(){
        LOGGER.info("BasicCalculatorTests#setUp");
        basicCalculator = new BasicCalculator();
    }

    @BeforeTest(alwaysRun = true)
    public void setUpBeforeTest(){
        LOGGER.info("BasicCalculatorTests#setUpBeforeTest");
        basicCalculator = new BasicCalculator();
    }

    @Test(groups = {"FastTest"})
    public void add_test(){
        Assert.assertEquals(4, basicCalculator.add(2, 2));
        LOGGER.info("BasicCalculatorTests#add_test");
    }

    @Test
    public void subtract_test(){
        Assert.assertEquals(0, basicCalculator.subtract(2, 2));
        LOGGER.info("BasicCalculatorTests#subtract_test");
    }

    @Test(groups = {"SlowTest"})
    public void multiply_test(){
        Assert.assertEquals(4, basicCalculator.multiply(2, 2));
        LOGGER.info("BasicCalculatorTests#multiply_test");
    }

    @Test
    public void divide_test(){
        Assert.assertEquals(3, basicCalculator.divide(9, 3));
        LOGGER.info("BasicCalculatorTests#divide_test");
    }

    @Test
    @Ignore
    public void ignoreTest(){
        LOGGER.info("BasicCalculatorTests#ignoreTest");
    }

    @AfterMethod(alwaysRun = true)
    public void after(){
        System.out.println("after each test case");
        LOGGER.info("BasicCalculatorTests#after");
    }

    @AfterClass(alwaysRun = true)
    public static void cleanUp(){
        System.out.println("static method after class");
    }
}
