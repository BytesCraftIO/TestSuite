package com.bytescraft.depends;

import org.testng.annotations.Test;

/**
 * @author javaquery
 * @since 2024-04-30
 */
public class MultipleMethodDependsOnTest {

    @Test
    public void openBrowser() {
        System.out.println("MultipleMethodDependsOnTest: Opening The Browser");
    }

    @Test
    public void signIn() {
        System.out.println("MultipleMethodDependsOnTest: Signing In");
    }

    @Test(dependsOnMethods = {"signIn", "openBrowser"})
    public void logOut() {
        System.out.println("MultipleMethodDependsOnTest: Logging Out");
    }
}
