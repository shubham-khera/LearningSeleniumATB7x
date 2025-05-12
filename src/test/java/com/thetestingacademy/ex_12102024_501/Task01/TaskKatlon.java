package com.thetestingacademy.ex_12102024_501.Task01;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

// Open the Page - https://katalon-demo-cura.herokuapp.com/
// Verify the current URL, current title
// In the page source add a assertion that “CURA Healthcare Service” exist in the page. driver.pageSource() - String
public class TaskKatlon {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://katalon-demo-cura.herokuapp.com/");

        Assert.assertEquals(driver.getCurrentUrl(), "https://katalon-demo-cura.herokuapp.com/");
        Assert.assertEquals(driver.getTitle(), "CURA Healthcare Service");
        Assert.assertEquals(driver.getPageSource(), "CURA Healthcare Service");

        driver.quit();
    }
}
