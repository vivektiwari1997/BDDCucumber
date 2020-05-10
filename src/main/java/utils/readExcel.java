package utils;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InvalidPropertiesFormatException;

public class readExcel {

    static Workbook book;
    static Sheet sheet;

    public static String TestDataPath = "C:\\Users\\Vishal\\TestAutomation\\src\\main\\java\\utils\\LoginTests.xlsx";

    public static Object[][] getTestData(String sheetName){
        FileInputStream file =null;
        try {
            file = new FileInputStream(TestDataPath);
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
        try {
            book = WorkbookFactory.create(file);
        } catch (InvalidPropertiesFormatException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }

        sheet = book.getSheet(sheetName);
        Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
        for (int i = 0; i<sheet.getLastRowNum(); i++){
            for(int k=0; k<sheet.getRow(0).getLastCellNum();k++){
                data[i][k] = sheet.getRow(i+1).getCell(k).toString();
            }

        }
        return data;
    }
}
