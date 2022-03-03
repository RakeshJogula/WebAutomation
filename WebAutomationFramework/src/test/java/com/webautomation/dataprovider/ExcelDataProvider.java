package com.webautomation.dataprovider;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import com.webautomation.constants.FrameworkConstants;

public class ExcelDataProvider {
	
	@DataProvider(name = "testdata",parallel = true)
	public static Object[] getData() throws Exception {
		FileInputStream fileInputStream = null;
		XSSFWorkbook workbook = null;
		Object[] data = null;
		try {
			fileInputStream = new FileInputStream(FrameworkConstants.getExcelpath());
			workbook = new XSSFWorkbook(fileInputStream);
			XSSFSheet sheet = workbook.getSheet("Sheet1");

			int numberOfRows = sheet.getLastRowNum();
			int numberOfColumns = sheet.getRow(0).getPhysicalNumberOfCells();
			data = new Object[numberOfRows];
			Map<String, String> map = null;
			for (int i = 1; i <= numberOfRows; i++) {
				map = new HashMap<String, String>();
				for (int j = 0; j < numberOfColumns; j++) {
					String key = sheet.getRow(0).getCell(j).getStringCellValue();
					String value = sheet.getRow(i).getCell(j).getStringCellValue();
					map.put(key, value);
					data[i-1] = map;
				}
			}

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		} finally {
			workbook.close();
			fileInputStream.close();
		}
		return data;
	}

}
