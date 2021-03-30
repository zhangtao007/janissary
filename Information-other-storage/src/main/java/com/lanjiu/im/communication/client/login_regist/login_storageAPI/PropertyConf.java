package com.lanjiu.im.communication.client.login_regist.login_storageAPI;

import java.io.InputStream;
import java.util.Properties;

public class PropertyConf {
	private Properties propertie;

	
	public PropertyConf(String filePath)  {
		propertie = new Properties();

		try {
			InputStream in = this.getClass().getResourceAsStream(filePath);
			propertie.load(in);
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	public String getValue(String key) {
		if(propertie.containsKey(key)) {
			String value = propertie.getProperty(key);
			return value;
		}else
			return "";
	}
	
//	public String getValue(String fileName, String key){
//			String value = "";
//			try {
//				inputFile = new FileInputStream(fileName);
//			} catch (FileNotFoundException e) {
//				e.printStackTrace();
//			}
//			try {
//				propertie.load(inputFile);
//				inputFile.close();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//			if(propertie.containsKey(key)) {
//				value = propertie.getProperty(key);
//				return value;
//			}else
//				return value;
//	}
}
