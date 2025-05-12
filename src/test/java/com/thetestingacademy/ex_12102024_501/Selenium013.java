package com.thetestingacademy.ex_12102024_501;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Selenium013 {
    // Open the app.vwo.com
    // We want to verify the title by using the TestNG assertion.

    @Test
    public void testVWOLoginPageTitle(){
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--start-maximized");
        WebDriver driver = new EdgeDriver(edgeOptions);
        driver.get("https://app.vwo.com");
//        driver.manage().window().maximize();
//        driver.manage().window().minimize();

        Assert.assertEquals(driver.getTitle(),"Login - VWO");
        Assert.assertEquals(driver.getCurrentUrl(),"https://app.vwo.com/#/login");
        driver.quit();





    }
}
