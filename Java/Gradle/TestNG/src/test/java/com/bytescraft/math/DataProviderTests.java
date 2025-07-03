package com.bytescraft.math;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

/**
 * @author javaquery
 * @since 2025-07-03
 */
public class DataProviderTests {

    private final BasicCalculator basicCalculator = new BasicCalculator();

    @DataProvider(name = "add-data-provider")
    public Object[][] addDataProvider(){
        return new Object[][] {{2, 3 , 5}, {5, 7, 12}};
    }

    @DataProvider (name = "data-provider")
    public Object[][] dpMethod (Method m){
        switch (m.getName()) {
            case "multiply":
                return new Object[][] {{2, 3 , 6}, {5, 7, 35}, {3, 10, 30}};
            case "divide":
                return new Object[][] {{2, 2, 1}, {35, 7, 5}};
        }
        return null;
    }

    @Test(dataProvider = "add-data-provider")
    public void add_data_provider_Test(int a, int b, int result) {
        Assert.assertEquals(result, basicCalculator.add(a, b));
    }

    @Test(dataProvider = "data-provider")
    public void multiply(int a, int b, int result){
        Assert.assertEquals(result, basicCalculator.multiply(a, b));
    }

    @Test(dataProvider = "data-provider")
    public void divide(int a, int b, int result){
        Assert.assertEquals(result, basicCalculator.divide(a, b));
    }
}
