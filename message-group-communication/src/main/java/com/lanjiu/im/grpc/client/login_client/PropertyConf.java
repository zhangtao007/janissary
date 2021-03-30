package com.lanjiu.im.grpc.client.login_client;

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
			return propertie.getProperty(key);
		}else
			return "";
	}
}
