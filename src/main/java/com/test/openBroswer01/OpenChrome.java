package com.test.openBroswer01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class OpenChrome {


    WebDriver driver;

    @BeforeTest
    public void openChrome(){
        //设置系统变量,并设置chromedriver的路径为系统属性值
        System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
        //实例化ChromeDriver(打开浏览器)
        driver = new ChromeDriver();
    }

    @AfterTest
    public void close(){
        driver.close();
    }



    @Test
    public void checkTest() throws InterruptedException {
        driver.get("https://www.baidu.com");
        WebElement text = driver.findElement(By.xpath(".//*[@id='kw']"));
        text.sendKeys("selenium");
        WebElement buttum = driver.findElement(By.xpath(".//*[@id='su']"));
        buttum.click();
        Thread.sleep(2000);
        String title = driver.getTitle();
        Assert.assertEquals(title,"selenium_百度搜索","实际结果与预期结果不一致！");
        Thread.sleep(2000);
    }


}
