package utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.*;

public class ExcelUtility {
    private static final String FILE_PATH = "C:\\Users\\upend\\eclipse-workspace\\Practice Exercises\\Selenium - S2\\pages\\TestData.xlsx";
    
    public static String[][] readTestData() {
        String[][] testData = null;
        try (FileInputStream fis = new FileInputStream(FILE_PATH);
             Workbook workbook = WorkbookFactory.create(fis)) {
            Sheet sheet = workbook.getSheetAt(0);
            int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum() + 1;
            int colCount = sheet.getRow(0).getLastCellNum();
            testData = new String[rowCount][colCount];
            for (int i = 0; i < rowCount; i++) {
                Row row = sheet.getRow(i);
                for (int j = 0; j < colCount; j++) {
                    Cell cell = row.getCell(j);
                    testData[i][j] = cell.getStringCellValue();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return testData;
    }
    
    public static void writeTestData(String[][] data) {
        try (FileInputStream fis = new FileInputStream(FILE_PATH);
             Workbook workbook = WorkbookFactory.create(fis);
             FileOutputStream fos = new FileOutputStream(FILE_PATH)) {
            Sheet sheet = workbook.getSheetAt(0);
            for (int i = 0; i < data.length; i++) {
                Row row = sheet.createRow(i);
                for (int j = 0; j < data[i].length; j++) {
                    Cell cell = row.createCell(j);
                    cell.setCellValue(data[i][j]);
                }
            }
            workbook.write(fos);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}



 
