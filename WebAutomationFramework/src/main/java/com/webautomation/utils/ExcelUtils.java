package com.webautomation.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.webautomation.constants.FrameworkConstants;
import com.webautomation.exceptions.InvalidPathForExcelException;

public final class ExcelUtils {
	
	private ExcelUtils() {
		
	}
	
	public static List<HashMap<String, String>> getTestDetails(String sheetName) {

		List<HashMap<String, String>> data = new ArrayList<HashMap<String, String>>();
		try (FileInputStream fileInputStream = new FileInputStream(FrameworkConstants.getExcelpath());
				XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);) {
			XSSFSheet sheet = workbook.getSheet(sheetName);

			int numberOfRows = sheet.getLastRowNum();
			int numberOfColumns = sheet.getRow(0).getPhysicalNumberOfCells();
			HashMap<String, String> map = null;
			for (int i = 1; i <= numberOfRows; i++) {
				map = new HashMap<String, String>();
				for (int j = 0; j < numberOfColumns; j++) {
					String key = sheet.getRow(0).getCell(j).getStringCellValue();
					String value = sheet.getRow(i).getCell(j).getStringCellValue();
					map.put(key, value);
				}
				data.add(map);
			}

		} catch (FileNotFoundException e) {
			throw new InvalidPathForExcelException("Excel File You are Trying to read is not found");
		} catch (IOException e) {
			throw new RuntimeException("File not Found");

		}
		return data;
	}

}
