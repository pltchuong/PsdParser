package com.psdparser.parser.common.descriptor;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.input.CountingInputStream;

import com.psdparser.model.common.descriptor.RawDataDescriptor;

public class RawDataDescriptorParser {

	/**
	 * Raw Data
	 * **/
	
	private int cachedByte = -1;
	private boolean useCachedByte;
	
	public RawDataDescriptor parse(DataInputStream dis, CountingInputStream cis) throws Exception {
		
		RawDataDescriptor rawDataDescriptor = new RawDataDescriptor();
		
		@SuppressWarnings("unused")
		int size = dis.readInt();
		@SuppressWarnings("unused")
		int startPos = cis.getCount();
		
		rawDataDescriptor.setProperties(readMap(dis));
		
		return rawDataDescriptor;
		
	}

	private Map<String, Object> readMap(DataInputStream stream) throws IOException {
		skipWhitespaces(stream);
		char c = (char) readByte(stream);

		if (c == ']') {
			return null;
		} else if (c == '<') {
			skipString(stream, "<");
		}
		HashMap<String, Object> map = new HashMap<String, Object>();
		while (true) {
			skipWhitespaces(stream);
			c = (char) readByte(stream);
			if (c == '>') {
				skipString(stream, ">");
				return map;
			} else {
				assert c == '/' : "unknown char: " + c + ", byte: " + (byte) c;
				String name = readName(stream);
				skipWhitespaces(stream);
				c = (char) lookForwardByte(stream);
				if (c == '<') {
					map.put(name, readMap(stream));
				} else {
					map.put(name, readValue(stream));
				}
			}
		}
	}

	private String readName(DataInputStream stream) throws IOException {
		String name = "";
		while (true) {
			char c = (char) readByte(stream);
			if (c == ' ' || c == 10) {
				break;
			}
			name += c;
		}
		return name;
	}

	private Object readValue(DataInputStream stream) throws IOException {
		char c = (char) readByte(stream);
		if (c == ']') {
			return null;
		} else if (c == '(') {
			// unicode string
			String string = "";
			int stringSignature = readShort(stream) & 0xFFFF;
			assert stringSignature == 0xFEFF;
			while (true) {
				byte b1 = readByte(stream);
				if (b1 == ')') {
					return string;
				}
				byte b2 = readByte(stream);
				if (b2 == '\\') {
					b2 = readByte(stream);
				}
				if (b2 == 13) {
					string += '\n';
				} else {
					string += (char) ((b1 << 8) | b2);
				}
			}
		} else if (c == '[') {
			ArrayList<Object> list = new ArrayList<Object>();
			// array
			c = (char) readByte(stream);
			while (true) {
				skipWhitespaces(stream);
				c = (char) lookForwardByte(stream);
				if (c == '<') {
					Object val = readMap(stream);
					if (val == null) {
						return list;
					} else {
						list.add(val);
					}
				} else {
					Object val = readValue(stream);
					if (val == null) {
						return list;
					} else {
						list.add(val);
					}
				}
			}
		} else {
			String val = "";
			do {
				val += c;
				c = (char) readByte(stream);
			} while (c != 10 && c != ' ');
			if (val.equals("true") || val.equals("false")) {
				return Boolean.valueOf(val);
			} else {
				return Double.valueOf(val);
			}
		}
	}

	private void skipWhitespaces(DataInputStream stream) throws IOException {
		byte b;
		do {
			b = readByte(stream);
		} while (b == ' ' || b == 10 || b == 9);
		putBack();
	}

	private void skipString(DataInputStream stream, String string) throws IOException {
		for (int i = 0; i < string.length(); i++) {
			char streamCh = (char) readByte(stream);
			assert streamCh == string.charAt(i) : "char " + streamCh + " mustBe " + string.charAt(i);
		}
	}

	private byte readByte(DataInputStream stream) throws IOException {
		if (useCachedByte) {
			assert cachedByte != -1;
			useCachedByte = false;
			return (byte) cachedByte;
		} else {
			cachedByte = stream.read();
			return (byte) cachedByte;
		}
	}

	private short readShort(DataInputStream stream) throws IOException {
		cachedByte = -1;
		useCachedByte = false;
		return stream.readShort();
	}

	private void putBack() {
		assert cachedByte != -1;
		assert !useCachedByte;
		useCachedByte = true;
	}

	private byte lookForwardByte(DataInputStream stream) throws IOException {
		byte b = readByte(stream);
		putBack();
		return b;
	}
}
