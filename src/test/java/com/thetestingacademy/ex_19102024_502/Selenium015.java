package com.thetestingacademy.ex_19102024_502;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Selenium015 {

    @Test
    public void VWOlogin(){
        EdgeDriver edgeDriver = new EdgeDriver();
        edgeDriver.get("https://app.vwo.com");

        Assert.assertEquals(edgeDriver.getCurrentUrl(), "https://app.vwo.com/#/login");

        edgeDriver.quit();
    }
}
