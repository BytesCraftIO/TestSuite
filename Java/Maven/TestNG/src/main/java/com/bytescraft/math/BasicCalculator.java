package com.bytescraft.math;

import java.util.logging.Logger;

/**
 * @author Vicky Thakor
 * @since 2025-07-03
 */
public class BasicCalculator {

    private static final Logger LOGGER = Logger.getLogger(BasicCalculator.class.getName());

    public BasicCalculator(){
        // Default constructor to identify the class initialization behaviour during parsing/execution
        System.out.println("BasicCalculator constructor");
    }

    public int add(int a, int b){
        LOGGER.info("Adding " + a + " and " + b);
        return a + b;
    }

    public int subtract(int a, int b){
        LOGGER.info("Subtracting " + b + " from " + a);
        return a - b;
    }

    public int multiply(int a, int b){
        LOGGER.info("Multiplying " + a + " and " + b);
        return a * b;
    }

    public int divide(int a, int b){
        if (b == 0) {
            LOGGER.severe("Division by zero attempted");
            throw new IllegalArgumentException("Cannot divide by zero");
        }
        LOGGER.info("Dividing " + a + " by " + b);
        return a / b;
    }
}
