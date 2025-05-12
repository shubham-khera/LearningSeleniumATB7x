package com.thetestingacademy.ex_26102024_503;

import io.qameta.allure.Description;
import org.assertj.core.api.recursive.comparison.DualValue;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;


import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;

import static com.thetestingacademy.ex_26102024_503.WaitHelpers.checkVisibilityByFluentWait;

public class Selenium035_Fluent_Wait { @Description("Verify that with invalid email, pass, error message is shown on the app.vwo.com")
@Test
public void testVwoLoginNegative() {

    // How to find the elements
    // Selenium
    // ID, NAME, CLASS NAME, TAGName,
    // Advance -> Css Selector, Xpath


    // <input type="email" class="text-input W(100%)" name="username" id="login-username" data-qa="hocewoqisi">
    EdgeOptions edgeOptions = new EdgeOptions();
    edgeOptions.addArguments("--incognito");
    edgeOptions.addArguments("--start-maximized");

    // FindElement -> 1 element first web element
    // FindElements -> which can find multiple web elements

    WebDriver driver = new EdgeDriver(edgeOptions);
    driver.navigate().to("https://app.vwo.com");
    System.out.println(driver.getTitle());

    Assert.assertEquals(driver.getTitle(), "Login - VWO");
    Assert.assertEquals(driver.getCurrentUrl(), "https://app.vwo.com/#/login");


    // 1. Find the email inputbox and enter the email
    WebElement emailInputBox = driver.findElement(By.id("login-username"));
    emailInputBox.sendKeys("admin@admin.com");


    WebElement passwordInputBox = driver.findElement(By.name("password"));
    passwordInputBox.sendKeys("password@321");


    WebElement buttonSubmit = driver.findElement(By.id("js-login-btn"));
    buttonSubmit.click();

//        // After 3 seconds error comes
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }


    // Condition
//        FluentWait<WebDriver> wait = new FluentWait<>(driver)
//                .withTimeout(Duration.ofSeconds(10))
//                .pollingEvery(Duration.ofSeconds(2)).ignoring(NoSuchElementException.class);
//
//
//        WebElement error_message = wait.until(new Function<WebDriver, WebElement>() {
//            public WebElement apply(WebDriver driver) {
//                return driver.findElement(By.className("notification-box-description"));
//            }
//        });

    WebElement error_message = checkVisibilityByFluentWait(driver,By.className("notification-box-description"));


    Assert.assertEquals(error_message.getText(), "Your email, password, IP address or location did not match");


    driver.quit();


}
}
