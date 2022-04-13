package com.test.wait03;

import com.test.driver.SeleniumDriver;
import com.test.tools.ExcelUtil;
import com.test.tools.ReadExcel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

public class WaitTest {




    //等待操作
    @Test
    public void waitTest2() throws InterruptedException {
        WebDriver driver = SeleniumDriver.open("chrome");
        driver.get("D:\\study\\IdeaProjects\\Selenium_Framework\\selenium_html\\index.html");
        driver.findElement(By.className("wait")).click();
        //线程等待
        ///Thread.sleep(3000);
        //局等待，所有的地方起作用，如果20s之内就正常，那就无需等待，否则会等待20s，然后抛超时异常
        //driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);  //后面这个参数是表示20s
        //显示等待，如果没有满足until后面的值，会等待5s，然后抛超时异常，如果5s之内就正常了，那就无需等待
        new WebDriverWait(driver,5).until(ExpectedConditions.presenceOfElementLocated(By.className("red")));
        String text=driver.findElement(By.xpath("//*[@id=\"display\"]/div")).getText();
        System.out.println(text);
        driver.quit();
    }



    //使用PhantomJS
    //亲测该方式在selenium2和selenium3正常使用，selenium4
    @Test
    public void PhtomJSTest(){
        System.setProperty("phantomjs.binary.path","D:\\study\\IdeaProjects\\Selenium_Framework\\drivers\\phantomjs.exe");
        WebDriver driver=new PhantomJSDriver();
        driver.get("https://www.baidu.com");
        String title = driver.getTitle();
        System.out.println(title);
        driver.quit();
    }



    @Test
    public void testExcel(){
        Object object = null;
        String[][] sheet1s = ReadExcel.readExcel("C:\\Users\\ZHANG\\Desktop\\部门座席账号密码.xls", "sheet1");
        System.out.println(sheet1s.length);
        for (int i = 0; i < sheet1s.length; i++) {

           // System.out.println(sheet1s[i]);

            for (int j = 0; j < sheet1s[0].length; j++) {
                System.out.println(sheet1s[i][j]);
            }
            }
        }






    @DataProvider(name = "test1")
    public  Object[][] data(){
        //记得return返回的后面要加引号，必须是Object类
        String[][] sheet1s = ReadExcel.readExcel("C:\\Users\\ZHANG\\Desktop\\部门座席账号密码.xls", "sheet1");
       return sheet1s;
    }

    @Test(dataProvider = "test1")
    public void testData(String i,String j,String k,String l){
        System.out.println(i+"----"+j+"----"+k+"------"+l);
    }







    }








