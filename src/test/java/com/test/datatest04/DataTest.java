package com.test.datatest04;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class DataTest {


    @DataProvider(name = "test1")
    public  Object[][] data(){
        //记得return返回的后面要加引号，必须是Object类
        return new Object[][]{
                {"1","aa"},
                {"2","bb"},
                {"3","cc"}
        };
    }
    @Test(dataProvider = "test1")
    public void testData(String i,String j){
        System.out.print("i="+i+"和j="+j);
        System.out.print("\n");
    }




    @Test
    public void gridTest() throws MalformedURLException, InterruptedException {
        DesiredCapabilities fireFoxDC=DesiredCapabilities.firefox();
        //指定机器的ip和hub端口，wd/hub必须要写
        WebDriver driver=new RemoteWebDriver(new URL("http://192.168.1.1:5555/wd/hub"),fireFoxDC);
        // DesiredCapabilities chromeDC=DesiredCapabilities.chrome();
        //WebDriver driver=new RemoteWebDriver(new URL("http://192.168.1.1:5555/wd/hub"),chromeDC);
        driver.get("https://www.baidu.com");
        Thread.sleep(5000);
        driver.quit();
    }




}
