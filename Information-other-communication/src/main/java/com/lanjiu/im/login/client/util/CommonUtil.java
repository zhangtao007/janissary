package com.lanjiu.im.login.client.util;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class CommonUtil {
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

	/**
	 * 
	 * @param bytes
	 * @return
	 */
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

//			System.out.println("buff length: " + buff.length);
			SecretKey deskey = new SecretKeySpec("imsoftpw".getBytes(), "DES");
			Cipher c1 = Cipher.getInstance("DES");
            c1.init(Cipher.ENCRYPT_MODE, deskey);
            byte[] out = c1.doFinal(buff);
//            System.out.println("out length: " + out.length);
            byte[] buff1 = md.digest(out);

         	output = bytesToHex(buff1);
			
		} catch (NoSuchAlgorithmException | IllegalBlockSizeException | BadPaddingException | NoSuchPaddingException | InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return output;
	}
}
