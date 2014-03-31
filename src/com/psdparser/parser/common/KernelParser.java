package com.psdparser.parser.common;

import java.io.DataInputStream;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.io.input.CountingInputStream;

public class KernelParser {

	public static String parseString(DataInputStream dis, CountingInputStream cis, int length) throws Exception {
		return new String(parseBytes(dis, cis, length), "ISO-8859-1");
	}
	
	public static String parseUnicodeString(DataInputStream dis, CountingInputStream cis) throws Exception {
		int length = dis.readInt();
		StringBuilder unicodeString = new StringBuilder(length);
		for (int i = 0; i < length; i++) {
			unicodeString.append((char) dis.readShort());
		}
		
		return unicodeString.toString();
	}
	
	public static String parsePascalString(DataInputStream dis, CountingInputStream cis, boolean isPadded) throws Exception {
		int length = dis.read();
		if(isPadded) {
			// TODO: currently hard coded for layer name only, padded to a multiple of 4 bytes.
			length = length + (4 - (length % 4)) - 1;
		}
		if (length == 0) {
			length = 1;
		}
		
		return parseString(dis, cis, length);
	}
	
	public static String parsePsdString(DataInputStream dis, CountingInputStream cis) throws Exception {
		int length = dis.readInt();
        if (length == 0) {
            length = 4;
        }
        return parseString(dis, cis, length);
	}
	
	
	
	public static String parseHex(DataInputStream dis, CountingInputStream cis, int length) throws Exception {
		return Hex.encodeHexString(parseBytes(dis, cis, length)).toUpperCase();
	}
	
	public static byte[] parseBytes(DataInputStream dis, CountingInputStream cis, int length) throws Exception {
		byte[] bytes = new byte[length];
		dis.read(bytes);
		return bytes;
	}
}
