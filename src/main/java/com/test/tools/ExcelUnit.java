package com.test.tools;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelUnit {

    public static Workbook getWorkbook(String filePath) {
        Workbook wb=null;
        try {
            //判断文件的后缀
            if(filePath.endsWith(".xls")){

                File file = new File(filePath);
                FileInputStream fileInputStream = new FileInputStream(file);
                wb=new HSSFWorkbook(fileInputStream);


            }else if(filePath.endsWith(".slsx")){
                wb = new XSSFWorkbook(filePath);
            } 

        }catch (IOException e){
            e.printStackTrace();
        }
        return wb;
    }



}
