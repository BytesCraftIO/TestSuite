package com.bytescraft.listener;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

/**
 * @author javaquery
 * @since 2025-07-03
 */
public class CustomListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("CustomListener: onTestStart - " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("CustomListener: onTestSuccess - " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("CustomListener: onTestFailure - " + result.getName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("CustomListener: onTestSkipped - " + result.getName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println("CustomListener: onTestFailedButWithinSuccessPercentage - " + result.getName());
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        System.out.println("CustomListener: onTestFailedWithTimeout - " + result.getName());
    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("CustomListener: onStart - " + context.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("CustomListener: onFinish - " + context.getName());
    }
}
