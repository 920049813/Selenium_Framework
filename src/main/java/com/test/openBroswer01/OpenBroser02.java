package com.test.openBroswer01;

import com.test.logger.LoggerControler;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import static com.test.logger.LoggerControler.getLogger;

public class OpenBroser02 {


        public static WebDriver driver;
        final static LoggerControler log = getLogger(OpenBroser02.class);

        public static WebDriver openBrowsers(String browser) {
            if (browser.equals("chrome")) {
                System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
                driver = new ChromeDriver();
                log.info("你打开了" + browser + "浏览器");
            } else if (browser.equals("firefox")) {
                System.setProperty("webdriver.gecko.driver",".\\drivers\\geckodriver.exe");
                System.setProperty("webdriver.firefox.bin","D:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
                driver=new FirefoxDriver();
                log.info("你打开了" + browser + "浏览器");
            } else {
                log.severe("你输入的" + browser + "浏览器不支持打开");
            }
            return driver;
        }



        public static void closed() {
            driver.quit();
        }
    }
