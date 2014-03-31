package com.psdparser.parser.common.descriptor;

import java.io.DataInputStream;

import org.apache.commons.io.input.CountingInputStream;

import com.psdparser.model.common.descriptor.StringDescriptor;
import com.psdparser.parser.common.KernelParser;

public class StringDescriptorParser {

	/**
	 * String structure
	 * **/
	
	public static StringDescriptor parse(DataInputStream dis, CountingInputStream cis) throws Exception {
		
		StringDescriptor stringDescriptor = new StringDescriptor();
		stringDescriptor.setText(KernelParser.parseUnicodeString(dis, cis));
		
		return stringDescriptor;
		
	}
	
}
