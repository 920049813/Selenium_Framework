package com.test.find;

import com.test.driver.SeleniumDriver;
import com.test.openBroswer01.OpenBroser02;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class FindElementTest {

    @Test
    public void findTest(){
        WebDriver driver = SeleniumDriver.open("chrome");
        driver.get("E:\\01.软件测试课程1000课【课件+源码+讲义】 (上学堂）\\08.课件+源码+讲义\\02.Web自动化selenium(java语言版）\\源码\\webdriver_demo\\selenium_html\\index.html");
        WebElementUtils.findElement(By.className("wait")).click();
        String text = WebElementUtils.findElement(By.className("red")).getText();
        System.out.println(text);
        driver.quit();

    }

    @Test
    public void testOpenBroswer(){
        WebDriver webDriver=OpenBroser02.openBrowsers("firefox");
    }

}
