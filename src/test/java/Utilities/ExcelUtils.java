package Utilities;
 
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
 


 
public class ExcelUtils 
{
 
		public static void writeData(String sheetName,List<String> a, int rowNo, int colNo) throws IOException {
			FileInputStream file=new FileInputStream(System.getProperty("user.dir")+"\\testData\\Book1.xlsx");
			XSSFWorkbook workbook=new XSSFWorkbook(file); 
			//XSSFSheet sheet = workbook.getSheet(sheetName);
			try {
				XSSFSheet sheet= workbook.getSheet(sheetName);	
				for(int i = rowNo; i<a.size(); i++)
				{
					if(sheet.getRow(i)==null)
					{
						sheet.createRow(i);
					}
					XSSFRow row =sheet.getRow(i);   
					row.createCell(colNo).setCellValue(a.get(i));
				}
			}
			catch(Exception e)
			{
				XSSFSheet sheet =	workbook.createSheet(sheetName);
				for(int i = rowNo; i<a.size(); i++) 
				{
					if(sheet.getRow(i)==null)
					{
						sheet.createRow(i);
					}
					XSSFRow row =sheet.getRow(i);   
					row.createCell(colNo).setCellValue(a.get(i));
				}
			}
			FileOutputStream fo=new FileOutputStream(System.getProperty("user.dir")+"\\testData\\Book1.xlsx");
			workbook.write(fo);		
			file.close();
			fo.close();
 
		}
		
		public static String[] InputData() throws IOException {
			FileInputStream file=new FileInputStream(System.getProperty("user.dir")+"\\testData\\readData.xlsx");
			XSSFWorkbook wb=new XSSFWorkbook(file);
			XSSFSheet sheet=wb.getSheetAt(0);
			XSSFRow row=sheet.getRow(0);
			String[] str=new String[11];
			for(int i=0;i<11;i++) {
				DataFormatter formatter = new DataFormatter();
				XSSFCell cell = row.getCell(i);
				str[i]=formatter.formatCellValue(cell);
			}
			file.close();
			wb.close();
			return str;
		}

	
}