package PD_Ques;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Rand01 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://awesomeqa.com/practice.html");

        List<WebElement> check = driver.findElements(By.cssSelector("input[type = 'checkbox']"));
        for(WebElement checkbox : check){
            if(!checkbox.isSelected()){
                checkbox.click();
            }
        }

        WebElement autoTestCb = driver.findElement(By.cssSelector("#profession-1"));
        autoTestCb.click();

        WebElement toolCb = driver.findElement(By.cssSelector("#tool-1"));
        toolCb.click();

//        driver.quit();
    }
}
