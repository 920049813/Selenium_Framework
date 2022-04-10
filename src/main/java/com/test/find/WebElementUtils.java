package com.test.find;

import com.test.driver.SeleniumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class WebElementUtils extends SeleniumDriver {

    //查找元素（添加等待）
    public static WebElement findElement(final By by){
        WebElement element = null;
        try {
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(ExpectedConditions.presenceOfElementLocated(by));
        }catch (Exception e){
            System.out.println("为找到"+by+"元素");
        }

        element=driver.findElement(by);
        return element;
    }

    public static List<WebElement> findElements(final By by){
        List<WebElement> webElements=null;
        try {
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(ExpectedConditions.presenceOfElementLocated(by));
                } catch (Exception e) {
            System.out.print("元素"+by+"定位超时");
            e.printStackTrace();
        }
        webElements= driver.findElements(by);
        return webElements;
    }







}
