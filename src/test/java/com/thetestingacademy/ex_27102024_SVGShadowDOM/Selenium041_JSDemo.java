package com.thetestingacademy.ex_27102024_SVGShadowDOM;

import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class Selenium041_JSDemo {

    @Test
    public void test_shadow_dom(){
        WebDriver driver = new EdgeDriver();
        String URL = "https://selectorshub.com/xpath-practice-page/";
        driver.get(URL);
        driver.manage().window().maximize();
        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement divToScroll = driver.findElement(By.xpath("//div[@id='userName']"));
        js.executeScript("arguments[0].scrollIntoView(true);", divToScroll);

//        js.executeScript("alert('Hello')");

        WebElement inputBoxPizza = (WebElement) js.executeScript("return document.querySelector(\"div#userName\").shadowRoot.querySelector(\"div#app2\").shadowRoot.querySelector(\"input#pizza\");");
        inputBoxPizza.sendKeys("Chicken Loaded");
    }
}
