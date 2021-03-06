package dataDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataDriver {

	private static XSSFWorkbook workbook;
	private static XSSFSheet sheet;	

	public static void main(String[] args) throws FileNotFoundException, IOException {
		List<String> data = new ArrayList<String>();
		FileInputStream file = new FileInputStream(new File("E:\\Project_Code\\Excel-Poi\\PoiFramework\\Book1.xlsx"));
		workbook = new XSSFWorkbook(file);
		int numberofSheets = workbook.getNumberOfSheets();
		for (int i = 0; i < numberofSheets; i++) {
			if (workbook.getSheetName(i).equalsIgnoreCase("Sheet1")) {
				sheet = workbook.getSheetAt(i);
				
				Iterator<Row> rows = sheet.iterator();
				while (rows.hasNext()) {
					Row row = rows.next();
					Iterator<Cell> cells = row.iterator();
					while(cells.hasNext()) {
						Cell cell = cells.next();
						if (cell.getStringCellValue().equalsIgnoreCase("purchase")) {
							Iterator<Cell> filtercells = row.cellIterator();
							while(filtercells.hasNext()) {
								data.add(filtercells.next().getStringCellValue());
							}
						}
					}
				}
				break;
			}
		}
		System.out.println(data);
	}

}
