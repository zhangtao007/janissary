package com.lanjiu.im.util;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CommonUtil {

	public static final long CACHE_HOLD_TIME = 30*60*1000L;

	private static final String HOLDTIME = "HoldTime";

	public static Map<String,Object> verifyCodeMap = new ConcurrentHashMap<String,Object>();

	public static String getSessionId(String userid) {
		String sessionid = "";
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");

			byte[] input = (userid + System
					.currentTimeMillis()).getBytes();

			byte[] buff = md.digest(input);

			sessionid = bytesToHex(buff);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return sessionid;
	}

	public static String bytesToHex(byte[] bytes) {
		StringBuffer sessionid = new StringBuffer();
		int digital;
		for (int i = 0; i < bytes.length; i++) {
			digital = bytes[i];

			if (digital < 0) {
				digital += 256;
			}
			if (digital < 16) {
				sessionid.append("0");
			}
			sessionid.append(Integer.toHexString(digital));
		}
		return sessionid.toString().toLowerCase();
	}
	
	public static String password(String str){
		String output = null;
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] buff = md.digest(str.getBytes());

			SecretKey deskey = new SecretKeySpec("imsoftpw".getBytes(), "DES");
			Cipher c1 = Cipher.getInstance("DES");
            c1.init(Cipher.ENCRYPT_MODE, deskey);
            byte[] out = c1.doFinal(buff);
//            System.out.println("out length: " + out.length);
            byte[] buff1 = md.digest(out);
            
         	output = bytesToHex(buff1);
			
		} catch (NoSuchAlgorithmException | IllegalBlockSizeException | BadPaddingException | NoSuchPaddingException | InvalidKeyException e) {
			//
			e.printStackTrace();
		}
		
		return output;
	}

	//设置一个缓存对象
	public static void put(String cache,String obj){
		put(cache,obj,CACHE_HOLD_TIME);
	}

	private static void put(String cache,String obj, long cacheHoldTime) {
		verifyCodeMap.put(cache,obj);
		verifyCodeMap.put(cache+HOLDTIME,System.currentTimeMillis()+CACHE_HOLD_TIME);
	}

	//取一个缓存对象
	public static  Object get(String cachekKey){
		 if (checkCache(cachekKey)){
		 	return verifyCodeMap.get(cachekKey);
		 }
		 return null;
	}

	private static boolean checkCache(String cache){
		Object obj = verifyCodeMap.get(cache + HOLDTIME);
		if(obj == null ){
			return false;
		}
		Long l =(long)obj;
		if (l < System.currentTimeMillis()){
			verifyCodeMap.remove(cache);
			return false;
		}
		return true;
	}

	//删除一个缓存
	public static  void remove(String ca){
		verifyCodeMap.remove(ca);
		verifyCodeMap.remove(ca+HOLDTIME);
	}




}
