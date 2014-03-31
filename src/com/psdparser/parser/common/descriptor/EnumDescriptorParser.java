package com.psdparser.parser.common.descriptor;

import java.io.DataInputStream;

import org.apache.commons.io.input.CountingInputStream;

import com.psdparser.model.common.descriptor.EnumDescriptor;
import com.psdparser.parser.common.KernelParser;

public class EnumDescriptorParser {

	/**
	 * Enumerated descriptor
	 * **/
	
	public static EnumDescriptor parse(DataInputStream dis, CountingInputStream cis) throws Exception {
		
		EnumDescriptor enumDescriptor = new EnumDescriptor();
		enumDescriptor.setTypeId(KernelParser.parsePsdString(dis, cis));
		enumDescriptor.setValue(KernelParser.parsePsdString(dis, cis));
		
		return enumDescriptor;
		
	}
	
}
