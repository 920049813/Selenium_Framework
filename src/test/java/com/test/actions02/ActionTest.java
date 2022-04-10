package com.test.actions02;

import com.test.driver.SeleniumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class ActionTest {

    @Test
    public void getText() throws InterruptedException {
        WebDriver driver = SeleniumDriver.open("chrome");
        driver.get("https://www.baidu.com");
        String text = Actions.getText(By.xpath("//*[@id=\"s-top-left\"]/a[1]"));
        System.out.println(text);
        Thread.sleep(3000);
        driver.quit();
    }


    @Test
    public void getTexts() throws InterruptedException {
        WebDriver driver = SeleniumDriver.open("chrome");
        driver.get("https://www.baidu.com");
        ArrayList texts = Actions.getTexts(By.xpath("//*[@id=\"s-top-left\"]/a"));
        System.out.println(texts);
        for (int i = 0; i < texts.size(); i++) {
            System.out.println(texts.get(i));
        }
        //Thread.sleep(3000);
        driver.quit();
    }
}
