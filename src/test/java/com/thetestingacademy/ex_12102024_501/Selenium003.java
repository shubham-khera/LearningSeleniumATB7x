package com.thetestingacademy.ex_12102024_501;

import org.testng.annotations.Test;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Selenium003 {

    @Test
    public void test_001(){
        FirefoxDriver driver = new FirefoxDriver();
        driver.get("https://sdet.live");
        driver.quit();
    }
}
