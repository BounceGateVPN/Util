package com.github.Mealf.util;

public class ConvertIP {

	/****** toString ******/
	/**
	 * @param ip
	 * @return
	 * 
	 */
	public static String toString(int ip) {
		if(!isValidIP(ip))
			return null;
		
		String ip_str = "";

		for (int i = 0; i < 4; i++) {
			ip_str += String.valueOf((ip & 0xFF000000) >>> 24);
			ip = ip << 8;

			if (i != 3)
				ip_str += '.';
		}

		return ip_str;
	}

	/**
	 * if error return null
	 * 
	 * @param ip
	 * @return
	 */
	public static String toString(byte[] ip) {
		if (!isValidIP(ip))
			return null;
		
		String ip_str = "";
		
		for (int i = 0; i < 4; i++) {
			ip_str += String.valueOf(((int) ip[i]) & 0xFF);

			if (i != 3)
				ip_str += '.';
		}

		return ip_str;
	}

	/****** toInteger ******/
	/**
	 * if error return null
	 * 
	 * @param ip
	 * @return
	 */
	public static Integer toInteger(String ip) {
		if(!isValidIP(ip))
			return null;
		
		int ip_num = 0;
		String[] parts = ip.split("\\.");

		for (int i = 0; i < 4; i++) {
			ip_num = ip_num << 8;
			ip_num = ip_num | Integer.parseInt(parts[i]);
		}

		return ip_num;
	}

	/**
	 * if error return 0
	 * 
	 * @param ip
	 * @return
	 */
	public static Integer toInteger(byte[] ip) {
		if(!isValidIP(ip))
			return null;
		
		int ip_num = 0;
		ip_num = (ip[0] & 0xFF) << 24 | (ip[1] & 0xFF) << 16 | (ip[2] & 0xFF) << 8 | (ip[3] & 0xFF);

		return ip_num;
	}

	/****** toByteArray ******/
	/**
	 * if error return null
	 * 
	 * @param ip
	 * @return
	 */
	public static byte[] toByteArray(String ip) {
		if(!isValidIP(ip))
			return null;
		
		byte[] ip_byte = new byte[4];

		String[] parts = ip.split("\\.");

		for (int i = 0; i < 4; i++) {
			ip_byte[i] = (byte) (Integer.parseInt(parts[i]) & 0xFF);
		}

		return ip_byte;
	}

	/**
	 * 
	 * @param ip
	 * @return
	 */
	public static byte[] toByteArray(int ip) {
		if(!isValidIP(ip))
			return null;
		
		byte[] ip_byte = new byte[4];

		for (int i = 3; i >= 0; i--) {
			ip_byte[i] = (byte) (ip & 0xFF);
			ip = ip >> 8;
		}

		return ip_byte;
	}

	public static boolean isValidIP(String ip) {
		if (ip == null)
			return false;

		/* check string consists of four parts */
		String[] parts = ip.split("\\.");
		if (parts.length != 4)
			return false;

		int num;
		/* check every part value is in range 0~255 */
		for (String part : parts) {
			try {
				num = Integer.parseInt(part);
				if (num >= 256 || num < 0)
					return false;

			} catch (NumberFormatException nfe) {
				return false;
			}
		}

		return true;
	}

	public static boolean isValidIP(byte[] ip) {
		if (ip == null || ip.length != 4)
			return false;

		return true;
	}
	public static boolean isValidIP(int ip) {
		return true;
	}
}
