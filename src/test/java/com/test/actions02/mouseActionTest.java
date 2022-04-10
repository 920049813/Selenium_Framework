package com.test.actions02;

import com.test.driver.SeleniumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.List;

public class mouseActionTest {

    //右击和双击
    @Test
    public void RightClickTest() {
        WebDriver driver = SeleniumDriver.open("chrome");
        //右击和左键双击操作
        driver.get("https://www.baidu.com");
        WebElement element = driver.findElement(By.id("su"));
        //右键操作用到Action类
        Actions actions=new Actions(driver);
        //如果不传点击的元素，则会点击左上角的元素
        actions.contextClick(element).perform();
        actions.doubleClick(element).build().perform();
        driver.quit();
    }

    //移动鼠标到指定元素
    @Test
    public void moveTest() throws InterruptedException {
        WebDriver driver = SeleniumDriver.open("chrome");
        //鼠标移动操作
        driver.get("https://www.baidu.com");
        //移动到百度首页的图片链接上
        WebElement element = driver.findElement(By.xpath(".//*[@id='s-top-left']/a[6]"));
        Actions actions=new Actions(driver);
        actions.moveToElement(element).perform();
        Thread.sleep(300);
        driver.quit();
    }


    //鼠标拖拽操作(向x、y轴移动特定的像素)
    @Test
    public void dragTest() {
        WebDriver driver = SeleniumDriver.open("chrome");
        driver.get("D:\\study\\IdeaProjects\\Selenium_Framework\\selenium_html\\index.html");
        WebElement element = driver.findElement(By.xpath(".//*[@id='link']/a"));
        Actions actions=new Actions(driver);
        //拖动元素element移动,标准以元素element左上角为准,
        // 拖动元素相对元素A移到右边是x是正值，左边是负值，拖动元素相对元素A移到上边是y是负值，下边是正值
        actions.dragAndDropBy(element,500,800).perform();
        driver.quit();
    }

    //鼠标拖拽操作（从A元素位置移动到B元素位置）
    @Test
    public void dropTest1() {
        WebDriver driver = SeleniumDriver.open("chrome");
        driver.get("D:\\study\\IdeaProjects\\Selenium_Framework\\selenium_html\\index.html");
        WebElement element = driver.findElement(By.xpath(".//*[@id='link']/a"));
        WebElement element2 = driver.findElement(By.linkText("登录页面"));
        Actions actions=new Actions(driver);
        //按住元素1，然后拖到到元素2，再释放元素1，执行
        actions.clickAndHold(element).moveToElement(element2).release(element).perform();
        driver.quit();
    }



