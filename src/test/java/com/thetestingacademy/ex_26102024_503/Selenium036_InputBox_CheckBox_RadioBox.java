package com.thetestingacademy.ex_26102024_503;

import org.openqa.selenium.By;
import org.openqa.selenium.edge.EdgeDriver;

public class Selenium036_InputBox_CheckBox_RadioBox {
    public static void main(String[] args) {
        EdgeDriver driver = new EdgeDriver();
        driver.get("https://awesomeqa.com/practice.html");

        driver.findElement(By.name("fistname")).sendKeys("the testing academy");

        // Radio Box
        driver.findElement(By.id("sex-1")).click();

        // Checkbox
        driver.findElement(By.id("tool-1")).click();
    }
}
