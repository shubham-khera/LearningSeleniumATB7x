package com.thetestingacademy.ex_19102024_502.Task02;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Task_FillForm {

    @Description("Fill the form")
    @Test
    public static void fillForm() throws InterruptedException {
        ChromeOptions chromeOptions = new ChromeOptions();
//        chromeOptions.addArguments("--incognito");
        chromeOptions.addArguments("inprivate");
        chromeOptions.addArguments("--start-maximized");

        // 1. Navigate to the we page

        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.navigate().to("https://awesomeqa.com/ui/index.php?route=account/register");

        Assert.assertEquals(driver.getCurrentUrl(), "https://awesomeqa.com/ui/index.php?route=account/register");
        Assert.assertEquals(driver.getTitle(), "Register Account");

        WebElement fName = driver.findElement(By.id("input-firstname"));
        fName.sendKeys("Shubham");

        WebElement lName = driver.findElement(By.id("input-lastname"));
        lName.sendKeys("Khera");// input-email

        WebElement emailInput = driver.findElement(By.id("input-email"));
        emailInput.sendKeys("skhera07@gmail.com");

        WebElement phoneInput = driver.findElement(By.id("input-telephone"));
        phoneInput.sendKeys("+911234567899");

        WebElement pwInput = driver.findElement(By.id("input-password"));
        pwInput.sendKeys("password@123");

        WebElement pwInputCfn = driver.findElement(By.id("input-confirm"));
        pwInputCfn.sendKeys("password@123");

        WebElement checkBoxPrivacy1 = driver.findElement(By.cssSelector("input[type='checkbox'][name='agree'][value='1']"));
        checkBoxPrivacy1.click();

        WebElement cfnButton = driver.findElement(By.cssSelector("input[type='submit'][class='btn btn-primary']"));
        cfnButton.click();

        Thread.sleep(5000);

        Assert.assertTrue(driver.getPageSource().contains("Your Account Has Been Created!"));
        Assert.assertEquals(driver.getCurrentUrl(), "https://awesomeqa.com/ui/index.php?route=account/success");

        driver.quit();
    }
}
