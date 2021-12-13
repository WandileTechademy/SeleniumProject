package com.util;

import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class ExcelReader {

 

    /*
     * Apache POI used to read data from excel files
     * 
     */

 

    static XSSFWorkbook workbook;
    static XSSFSheet sheet;

 

    public ExcelReader(String excelPath, String sheetName) {
        try {
            workbook = new XSSFWorkbook(excelPath);
            sheet = workbook.getSheet(sheetName);
        } catch (IOException e) {
            System.out.println("Unable to read the excel file");
        }

 

    }

 

    // first identify how many rows are there
    public int getRowCount() {
        System.out.println("Rows are " + sheet.getPhysicalNumberOfRows());
        return sheet.getPhysicalNumberOfRows();

 

    }

 

    // identify how many columns are there
    public int getColCount() {
        System.out.println("Columns are " + sheet.getRow(0).getLastCellNum());
        return sheet.getRow(0).getLastCellNum();
    }

 

    public String getCellData(int rowNum, int colNum) {
        String cell = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
        System.out.println("Cell data is " + cell);
        return cell;
    }

 

    public Object[][] getTestData() {
        Object data[][] = null;
        //ExcelReader reader = new ExcelReader("./src/test/resources/TestData/Auto     (1).xlsx", "data");
        int rowCount = getRowCount();
        int colCount = getColCount();
        data = new Object[rowCount - 1][colCount];//skip the rows with the title
         

        for (int row = 1; row < rowCount; row++) {
            for (int col = 0; col < colCount; col++) {
                data[row - 1][col] = getCellData(row, col);
            }
        }
        
        return data;
    }
}
 