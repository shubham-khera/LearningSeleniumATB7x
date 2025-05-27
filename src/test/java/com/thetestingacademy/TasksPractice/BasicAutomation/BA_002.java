package com.thetestingacademy.TasksPractice.BasicAutomation;
// Login Automation
    //Automate login functionality for a demo site (like https://the-internet.herokuapp.com/login).
    // Enter username, password, and click login.
    //Verify if login is successful (e.g., check if logout button appears).


import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BA_002 {
    EdgeDriver driver;


    @BeforeTest
    public void openBrowser(){
        EdgeOptions options = new EdgeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.addArguments("--guest");
        driver = new EdgeDriver(options);
    }


    @Description("Automating functionality for demo site herokuapp")
    @Test
    public void automateApp(){
        driver.manage().window().maximize();
        String URL = "https://the-internet.herokuapp.com/login";
        String USERNAME = "tomsmith";
        String PWORD = "SuperSecretPassword!";
        driver.get(URL);

        // 1. Enter User name
        driver.findElement(By.xpath("//input[@name='username'][@id='username']"))
                .sendKeys(USERNAME);

        // 2. Enter Password
        driver.findElement(By.xpath("//input[@name='password'][@id='password']"))
                .sendKeys(PWORD);

        // 3. Click Login Button
        driver.findElement(By.cssSelector("button[class='radius'][type='submit']")).click();

        Assert.assertTrue(driver.findElement(By.cssSelector("a[class='button secondary radius']")).isDisplayed());
    }

    @Description("Automating functionality for demo site herokuapp for validation message")
    @Test
    public void notLogin(){
        driver.manage().window().maximize();
        String URL = "https://the-internet.herokuapp.com/login";
        String USERNAME = "tomsmithFake";
        String PWORD = "SuperSecretPassword!";
        driver.get(URL);

        // 1. Enter User name
        driver.findElement(By.xpath("//input[@name='username'][@id='username']"))
                .sendKeys(USERNAME);

        // 2. Enter Password
        driver.findElement(By.xpath("//input[@name='password'][@id='password']"))
                .sendKeys(PWORD);

        // 3. Click Login Button
        driver.findElement(By.cssSelector("button[class='radius'][type='submit']")).click();

        System.out.println(driver.findElement(By.xpath("//div[@class='flash error']")).getText());

        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='flash error']")).getText(), "Your username is invalid!\n×" );
    }

    @AfterTest
    public void closeBrowser(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e){
            throw new RuntimeException(e);
        } driver.quit();
    }
}
