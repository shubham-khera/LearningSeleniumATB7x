package com.thetestingacademy.ex_27102024_SVGShadowDOM;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class Selenium039_SVG_P1 {

    WebDriver driver;

    @BeforeTest
    public void openBrowser(){
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        edgeOptions.addArguments("--guest");
        driver = new EdgeDriver(edgeOptions);
    }

    @Description("Verify that the after search, results are visible.")
    @Test
    public void test_flipkart_search() throws InterruptedException {
        driver.manage().window().maximize();
        String URL = "https://www.flipkart.com";
        driver.get(URL);
        driver.manage().window().maximize();

        // Step 1: Enter the "macmini" in the inputbox
        driver.findElement(By.name("q")).sendKeys("macmini");

        //Step 2: Click on the SVG element.
        List<WebElement> svgElement = driver.findElements(By.xpath("//*[name()='svg']"));
        svgElement.get(0).click();

        List<WebElement> titleElements = driver.findElements(By.xpath("//div[contains(@data-id,'CPU')]/div/a[2]"));
        for (WebElement titleE : titleElements){
            System.out.println(titleE.getText());
        }
    }

    @AfterTest
    public void closeBrowser(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e){
            throw new RuntimeException(e);
        }
        driver.quit();
    }
}
