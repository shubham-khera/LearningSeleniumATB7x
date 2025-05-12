package com.thetestingacademy.ex_19102024_502;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.Test;

public class Selenium026 {

    @Description("Verify that with invalid email, pass, error message is shown on the app.vwo.com")
    @Test
    public void testVwoLoginNegative() {
        // ID, ClassName, Name, Link and Partial

        WebDriver driver = new EdgeDriver();
        driver.get("https://awesomeqa.com/practice.html");
        driver.findElement(By.id("sex-0")).click();

        // TagNAME and Xpath, Css Selector


    }

}