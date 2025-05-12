package com.thetestingacademy.ex_12102024_501;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import java.io.File;

public class Selenium009 {
    public static void main(String[] args) {
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addExtensions(new File("src/test/java/com/thetestingacademy/adblock.crx"));

        EdgeDriver driver = new EdgeDriver(edgeOptions);
        driver.manage().window().maximize();
        driver.get("https://sdet.live");

    }
}
