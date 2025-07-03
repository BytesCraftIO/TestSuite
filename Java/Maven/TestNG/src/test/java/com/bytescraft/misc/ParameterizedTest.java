package com.bytescraft.misc;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * @author javaquery
 * @since 2025-07-03
 */
public class ParameterizedTest {

    private String username;
    private String password;

    @BeforeMethod(onlyForGroups = {"parameterizedGroup"})
    @Parameters(value = {"username", "password"})
    public void setUp(String username, String password){
        this.username = username;
        this.password = password;
    }

    @Test(groups = {"parameterizedGroup"})
    public void login(){
        System.out.println("username: " + username);
        System.out.println("password: " + password);
    }

    @Test
    public void independentTest(){
        System.out.println("Independent test");
    }
}
