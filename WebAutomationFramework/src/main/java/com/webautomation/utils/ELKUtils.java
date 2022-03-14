/**
 * <b>Info</b><br>
 * <b>Date</b> - Mar 14, 2022 <br>
 * <b>Time</b> - 6:10:15 PM <br>
 * <b>Project Name</b> - WebAutomationFramework <br>
 * <b>Package Name</b> - com.webautomation.utils <br>
 * @author Rakesh Jogula <p>
 * @version 1.0 <p>
 */
package com.webautomation.utils;


import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.webautomation.enums.ConfigProperties;

import java.io.IOException;
import java.io.UnsupportedEncodingException;




/**
 * <b>Info</b><br>
 * <b>Date</b> - Mar 14, 2022 <br>
 * <b>Time</b> - 6:10:15 PM <br>
 * <b>Project Name</b> - WebAutomationFramework <br>
 * <b>Package Name</b> - com.webautomation.utils <br>
 * @author Rakesh Jogula <p>
 * @version 1.0 <p>
 */
public final class ELKUtils {
	
	private ELKUtils() {
		
	}
	
	
	public static void sendDetailsToELK(String testcaseName ,String status) {
		HttpPost post = new HttpPost(PropertyUtils.get(ConfigProperties.ELKURL));
		post.addHeader("content-type","application/json");
		StringBuilder json = new StringBuilder();
		json.append("{");
		json.append("\"testName\":\""+testcaseName+"\",");
		json.append("\"status\":\""+status+"\"");
		json.append("}");
		// send a JSON data
		try {
			post.setEntity(new StringEntity(json.toString()));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		try (CloseableHttpClient httpClient = HttpClients.createDefault();
				CloseableHttpResponse response = httpClient.execute(post)) {
			EntityUtils.toString(response.getEntity());
		} catch (IOException e) {
			e.printStackTrace();
		}
			
	}

}
