package com.bytescraft.depends;

import org.testng.annotations.Test;

/**
 * @author javaquery
 * @since 2024-04-30
 */
public class GroupDependencyTest {

    @Test(groups = { "viewaccount" })
    public void viewAccount() {
        System.out.println("GroupDependencyTest: View Your Dashboardd");
    }

    @Test(groups = { "openbrowser" })
    public void openBrowser() {
        System.out.println("GroupDependencyTest: Browser Opened Successfully");
    }

    @Test(groups = { "login" })
    public void logIn() {
        System.out.println("GroupDependencyTest: Login Into The Account");
    }

    @Test(groups = {"logout"})
    public void closeAccount() {
        System.out.println("GroupDependencyTest: Closing The Account");
    }
}
