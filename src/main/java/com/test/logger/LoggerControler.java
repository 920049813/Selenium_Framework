package com.test.logger;

import org.apache.log4j.PropertyConfigurator;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Logger;

/**
 * Created by lenovo on 2016/11/9.
 */
public class LoggerControler {
    private static Logger logger=null;
    private static LoggerControler loggCon=null;
    public static LoggerControler getLogger(Class<?> T) {
        if(logger==null){
            Properties props=new Properties();   //实例化一个Properties类，处理log4j.Properties文件
            String proPath=System.getProperty("user.dir")+ File.separator+"config"+File.separator+"log4j.properties";
            InputStream inputStream= null;
            try {
                inputStream = new FileInputStream(proPath);
                props.load(inputStream);
                //log4j的PropertyConfigurator类的configure方法输入数据流
                PropertyConfigurator.configure(props);
                logger= Logger.getLogger(String.valueOf(T));
                loggCon=new LoggerControler();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return loggCon;
    }
    //重写logger方法
    public void config(String msg) {
        logger.config(msg);
    }
    public void info(String msg){
        logger.info(msg);
    }
    public void warning(String msg) {
        logger.warning(msg);
    }
    public void severe(String msg) {
        logger.severe(msg);
    }

}
