package com.bytescraft.depends;

import org.testng.annotations.Test;

/**
 * @author javaquery
 * @since 2024-04-30
 */
public class GroupDependsOnTest {

    @Test(dependsOnGroups = { "SignIn" })
    public void viewAcc() {
        System.out.println("GroupDependsOnTest: View Your Dashboard");
    }

    @Test(groups = { "SignIn" })
    public void openBrowser() {
        System.out.println("GroupDependsOnTest: Browser Opened Successfully");
    }

    @Test(groups = { "SignIn" })
    public void logIn() {
        System.out.println("GroupDependsOnTest: Login Into The Account");
    }
}
