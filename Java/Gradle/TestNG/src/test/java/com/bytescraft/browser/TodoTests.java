package com.bytescraft.browser;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

/**
 * @author javaquery
 * @since 2025-07-03
 */
public class TodoTests {

    private WebDriver driver;
    private WebDriverWait wait;
    private static final String baseUrl = "https://example.cypress.io/todo";

    @BeforeClass
    public void setup() {
        WebDriverManager.edgedriver().setup(); // auto-download correct msedgedriver
        EdgeOptions options = new EdgeOptions();
        driver = new EdgeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }

    @Test(priority = 1)
    public void testAddItems() {
        WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("new-todo")));
        input.sendKeys("Buy milk\n");
        input.sendKeys("Write TestNG tests\n");

        List<WebElement> todoItems = driver.findElements(By.cssSelector(".todo-list li"));
        Assert.assertTrue(todoItems.size() >= 2, "At least 2 items should be present.");
    }

    @Test(priority = 2)
    public void testCountItems() {
        List<WebElement> items = driver.findElements(By.cssSelector(".todo-list li"));
        int count = items.size();
        System.out.println("Total TODO items: " + count);
        Assert.assertTrue(count > 0, "There should be some todo items.");
    }

    @Test(priority = 3)
    public void testRemoveItem() {
        List<WebElement> items = driver.findElements(By.cssSelector(".todo-list li"));
        int originalCount = items.size();

        if (originalCount == 0) {
            Assert.fail("No items to delete.");
        }

        WebElement firstItem = items.get(0);
        Actions actions = new Actions(driver);
        actions.moveToElement(firstItem).perform();

        WebElement destroyButton = firstItem.findElement(By.cssSelector("button.destroy"));
        // Using JS because destroy button is hidden until hover
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", destroyButton);

        // Wait for item count to reduce
        wait.until(driver -> driver.findElements(By.cssSelector(".todo-list li")).size() < originalCount);

        int updatedCount = driver.findElements(By.cssSelector(".todo-list li")).size();
        Assert.assertEquals(updatedCount, originalCount - 1, "Item should be removed");
    }

    @AfterClass
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

