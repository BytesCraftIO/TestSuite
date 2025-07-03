package com.bytescraft.math;

/**
 * @author Vicky Thakor
 * @since 2025-07-03
 */
public class ScientificCalculator {
    public double sqrt(int number) {
        System.out.println("Calculating square root of " + number);

        double t;
        double sqrtroot = (double) number / 2;
        do {
            t = sqrtroot;
            sqrtroot = (t + (number / t)) / 2;
        }
        while ((t - sqrtroot) != 0);
        return sqrtroot;
    }

    public void throwAnException(){
        throw new RuntimeException("Exception check");
    }
}
