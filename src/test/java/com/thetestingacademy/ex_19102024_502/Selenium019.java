package com.thetestingacademy.ex_19102024_502;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Selenium019 {
    public static void main(String[] args) {
        WebDriver driver = new EdgeDriver();
        driver.get("https://app.vwo.com");

        driver.close();
        // Close the Current Browser Window
        // Session ID != NULL
        // Not the full browser

        driver.quit();
        // Close all the /sessions/windows and stop the browser
        // Session = null, Error - Session ID is null

    }
}
