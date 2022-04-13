package com.test.tools;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadExcel {


    //定义一个excel
    private static HSSFWorkbook workbook=null;

    public static String[][] readExcel(String filePath, String sheetName){

        //创建workbook
        File file = new File(filePath);
        try {
            workbook = new HSSFWorkbook(new FileInputStream(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        List result = new ArrayList();
        // 读取excel数据
        // 获得指定的excel表
        HSSFSheet sheet = workbook.getSheet(sheetName);
        // 获取表格的总行数
        int rowCount = sheet.getLastRowNum() + 1; // 需要加一
        System.out.println("rowCount:" + rowCount);
        // 获取表头的列数
        int columnCount = sheet.getRow(0).getLastCellNum();
        String[][] arr=new String[rowCount][4];
        // 读取表头信息,确定需要用的方法名---set方法
        for (int i=0;i<rowCount;i++){
            // 获得行对象
            HSSFRow row = sheet.getRow(i);
            for (int j=0;j<4;j++){
                arr[i][j]=row.getCell(j).toString();
            }
        }
return  arr;




    }



}
