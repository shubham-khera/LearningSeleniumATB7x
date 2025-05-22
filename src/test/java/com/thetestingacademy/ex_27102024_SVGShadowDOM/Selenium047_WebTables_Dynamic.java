package com.thetestingacademy.ex_27102024_SVGShadowDOM;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.List;

public class Selenium047_WebTables_Dynamic {
    EdgeDriver driver;

    @BeforeTest
    public void openBrowser(){
        EdgeOptions options = new EdgeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.addArguments("--guest");
        driver = new EdgeDriver(options);
    }

    @Description
    @Test
    public void test_web_tables() throws InterruptedException{
        driver.manage().window().maximize();
        String URL = "https://awesomeqa.com/webtable1.html";
        driver.get(URL);
        driver.manage().window().maximize();

        //Find the xPath for the WebTables
        //table[@summary='Sample Table']

        WebElement table = driver.findElement(By.xpath("//table[@summary='Sample Table']"));
        List<WebElement> row_tables = table.findElements(By.tagName("tr"));

        for(int i = 0; i < row_tables.size(); i++){
            List<WebElement> col = row_tables.get(i).findElements(By.tagName("td"));
            for (WebElement c : col){
                System.out.println(c.getText());
            }
        }
    }
}
