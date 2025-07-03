package com.bytescraft.browser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

/**
 * @author javaquery
 * @since 2025-07-03
 */
public class LoginTests {
    private WebDriver driver;
    private static final String baseUrl = "https://the-internet.herokuapp.com/login";

    @BeforeClass
    public void setup() {
        WebDriverManager.edgedriver().setup();
        EdgeOptions options = new EdgeOptions();
        driver = new EdgeDriver(options);
        driver.manage().window().maximize();
    }

    @Test(priority = 1)
    public void testSuccessfulLogin() {
        driver.get(baseUrl);

        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.cssSelector("button.radius")).click();

        WebElement successMsg = driver.findElement(By.id("flash"));

        Assert.assertTrue(successMsg.isDisplayed(), "Success message not displayed.");
        Assert.assertTrue(successMsg.getText().contains("You logged into a secure area!"), "Login failed unexpectedly.");

        // Optional: Logout after successful login
        driver.findElement(By.cssSelector(".icon-2x.icon-signout")).click();
    }

    @Test(priority = 2)
    public void testFailedLogin_WrongUsername() {
        driver.get(baseUrl);

        driver.findElement(By.id("username")).sendKeys("wronguser");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.cssSelector("button.radius")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement errorMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("flash")));

        Assert.assertTrue(errorMsg.isDisplayed(), "Error message not displayed.");
        Assert.assertTrue(errorMsg.getText().contains("Your username is invalid!"), "Unexpected error message.");
    }

    @Test(priority = 3)
    public void testFailedLogin_WrongPassword() {
        driver.get(baseUrl);

        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("WrongPassword123");
        driver.findElement(By.cssSelector("button.radius")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement errorMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("flash")));

        Assert.assertTrue(errorMsg.isDisplayed(), "Error message not displayed.");
        Assert.assertTrue(errorMsg.getText().contains("Your password is invalid!"), "Unexpected error message.");
    }

    @AfterClass
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
