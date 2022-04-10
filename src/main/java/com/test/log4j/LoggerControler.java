package com.test.log4j;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class LoggerControler {

    public static Logger logger=null;
    private static LoggerControler log=null;

    public static LoggerControler getlogger(Class<?> T){
        if (logger==null){
            //实例化Properties类处理。properties文件，处理log4j配置文件
            Properties properties=new Properties();
            try{
                //获取当前项目的路径
                String path = System.getProperty("user.dir");
                String filePath=path+"/config/log4j.properties";
                InputStream is=new FileInputStream(filePath);
                properties.load(is);
            }catch (IOException e){
                e.printStackTrace();
            }
            PropertyConfigurator.configure(properties);
            logger=Logger.getLogger(T);
            log=new LoggerControler();
        }
        return log;
    }



    public void info(String msg){
        logger.info(msg);
    }

    public void debug(String msg){
        logger.debug(msg);
    }

    public void warn(String msg){
        logger.warn(msg);
    }

    public void error(String msg){
        logger.error(msg);
    }




}
