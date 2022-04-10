package com.test.actions02;

import com.test.actions02.Actions;
import com.test.driver.SeleniumDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class ActionsTest {

    //click()
    //打开百度首页
    //点击首页的“新闻”
    @Test
    public void clickTest() throws InterruptedException {
        //打开浏览器
        WebDriver driver = SeleniumDriver.open("chrome");
        //最大窗口
        driver.manage().window().maximize();
        //打开百度
        driver.get("https://www.baidu.com");
        WebElement element = driver.findElement(By.xpath("//*[@id=\"s-top-left\"]/a[1]"));
        element.click();
        Thread.sleep(5000);
        driver.quit();
    }



    //clear() sendkeys()
    //打开百度首页
    //在搜索框中输入江门农行银行
    //清除内容
    @Test
    public void testClear() throws InterruptedException {
        //打开浏览器
        WebDriver driver = SeleniumDriver.open("chrome");
        //最大窗口
        driver.manage().window().maximize();
        //打开百度
        driver.get("https://www.baidu.com");
        WebElement kw = driver.findElement(By.id("kw"));
        kw.sendKeys("江门农商银行");
        Thread.sleep(5000);
        kw.clear();
        Thread.sleep(3000);
        driver.quit();
    }


    //getText()
    //打开百度首页
    //在搜索框中输入江门农行银行
    //清除内容
    @Test
    public void getTextTest() throws InterruptedException {
        //打开浏览器
        WebDriver driver = SeleniumDriver.open("chrome");
        //最大窗口
        driver.manage().window().maximize();
        //打开百度
        driver.get("https://www.baidu.com");
        WebElement kw = driver.findElement(By.id("kw"));
        kw.sendKeys("江门农商银行");
        Thread.sleep(3000);
        kw.clear();
        String text = kw.getText();
        Assert.assertEquals(text,"selenium");
        Thread.sleep(3000);
        driver.quit();
    }



    //getTitle()
    //打开百度首页
    //获取当前页面的标题
    //判断与预期值是否一致
    @Test
    public void getTitleTest() throws InterruptedException {
        //打开浏览器
        WebDriver driver = SeleniumDriver.open("chrome");
        //最大窗口
        driver.manage().window().maximize();
        //打开百度
        driver.get("https://www.baidu.com");
        String title = driver.getTitle();
        System.out.println(title);
        //判断实际值与预期值是否一致
        Assert.assertEquals(title,"百度一下，你就知道");
        Thread.sleep(2000);
        driver.quit();
    }


    //isDisposed
    //判断百度首页是否展示百度一下按钮
    @Test
    public void isDisplayTest(){
        WebDriver driver = SeleniumDriver.open("chrome");
        driver.manage().window().maximize();
        driver.get("https://www.baidu.com");
        boolean displayed = driver.findElement(By.id("su")).isDisplayed();
        Assert.assertTrue(displayed,"校验百度一下按钮是否展示");
        driver.quit();
    }

    //isSelected()
    //判断选择框是否被选中
    //http://localhost:63342/Selenium_Framework/selenium_html/index.html
    @Test
    public void isSlectedTest() throws InterruptedException {
        WebDriver driver = SeleniumDriver.open("chrome");
        driver.get("D:\\study\\IdeaProjects\\Selenium_Framework\\selenium_html\\index.html");
        //定位当前页面中的radio
        WebElement radio = driver.findElement(By.xpath(".//*[@id='radio']/input[1]"));
        Thread.sleep(2000);
        radio.click();
        Thread.sleep(3000);
        //判断是否被选中
        boolean selected = radio.isSelected();
        Assert.assertTrue(selected);
        driver.quit();
    }


    //isEnabled
    //判断元素是否为激活（是否可以点击）
    //打开本地的的页面，判断submit按钮是否为激活状态
    @Test
    public void isEnabledTest(){
        WebDriver driver = SeleniumDriver.open("chrome");
        driver.get("D:\\study\\IdeaProjects\\Selenium_Framework\\selenium_html\\index.html");
        boolean status = driver.findElement(By.cssSelector(".button")).isEnabled();
        Assert.assertFalse(status,"buttom按钮为非激活状态");
        driver.quit();
    }

    //screenshot()
    //打开百度页面并截图保存到本地
    @Test
    public void screenshotTest() throws IOException {
        WebDriver driver = SeleniumDriver.open("chrome");
        driver.get("D:\\study\\IdeaProjects\\Selenium_Framework\\selenium_html\\index.html");
        File screenshotAs = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshotAs,new File("E:/test.jpg"));
        driver.quit();
    }


    //iFramed的处理
    @Test
    public void iframeTest() throws InterruptedException {
        WebDriver driver = SeleniumDriver.open("chrome");
        driver.get("D:\\study\\IdeaProjects\\Selenium_Framework\\selenium_html\\index.html");
        driver.findElement(By.id("user")).sendKeys("this is iframe");
        Thread.sleep(3000);
        //把控制权转交给iframe界面，，id或者属性值为aa的iframe窗口,下面一个方法是没有Id和属性值的情况
        driver.switchTo().frame("aa");
        //点击iframe窗口的Linktext为baidu的按钮
        driver.findElement(By.linkText("baidu")).click();
        //把控制权回到顶部页面
        driver.switchTo().defaultContent();
        Thread.sleep(3000);
        driver.findElement(By.id("user")).clear();
        driver.findElement(By.id("user")).sendKeys("this is another iframe");
    }





    //Alert处理
    @Test
    public void alertTest() throws InterruptedException {
        WebDriver driver = SeleniumDriver.open("chrome");
        driver.get("D:\\study\\IdeaProjects\\Selenium_Framework\\selenium_html\\index.html");
        driver.findElement(By.xpath("//*[@id=\"alert\"]/input")).click();
        Thread.sleep(2000);
        //将控制权交给alert
        Alert alert = driver.switchTo().alert();
        alert.accept();
        Thread.sleep(2000);
        driver.quit();
    }


    //confirm处理
    @Test
    public void ConfirmTest() throws InterruptedException{
        WebDriver driver = SeleniumDriver.open("chrome");
        driver.get("D:\\study\\IdeaProjects\\Selenium_Framework\\selenium_html\\index.html");
        WebElement confirmButton = driver.findElement(By.xpath("//*[@id=\"confirm\"]/input"));
        confirmButton.click();
        //因为无法获取弹出框确定按钮的定位，所以把driver的控制权交给alert
        Alert alert=driver.switchTo().alert();
        Thread.sleep(3000);
        //点击取消按钮,然后弹出警告框，点击确定
        alert.dismiss();
        Thread.sleep(3000);
        alert.accept();
        driver.quit();
    }







}
