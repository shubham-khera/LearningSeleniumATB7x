package com.thetestingacademy.ex_27102024_SVGShadowDOM;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Selenium040_SVG_P3 {

    WebDriver driver;
    String URL = "https://www.youtube.com";

    @BeforeTest
    public void openBrowser(){
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        edgeOptions.addArguments("--guest");
        driver = new EdgeDriver(edgeOptions);
    }

    @Description("Verify that the tripura is in india and click on it.")
    @Test
    public void findElement(){
        driver.manage().window().maximize();

        driver.navigate().to(URL);

        WebElement searchBarInput = driver.findElement(By.cssSelector("input[name='search_query']"));
        searchBarInput.sendKeys("Machine Learning");
    }
}
