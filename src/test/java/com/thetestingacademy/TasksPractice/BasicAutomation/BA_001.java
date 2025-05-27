package com.thetestingacademy.TasksPractice.BasicAutomation;
// Open a Website and Verify Title
    //Open Google (or any website) and verify the page title using assertions.

import io.qameta.allure.Description;
import net.bytebuddy.implementation.bytecode.Throw;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BA_001 {
    EdgeDriver driver;

    @BeforeTest
    public void openBrowser(){
        EdgeOptions options = new EdgeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.addArguments("--guest");
        driver = new EdgeDriver(options);
    }

    @Description("Visit Google and verify title")
    @Test
    public void visitAssert(){
        driver.manage().window().maximize();
        String URL = "https://www.google.com";
        driver.get(URL);
        System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getTitle(), "Google");
    }

    @AfterTest
    public void closeBrowser(){
        try {
            Thread.sleep(3000);
        } catch ( InterruptedException e){
            throw new RuntimeException(e);
        } driver.quit();
    }
}
