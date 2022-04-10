package com.test.actions02;

import com.test.driver.SeleniumDriver;
import com.test.find.WebElementUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;


public class Actions extends SeleniumDriver {

    //点击方法
    //打开百度首页
    //点击百度首页的“新闻”
    public static void click(By by){
        WebElementUtils.findElement(by).click();
    }


    //文本输入
    public static void sentTest(By by,String text){
        WebElement element = WebElementUtils.findElement(by);
        element.clear();
        element.sendKeys(text);
    }

    //获取文本
    public static String getText(By by){
        String text = WebElementUtils.findElement(by).getText();
        return text;
    }

    //获取多个文本值
    public static ArrayList getTexts(By by){
        ArrayList arrayList = new ArrayList();
        List<WebElement> list = WebElementUtils.findElements(by);
        for (int i=0;i<list.size();i++){
            String text = list.get(i).getText();
            arrayList.add(text);
        }
        return arrayList;

    }







}
