package PD_Ques;
//  https://only-testing-blog.blogspot.com/2014/01/textbox.html  Using selenium , do the following.
//  fill in lastname uncheck all the checked box, and check the stage of the checked box if it is check,
//  uncheck it. Do not hard code the location, you need to first check if it is checked. select "I have a boot."
//  make sure you use selected based on the value="Boat" and not the absolute xpath location .
//  select female select Toyota in the drop down select Russia and Spain Click Show me confirmation add a wait
//  time for 3 sec and handle the alert. Click the submit button.

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Ques001_01 {
    public static void main(String[] args) {
        ChromiumDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://only-testing-blog.blogspot.com/2014/01/textbox.html");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        try {

            WebElement firstName = driver.findElement(By.name("fname"));
            firstName.clear();
            firstName.sendKeys("Shubham");

//            Thread.sleep(18000);

            // Fill in the lastname textbox
            WebElement lastNameInput = driver.findElement(By.name("lname"));
            wait.until(ExpectedConditions.elementToBeClickable(lastNameInput));
            lastNameInput.clear();
            lastNameInput.sendKeys("Khera");


            //Uncheck all checked checkboxes
            List<WebElement>  checkboxes = driver.findElements(By.cssSelector("input[type='checkbox']"));
            for (WebElement checkbox : checkboxes){
                if (checkbox.isSelected()){
                    checkbox.click(); //uncheck if selected
                }
            }

            // Select checkbox with value="Boat"
            WebElement boatCheckbox = driver.findElement(By.cssSelector("input[type='checkbox'][value='Boat']"));
            if (!boatCheckbox.isSelected()){
                boatCheckbox.click();
            }

            WebElement femaleRadio = driver.findElement(By.cssSelector("input[type='radio'][value='female']"));
            if(!femaleRadio.isSelected()){
                femaleRadio.click();
            }

            WebElement chooseFile = driver.findElement(By.cssSelector("input[name='img'][type='file']"));
            chooseFile.sendKeys("C:\\Users\\shkhera\\Desktop\\none.csv");
//            Thread.sleep(5000);


            // Select "Toyota" in drop-down
            Select carDropdown = new Select(driver.findElement(By.id("Carlist")));
            carDropdown.selectByVisibleText("Toyota");

            // Select Russia and Spain in Multiselect drop-down
            Select countryMultiselect = new Select(driver.findElement(By.name("FromLB")));
            countryMultiselect.deselectAll(); // Just in case
            countryMultiselect.selectByVisibleText("Russia");
            countryMultiselect.selectByVisibleText("Spain");

            WebElement moveSelection = driver.findElement(By.cssSelector("input[type='button'][value='->']"));
            moveSelection.click();

//            Thread.sleep(5000);

            // Click "Show me Confirmation" button
            WebElement showConfirmation = driver.findElement(By.xpath("//button[normalize-space()='Show Me Confirmation']"));
            showConfirmation.click();

            // Wait for 3 seconds
//            Thread.sleep(3);

            // Handle Alert
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            System.out.println("Alert says: " + alert.getText());
            alert.accept();

            // Click Submit Button
            WebElement subButton = driver.findElement(By.xpath("//input[@type='submit']"));
            subButton.click();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            //Close the browser after delay to see result
            driver.quit();
        }
    }
}
