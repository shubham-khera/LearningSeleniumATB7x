package com.thetestingacademy.ex_12102024_501;

import org.openqa.selenium.edge.EdgeDriver;

public class Selenium007 {
    public static void main(String[] args) {
        EdgeDriver driver = new EdgeDriver();
        driver.get("https://sdet.live");
        driver.quit();


    }
}
