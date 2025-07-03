package com.bytescraft.depends;

import org.testng.annotations.Test;

/**
 * @author javaquery
 * @since 2024-04-30
 */
public class InheritedDependsOnTest extends BrowserTest{

    @Test(dependsOnMethods = { "openBrowser" })
    public void signIn() {
        System.out.println("PageDependsOnTest: Signing In");
    }
}
