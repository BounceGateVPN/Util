package com.github.Mealf.util;

public class ConvertIP {
	
	/******toString******/
	/**
	 * @param ip
	 * @return
	 * 
	 */
	public static String toString(int ip) {
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
	 * if error return ""
	 * @param ip
	 * @return
	 */
	public static String toString(byte[] ip) {
		String ip_str = "";

		if (ip.length != 4)
			return "";

		for (int i = 0; i < 4; i++) {
			ip_str += String.valueOf(((int) ip[i]) & 0xFF);

			if (i != 3)
				ip_str += '.';
		}

		return ip_str;
	}

	/******toInt******/
	/**
	 * if error return 0
	 * @param ip
	 * @return
	 */
	public static int toInt(String ip) {
		int ip_num = 0;

		String[] parts = ip.split("\\.");
		if (parts.length != 4)
			return 0;

		int num;
		for (int i = 0; i < 4; i++) {
			num = Integer.parseInt(parts[i]);
			if (num >= 256 || num < 0)
				return 0;

			ip_num = ip_num << 8;
			ip_num = ip_num | Integer.parseInt(parts[i]);
		}

		return ip_num;
	}
	
	/**
	 * if error return 0
	 * @param ip
	 * @return
	 */
	public static int toInt(byte[] ip) {
		int ip_num = 0;

		if (ip.length != 4)
			return 0;

		ip_num = (ip[0] & 0xFF) << 24 | (ip[1] & 0xFF) << 16 | (ip[2] & 0xFF) << 8 | (ip[3] & 0xFF);

		return ip_num;
	}

	/******toByteArray******/
	/**
	 * if error return null
	 * @param ip
	 * @return
	 */
	public static byte[] toByteArray(String ip) {
		byte[] ip_byte = new byte[4];

		String[] parts = ip.split("\\.");
		if (parts.length != 4)
			return null;

		int num;
		for (int i = 0; i < 4; i++) {
			num = Integer.parseInt(parts[i]);
			if (num >= 256 || num < 0)
				return null;

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
		byte[] ip_byte = new byte[4];

		for (int i = 3; i >= 0; i--) {
			ip_byte[i] = (byte) (ip & 0xFF);
			ip = ip >> 8;
		}

		return ip_byte;
	}
}
