package com.thetestingacademy.ex_27102024_SVGShadowDOM;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.sql.DataTruncation;
import java.util.List;

public class OrangeHRM {
    EdgeDriver driver;

    @BeforeTest
    public void openBrowser(){
        EdgeOptions options = new EdgeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.addArguments("--guest");
        driver = new EdgeDriver(options);
    }

    @Description("Login Orange")
    @Test
    public void loginUser() throws InterruptedException {
        driver.manage().window().maximize();
        String URL = "https://awesomeqa.com/hr/web/index.php/auth/login";
        String USER = "admin";
        String Pass = "Hacker@4321";

        driver.get(URL);
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys(USER);
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys(Pass);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    @Description("Table")
    @Test(dependsOnMethods = {"loginUser"})
    public void accessTable() throws InterruptedException {
//        loginUser();

        int row = driver.findElements(By.xpath("//div[@class='oxd-table-body oxd-card-table-body']/div[@class='oxd-table-card --mobile']")).size();
        int col = driver.findElements(By.xpath("//div[@class='oxd-table-body oxd-card-table-body']/div[@class='oxd-table-card --mobile'][1]/div/div")).size();


        String firstPart = "//div[@class='oxd-table-body oxd-card-table-body']/div[@class='oxd-table-card --mobile'][";
        String secondPart= "]/div/div[";
        String thirdPart = "]";
        for (int i=1; i<row; i++){
            for(int j =1; j<col; j++){
                String dynamicXpath = firstPart + i + secondPart + j + thirdPart;
                String data = driver.findElement(By.xpath(dynamicXpath)).getText();

                System.out.println(data);

                if (data.contains("Terminated")){
                    String delElementXpath = firstPart+i+secondPart+j+j+thirdPart+"/div/button[1]";
                    WebElement deleteEmp = driver.findElement(By.xpath(delElementXpath));
                    deleteEmp.click();

//                    "//div[@class='oxd-table-body oxd-card-table-body']/div[@class='oxd-table-card --mobile'][3]/div/div/div/div[2]/div/div/button[1]"

                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                    WebElement closePopUp=driver.findElement(By.xpath("//div[@role='document']/button"));
                    closePopUp.click();
                }
            }
        }
    }

    @AfterTest
    public void closeBrowser() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }
}
