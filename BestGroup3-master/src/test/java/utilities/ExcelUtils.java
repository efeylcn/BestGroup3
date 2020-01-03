package utilities;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;

public class ExcelUtils {

    // Workbook
    // Sheet
    // Row
    // Cell
    // filePath
    private static XSSFWorkbook workbook;
    private static XSSFSheet excelSheet;
    private static XSSFRow row;
    private static XSSFCell cell;
    private static String filePath;

    /**
     * This method opens an excel file
     * @param excelFileName
     * @param sheetName
     */
    public static void openExcelFile(String excelFileName, String sheetName) {
        filePath="src/test/resorces/Data/TestData/"+excelFileName+".xlsx"; ///  need to provide actual path of the xl sheet instead of "path'
        try {
            File file = new File(filePath);
            FileInputStream input = new FileInputStream(file);
            workbook =new XSSFWorkbook(input);
            excelSheet = workbook.getSheet(sheetName);


        }catch (Exception e){
            System.out.println("No such file in directory.");
        }
    }

    /**
     * This method will accept rowNum and celNum and return the value of the cell from the excel file.
     * @param rowNum
     * @param cellNum
     * @return
     */
    public static String getValue(int rowNum, int cellNum) {
        row = excelSheet.getRow(rowNum);
        cell = row.getCell(cellNum);
        return cell.toString();
    }

    /**
     * This method accepts value for cell as string and set/updates the value of that cell
     * @param value
     * @param rowNum
     * @param cellNum
     */
    public static void setValue(String value, int rowNum, int cellNum) throws IOException {
        row = excelSheet.getRow(rowNum);
        cell= row.getCell(cellNum);
        if (cell==null){
            cell = row.createCell(cellNum);
            cell.setCellType(CellType.STRING);
            cell.setCellValue(value);
        }else{
        cell.setCellValue(value);

        }
        FileOutputStream output =null;
        try {
            output = new FileOutputStream(filePath);
        workbook.write(output);}
        catch (FileNotFoundException e){
            System.out.println("No such file in directory.");
        }finally {
            output.close();
        }
    }

    /**
     * Method will return number of excel file's rows
     * @return
     */
    public static int getNumberOfRows(){
       return excelSheet.getPhysicalNumberOfRows();
    }

}
