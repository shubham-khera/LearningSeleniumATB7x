package com.thetestingacademy.ex_12102024_501;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriver;

public class Selenium001 {
    // Code here -> API Request -> Browser Driver(Server) .exe, sh,s -> Browsers (Chrome, Edge)
    public static void main(String[] args) {
        ChromiumDriver driver = new ChromeDriver();
        driver.get("https://app.vwo.com");

//        FirefoxDriver driver1 = new FirefoxDriver();
//        driver1.get("https://www.google.com");
    }
}
