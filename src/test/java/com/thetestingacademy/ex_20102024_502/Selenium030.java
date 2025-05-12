package com.thetestingacademy.ex_20102024_502;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Selenium030 {

    @Description("")
    @Test
    public void prices_imac() throws InterruptedException {
        EdgeDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.ebay.com");

        WebElement searchInput = driver.findElement(By.cssSelector("input[title='Search']"));
        searchInput.sendKeys("imac");
        searchInput.sendKeys(Keys.ENTER);


//        WebElement searchBtn = driver.findElement(By.cssSelector("span[class='gh-search-button__label']"));
//        searchBtn.click();

        Thread.sleep(3000);

        Assert.assertTrue(driver.getCurrentUrl().contains("https://www.ebay.com/sch/i.html?_nkw=imac&_sacat=0&_from=R40&_trksid"));

        // Print all the elements
        List<WebElement> searchTitles= driver.findElements(By.cssSelector(".s-item__title"));
        //div[@class="s-item__title"]/span
        List<WebElement> searchTitlePrices = driver.findElements(By.cssSelector(".s-item__price"));
        // span[@class='s-item__price']
        // max -> loop where
        int size = Math.min(searchTitles.size(), searchTitlePrices.size());
        for (int i=0; i<size; i++){
            System.out.println(searchTitles.get(i).getText() + " || " + searchTitlePrices.get(i).getText());
            System.out.println();
            // Max Price or Min Price - Print it
//            Math.max();

        }
    }
}
