package com.webautomation.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.webautomation.constants.FrameworkConstants;

public final class ExcelUtils {
	
	private ExcelUtils() {
		
	}
	
	public static List<HashMap<String, String>> getTestDetails(String sheetName) {

		List<HashMap<String, String>> data = new ArrayList<HashMap<String, String>>();
		FileInputStream fileInputStream = null;
		XSSFWorkbook workbook = null;
		try {
			fileInputStream = new FileInputStream(FrameworkConstants.getExcelpath());
			workbook = new XSSFWorkbook(fileInputStream);
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

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		} finally {
			try {
				if (Objects.nonNull(workbook)) {
					workbook.close();
				}
				if (Objects.nonNull(fileInputStream)) {
					fileInputStream.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return data;

	}

}
