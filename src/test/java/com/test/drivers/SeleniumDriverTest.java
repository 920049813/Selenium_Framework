package com.test.drivers;

import com.test.driver.SeleniumDriver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class SeleniumDriverTest {


    @Test
    public void openTest() throws InterruptedException {
        WebDriver driver = SeleniumDriver.open("chrome");
        //SeleniumDriver.open("chrome");
        Thread.sleep(3000);
        driver.quit();

    }



}