    //Robot模仿键盘操作
    @Test
    public void robotTest() throws AWTException {
        WebDriver driver = SeleniumDriver.open("chrome");
        driver.get("https://www.baidu.com");
        //robot使用,按住ctrl+S键然后释放
        Robot robot=new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_S);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_S);
        robot.keyPress(KeyEvent.VK_ALT);
        robot.keyPress(KeyEvent.VK_S);
        robot.keyRelease(KeyEvent.VK_ALT);
        robot.keyRelease(KeyEvent.VK_S);
    }


    //下拉框多选
    @Test
    public void testMultipsSelect(){
        WebDriver driver = SeleniumDriver.open("chrome");
        driver.get("D:\\study\\IdeaProjects\\Selenium_Framework\\selenium_html\\index.html");
        Actions actions = new Actions(driver);
        //获取多选框
        WebElement element = driver.findElement(By.xpath(".//*[@id='selectWithMultipleEqualsMultiple']"));
        //获取所有选项
        List<WebElement> elements = element.findElements(By.tagName("option"));
        actions.keyDown(Keys.SHIFT).click(elements.get(0)).click(elements.get(1)).click(elements.get(2)).build().perform();
        driver.quit();
    }


    //文件上传（直接使用sendkeys()方法即可）
    @Test
    public void uploadTest() throws InterruptedException {
        WebDriver driver = SeleniumDriver.open("chrome");
        driver.get("D:\\study\\IdeaProjects\\Selenium_Framework\\selenium_html\\index.html");
        driver.findElement(By.xpath(".//*[@id='load']")).sendKeys("E:\\HIVE.pptx");
        Thread.sleep(3000);
        driver.quit();
    }


    //文件下载操作
    @Test
    public void downloadTest(){
        //WebDriver driver = SeleniumDriver.open("chrome");
        // ChromeOptions chromeOptions = new ChromeOptions();
        ChromeOptions options = new ChromeOptions();
        HashMap<String, Object> chromeOptionsMap = new HashMap<String, Object>();
        //chromeOptionsMap.put("plugins.plugins_disabled", new String[] { "Chrome PDF Viewer" });
        chromeOptionsMap.put("download.default_directory", "C:\\Users\\Downloads\\test\\");
        options.setExperimentalOption("prefs", chromeOptionsMap);
        options.addArguments("--headless");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://registry.npmmirror.com/binary.html?path=chromedriver/100.0.4896.20/");
        driver.findElement(By.xpath("/html/body/table/tbody/tr[7]/td[2]/a")).click();
    }

    //文件下载
    @Test
    public void download() throws InterruptedException, AWTException {
        //获取当前项目地址
        String path = System.getProperty("user.dir");
        System.setProperty("webdriver.firefox.marionette", path+"/drivers/geckodriver.exe");
        FirefoxProfile profile=new FirefoxProfile();
        WebDriver driver;
        //下载操作,配置响应下载参数
        profile.setPreference("browser.download.dir","D:\\testing");
        profile.setPreference("browser.download.foldList",2);//2表示保存到指定路径，1表示我的下载，0表示桌面
        profile.setPreference("browser.download.useDownloadDir",true);
        profile.setPreference("browser.download.manager.showWhenStarting",false);//在开始下载时是否显示下载管理器
        //对所给出文件类型不再弹框进行询问
        profile.setPreference("browser.helperApps.neverAsk.saveToDisk","application/zip,text/plain," +
                "application/vnd.ms-excel,text/csv,text/comma-separated-values,application/octet-stream," +
                "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet,application/vnd." +
                "openxmlformats-officedocument.wordprocessingml.document");
       // driver=new FirefoxDriver(profile);
        driver=new FirefoxDriver();
        driver.get("http://image.baidu.com/search/detail?ct=503316480&z=0&ipn=d&word=%E5%B0%8F%E5%9B%BE%E7%89%87&step_word=&hs=0&pn=6&spn=0&di=28610677040&pi=0&rn=1&tn=baiduimagedetail&is=0%2C0&istype=0&ie=utf-8&oe=utf-8&in=&cl=2&lm=-1&st=undefined&cs=4285530%2C402013338&os=680243863%2C305218249&simid=3334851803%2C451413571&adpicid=0&ln=1977&fr=&fmq=1476798824771_R&fm=&ic=undefined&s=undefined&se=&sme=&tab=0&width=&height=&face=undefined&ist=&jit=&cg=&bdtype=0&oriquery=&objurl=http%3A%2F%2Fpic30.nipic.com%2F20130615%2F12251844_141425397124_2.jpg&fromurl=ippr_z2C%24qAzdH3FAzdH3Fooo_z%26e3Bgtrtv_z%26e3Bv54AzdH3Ffi5oAzdH3FnAzdH3FlAzdH3Fbdmlmnch89u89uju_z%26e3Bip4s&gsm=0&rpstart=0&rpnum=0");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//*[@id=\"toolbar\"]/span[7]")).click();
        //快捷键的操作用到Robot类
        Robot robot=new Robot();
        robot.keyPress(KeyEvent.VK_ALT);
        robot.keyPress(KeyEvent.VK_S);
        Thread.sleep(3000);
        robot.keyRelease(KeyEvent.VK_ALT);
        robot.keyRelease(KeyEvent.VK_S);
        robot.keyPress(KeyEvent.VK_ENTER);
        Thread.sleep(3000);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }




    //多窗口的处理
    @Test
    public void WindTest() throws InterruptedException {
        WebDriver driver = SeleniumDriver.open("chrome");
        driver.get("D:\\study\\IdeaProjects\\Selenium_Framework\\selenium_html\\index.html");
        Thread.sleep(3000);
        //打开另一个新的页面
        driver.findElement(By.xpath("//*[@id=\"open\"]/a")).click();
        //获取第1个页面的句柄
        String handle1 = driver.getWindowHandle();
        //for循环判定是否为第一页面句柄如果不是就控制权转交
        for (String handles : driver.getWindowHandles()) {
            if (handles.equals(handle1)) {
                continue;
            }
            driver.switchTo().window(handles); //将控制权转交给这个页面
        }
        driver.quit();
    }






























}
