package com.thetestingacademy.ex_12102024_501.Project01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;

public class Selenium12 {
    // Open the app.VWO.com
    // We want to verify the title by using the TestNG assertion

    public static void main(String[] args) {
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--Start-maximized");

        WebDriver driver = new EdgeDriver();
        driver.get("https://app.vwo.com");

//        driver.manage().window().maximize();
//        driver.manage().window().minimize();

        Assert.assertEquals(driver.getTitle(), "Login - VWO");
        Assert.assertEquals(driver.getCurrentUrl(), "https://app.vwo.com/#/login");

        driver.quit();
    }
}
