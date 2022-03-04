package com.webautomation.dataprovider;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import com.webautomation.utils.ExcelUtils;

public class ExcelDataProvider {
	
	@DataProvider(name = "testdata",parallel = true)
	public static Object[] getData(Method m) {
		FileInputStream fileInputStream = null;
		XSSFWorkbook workbook = null;
		List<HashMap<String, String>> testdataInExcelToBeRun = null;
		try {
			String testName = m.getName();
			List<HashMap<String, String>> testdataInExcel = ExcelUtils.getTestDetails("DATA");
			testdataInExcelToBeRun = new ArrayList<HashMap<String,String>>();
			
			for(int i=0;i<testdataInExcel.size();i++) {
				String testcaseNameInExcel = testdataInExcel.get(i).get("TestCaseName");
				String executeStatusInExcel = testdataInExcel.get(i).get("Execute");
				if(testcaseNameInExcel.equalsIgnoreCase(testName)) {
					if(executeStatusInExcel.equalsIgnoreCase("Yes")) {
						testdataInExcelToBeRun.add(testdataInExcel.get(i));
					}
				}
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		 finally {
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
		
		
		return testdataInExcelToBeRun.toArray();
	}

}
