package com.bytescraft.depends;

import org.testng.annotations.Test;

/**
 * @author javaquery
 * @since 2024-04-30
 */
public class SingleMethodDependsOnTest {

    @Test
    public void openBrowser() {
        System.out.println("SingleMethodDependsOnTest: The browser is opened");
    }

    @Test(dependsOnMethods = {"openBrowser"})
    public void signIn() {
        System.out.println("SingleMethodDependsOnTest: User has signed in successfully");
    }

    @Test (dependsOnMethods = {"signIn"})
    public void logOut() {
        System.out.println("SingleMethodDependsOnTest: The user logged out successfully");
    }
}
