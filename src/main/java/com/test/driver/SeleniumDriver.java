package com.test.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class SeleniumDriver {

    public static WebDriver driver;

    //打开浏览器
    public static WebDriver open(String browser){
        //获取当前项目地址
        String path = System.getProperty("user.dir");
        System.out.println(path);

        if (browser.equals("chrome")){
            System.setProperty("webdriver.chrome.driver", path+"/drivers/chromedriver.exe");
            driver=new ChromeDriver();
        }else if (browser.equals("ie")){
            System.setProperty("webdriver.ie.driver", path+"/drivers/IEDriverServer.exe");
            driver=new InternetExplorerDriver();
        }else if (browser.equals("firefox")){
            //内置低于47版本的firefox浏览器的驱动
            System.setProperty("webdriver.firefox.marionette", path+"/drivers/geckodriver.exe");
            //System.setProperty("webdriver.firefox.marionette","C:\\Program Files (x86)\\Mozilla Firefox\\geckodriver.exe");
           // WebDriver driver=new FirefoxDriver();
            driver=new FirefoxDriver();
        }else {
            System.out.println("输入的浏览器名称有误："+browser);
        }
        return driver;
    }




    //关闭浏览器
    public static void quitBrower(){
        driver.quit();
    }

    //关闭当前浏览器
    public static void closed(){
        driver.close();
    }














}
