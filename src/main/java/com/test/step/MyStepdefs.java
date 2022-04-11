package com.test.step;

import cucumber.api.PendingException;
import cucumber.api.java.zh_cn.并且;
import cucumber.api.java.zh_cn.当;
import cucumber.api.java.zh_cn.那么;
import org.openqa.selenium.WebDriver;

public class MyStepdefs {

    public static WebDriver driver;

    @当("^打开百度首页$")
    public void openBrowser() {
    }

    @并且("^在搜索文本框中输入\"([^\"]*)\"$")
    public void sendKeyToText(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @并且("^选择tomcat(\\d+)$")
    public void selectTomcatVersion(int arg0) {
    }

    @当("^我点击win(\\d+)版本下载$")
    public void downloadTomcat(int arg0) {
    }

    @那么("^下载成功$")
    public void downloadsussful() {

    }
}
