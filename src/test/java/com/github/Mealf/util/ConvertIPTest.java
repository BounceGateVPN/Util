package com.github.Mealf.util;

import static org.junit.Assert.*;

import org.junit.Test;

public class ConvertIPTest {

	@Test
	public void testToString() {
		String expected = "192.168.0.100";

		assertEquals(expected, ConvertIP.toString(-1062731676));
		assertEquals(expected, ConvertIP.toString(new byte[] { (byte) 0xc0, (byte) 0xa8, (byte) 0x00, (byte) 0x64 }));

		/*error input*/
		expected = null;
		assertEquals(expected, ConvertIP.toString(new byte[] { (byte) 0xc0, (byte) 0xa8 }));
	}

	@Test
	public void testToInteger() {
		Integer expected = -1062731676;

		assertEquals(expected, ConvertIP.toInteger("192.168.0.100"));
		assertEquals(expected, ConvertIP.toInteger(new byte[] { (byte) 0xc0, (byte) 0xa8, (byte) 0x00, (byte) 0x64 }));
		
		expected = -1;
		assertEquals(expected, ConvertIP.toInteger("255.255.255.255"));

		/*error input*/
		expected = null;
		assertEquals(expected, ConvertIP.toInteger("192.168.0."));
		assertEquals(expected, ConvertIP.toInteger("192.168.0.256"));
		assertEquals(expected, ConvertIP.toInteger(new byte[] { (byte) 0xc0, (byte) 0xa8 }));
	}

	@Test
	public void testToByteArray() {
		byte[] expected = new byte[] { (byte) 0xc0, (byte) 0xa8, (byte) 0x00, (byte) 0x64 };
		
		assertArrayEquals(expected, ConvertIP.toByteArray("192.168.0.100"));
		assertArrayEquals(expected, ConvertIP.toByteArray(-1062731676));
		
		/*error input*/
		expected = null;
		assertArrayEquals(expected, ConvertIP.toByteArray("192.168.0."));
		assertArrayEquals(expected, ConvertIP.toByteArray("192.168.0.256"));
	}
}
