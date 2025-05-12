package com.thetestingacademy.ex_26102024_503;

import io.qameta.allure.Description;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Selenium038_Alerts {

    @Description("Testing Alerts")
    @Test
    public static void alertsTest() {
        EdgeDriver driver = new EdgeDriver();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        System.out.println(driver.getTitle());
        driver.manage().window().maximize();

        // //button[text()='Click for JS Alert']
        // //button[@onclick='jsAlert()']

        // WebElement element = driver.findElement(By.cssSelector("button[onclick='jsAlert()']"));
         WebElement elementConfirm = driver.findElement(By.xpath("//button[@onclick=\"jsConfirm()\"]"));
//        WebElement elementPrompt = driver.findElement(By.xpath("//button[@onclick='jsPrompt()']"));

        // element.click();
         elementConfirm.click();
//        elementPrompt.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.alertIsPresent());

        Alert alert = driver.switchTo().alert();
//        alert.sendKeys("Shubham");
//        alert.accept();
         alert.dismiss();

        String result = driver.findElement(By.id("result")).getText();
        // Assert.assertEquals(result,"You successfully clicked an alert");
        // Assert.assertEquals(result,"You clicked: Ok");
         Assert.assertEquals(result,"You clicked: Cancel");
//        Assert.assertEquals(result, "You entered: Shubham");

        driver.quit();

    }
}
