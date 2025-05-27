package com.thetestingacademy.TasksPractice.BasicAutomation;

// Form Filling and Submission
    // Navigate to a form (like https://www.seleniumeasy.com/test/input-form-demo.html).
                                // -- https://demoqa.com/automation-practice-form
    // Fill out all fields and submit.
    // Validate success message.


import io.qameta.allure.Description;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import javax.security.auth.Subject;
import java.security.Key;
import java.util.List;

public class BA_003 {

    EdgeDriver driver;

    @BeforeTest
    public void openBrowser(){
        EdgeOptions options = new EdgeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.addArguments("--guest");
        driver = new EdgeDriver(options);
    }

    @Description("Fill the Form")
    @Test
    public void fillForm() throws InterruptedException {
        driver.manage().window().maximize();
        String URL = "https://demoqa.com/automation-practice-form";
        driver.get(URL);
        WebElement inputFname = driver.findElement(By.xpath("//input[@id='firstName']"));
        WebElement inputLname = driver.findElement(By.xpath("//input[@id='lastName']"));
        WebElement inputEmail = driver.findElement(By.xpath("//input[@id='userEmail']"));
        List<WebElement> radioGender = driver.findElements(By.xpath("//div[@class='custom-control custom-radio custom-control-inline']/label"));
        WebElement inputMobile = driver.findElement(By.xpath("//input[@id='userNumber']"));
        WebElement inputDOB = driver.findElement(By.xpath("//input[@id='dateOfBirthInput']"));
        WebElement inputSubjects = driver.findElement(By.xpath("//input[@id='subjectsInput']"));
        List<WebElement> hobbiesCheckbox = driver.findElements(By.cssSelector("div[class='custom-control custom-checkbox custom-control-inline']"));
        for (WebElement ho : hobbiesCheckbox){
            System.out.println(ho.getText());
        }
        WebElement uploadPicture = driver.findElement(By.cssSelector("input[id='uploadPicture']"));
        WebElement inputAddress = driver.findElement(By.cssSelector("textarea[id='currentAddress']"));
        WebElement selectState = driver.findElement(By.xpath("//div[@class='col-md-4 col-sm-12'][1]"));
        WebElement selectCity = driver.findElement(By.xpath("//div[@class='col-md-4 col-sm-12'][2]"));
        WebElement submitButton = driver.findElement(By.xpath("//button[@id='submit'][@type='submit']"));


//        Thread.sleep(5000);
        // 1. Enter First name
        inputFname.sendKeys("Shubham");
        inputLname.sendKeys("Khera");
        inputEmail.sendKeys("test@gmail.com");
        for (WebElement rad : radioGender){
            if (rad.getText().equals("Male")){
                rad.click();
            }
        }
        inputMobile.sendKeys("1234567890");
//        Select calDOB = new Select(inputDOB);
//        calDOB.selectByVisibleText("");
        inputSubjects.sendKeys("Maths");
        inputSubjects.sendKeys(Keys.ENTER);
        inputSubjects.sendKeys("Arts");
        Thread.sleep(2000);
        inputSubjects.sendKeys(Keys.ENTER);
        for (WebElement ho : hobbiesCheckbox){
            if (ho.getText().equals("Sports")){
                ho.click();
            }
        }
        uploadPicture.sendKeys("C:\\Users\\shkhera\\Desktop\\TODO.jpg");
        inputAddress.sendKeys("7183/1, Sunny Enclave sector 125");
        Select state = new Select(selectState);
        state.selectByVisibleText("NCR");
        Select city = new Select(selectCity);
        city.selectByVisibleText("Delhi");
        submitButton.click();
    }

    @AfterTest
    public void closeBrowser(){
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e){
            throw new RuntimeException(e);
        } driver.quit();
    }
}
