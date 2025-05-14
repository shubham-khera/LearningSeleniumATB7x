package PD_Ques;

import io.qameta.allure.Description;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Oues001_02 {

    WebDriver driver;
    String URL = "https://only-testing-blog.blogspot.com/2014/01/textbox.html";
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

    @BeforeTest
    public void openBroeser(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test(groups = "Blog", description = "Automating only-testing-blog Section 001", priority = 0)
    public void automatePage(){
        driver.navigate().to(URL);

        // 1. Filling First Name Input Box
        driver.findElement(By.name("fname")).sendKeys("Shubham");

        // 2. Filling Last Name Input Box
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.name("lname"))));
        driver.findElement(By.name("lname")).sendKeys("Khera");

        // 3. Filling Hidden Input box
        driver.findElement(By.cssSelector("input[id='text3'][name='Hidden']")).sendKeys("HiddenField");

        // 4. Deselect all the checkboxes
        List<WebElement> checkboxes = driver.findElements(By.cssSelector("input[name='vehicle'][type='checkbox']"));
        for (WebElement checkbox : checkboxes){
            if (checkbox.isSelected()){
                checkbox.click();
            }
        }

        // 5. Now CHeck the "I have a boat"  checkbox.
        driver.findElement(By.xpath("//input[@name='vehicle'][@type='checkbox'][@value='Boat']")).click();

        // 6. Select the female Radio button.
        driver.findElement(By.xpath("//input[@type='radio'][@value='female']")).click();

        // 7. Choose a file
        driver.findElement(By.cssSelector("input[name='img'][type='file']")).sendKeys("C:\\Users\\shkhera\\Desktop\\test1.csv");

        // 8. Select "Opel" value from a dropdown menu
        Select carList = new Select(driver.findElement(By.id("Carlist")));
        carList.selectByVisibleText("Opel");

    }

    @Test(groups = "Blog", description = "Automating only-testing-blog Section 002", priority = 1)
    public void automatePageSec02(){
        // 1. Select values for table "Russia" , "India" and "Germany"
        Select countryList = new Select(driver.findElement(By.cssSelector("select[name='FromLB']")));
        countryList.selectByVisibleText("Russia");
        countryList.selectByVisibleText("India");
        countryList.selectByVisibleText("Germany");

        // 2. Move the selected itoms to other table
        driver.findElement(By.cssSelector("input[type='button'][value='->']")).click();
    }

    @Test(groups = "Blog", description = "Automating only-testing-blog Section 003", priority = 2)
    public void automatePageSec03() throws InterruptedException {
        // 1. CLick on Show me confirmation button for alert
        driver.findElement(By.cssSelector("button[onclick='myFunction()']")).click();

        WebDriverWait wait02 = new WebDriverWait(driver, Duration.ofSeconds(10));

        // 2. Wait for alert to be present, click on Cancle and Match Text.
        Alert alertDismiss = wait02.until(ExpectedConditions.alertIsPresent());
        alertDismiss.dismiss();
        WebElement alertText = driver.findElement(By.cssSelector("div[id='demo']"));
        Assert.assertEquals(alertText.getText(), "You pressed Cancel!");


        // 3. CLick on Show me confirmation button for alert
        driver.findElement(By.cssSelector("button[onclick='myFunction()']")).click();

        // 4. Wait for alert to be present, click on Cancle and Match Text.
        Alert alertConfirmation = wait02.until(ExpectedConditions.alertIsPresent());
        alertConfirmation.accept();
        WebElement alertTextOk = driver.findElement(By.cssSelector("div[id='demo']"));
        Assert.assertEquals(alertTextOk.getText(), "You pressed OK!");

        // 5. Show me Alert
        driver.findElement(By.cssSelector("input[value='Show Me Alert']")).click();
        Alert showAlert = wait02.until(ExpectedConditions.alertIsPresent());
        Assert.assertEquals(showAlert.getText(), "Hi.. This is alert message!");
        showAlert.accept();

        // 6. Click on the Submit button
        driver.findElement(By.xpath("//input[@id='submitButton'][@type='submit']"));
    }


    @AfterTest
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(10000);
        driver.quit();
    }
}
