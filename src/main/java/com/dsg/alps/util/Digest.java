/**   
 * @Title: digest.java 
 * @Package com.dsg.cccs.utils 
 * @Description: TODO
 * @author proteus modoucc_gmail_com   
 * @date 2011-7-22 下午3:00:12   
 */
package com.dsg.alps.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @ClassName: digest
 * @Description: JAVA字符串加密算法
 * @author proteus modoucc_gmail_com
 * @date 2011-7-22 下午3:00:12
 * 
 */
public class Digest {
	private static Logger logger = LoggerFactory.getLogger(Digest.class);

	public static String MD5(String inStr) {
		return Digest.Encrypt(inStr, "MD5");
	}

	public static String SHA1(String inStr) {
		return Digest.Encrypt(inStr, "SHA-1");
	}

	public static String SHA256(String inStr) {
		return Digest.Encrypt(inStr, "SHA-256");
	}

	private static String Encrypt(String inStr, String encName) {

		MessageDigest md = null;
		// 加密后的字符串
		String outStr = null;

		try {
			md = MessageDigest.getInstance(encName);
		} catch (NoSuchAlgorithmException e) {
			logger.error("Digest error:", e.getMessage());
		}
		md.update(inStr.getBytes());

		// 通过执行诸如填充之类的最终操作完成哈希计算
		outStr = bytes2Hex(md.digest()); // to HexString

		return outStr;
	}

	// 将字节数组转换成16进制的字符串
	private static String bytes2Hex(byte[] bts) {
		String des = "";
		String tmp = null;

		for (int i = 0; i < bts.length; i++) {
			tmp = (Integer.toHexString(bts[i] & 0xFF));
			if (tmp.length() == 1) {
				des += "0";
			}
			des += tmp;
		}
		return des;
	}

}
