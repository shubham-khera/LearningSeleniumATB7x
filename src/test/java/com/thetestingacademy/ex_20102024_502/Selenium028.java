package com.thetestingacademy.ex_20102024_502;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Selenium028 {

    @Description("Verify that Free trial expire message in idrive.com")
    @Test
    public void test_verify_expire_message() throws InterruptedException {
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--start-maximized");

        EdgeDriver driver = new EdgeDriver(edgeOptions);
        driver.get("https://www.idrive360.com/enterprise/login");

        Thread.sleep(3000);
//        driver.manage().window().maximize();
//        WebElement usernameInput_name = driver.findElement(By.name("username"));
//        WebElement usernameInput_id = driver.findElement(By.id("#username"));
//        WebElement usernameInput_css = driver.findElement(By.cssSelector("input[id='username']"));
        WebElement usernameInput_xPath = driver.findElement(By.xpath("//input[@id='username']"));
        usernameInput_xPath.sendKeys("augtest_040823@idrive.com");

        WebElement passwordInput = driver.findElement(By.id("password"));
        passwordInput.sendKeys("123456");

        WebElement spanCheckbox = driver.findElement(By.className("id-checkmark"));
        if(!spanCheckbox.isSelected()){
            spanCheckbox.click();
        }

        WebElement signBtn = driver.findElement(By.cssSelector("button[type='submit']"));
        signBtn.click();

        Thread.sleep(20000);

        WebElement expireMessage = driver.findElement(By.xpath("//h5[@class='id-card-title']"));
        Assert.assertEquals(expireMessage.getText(), "Your free trial has expired");

        Thread.sleep(10000);

        driver.quit();


    }

}
