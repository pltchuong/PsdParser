package com.psdparser.parser.common.descriptor;

import java.io.DataInputStream;

import org.apache.commons.io.input.CountingInputStream;

import com.psdparser.model.common.descriptor.DoubleDescriptor;

public class DoubleDescriptorParser {

	/**
	 * Double structure
	 * **/
	
	public static DoubleDescriptor parse(DataInputStream dis, CountingInputStream cis) throws Exception {
		
		DoubleDescriptor doubleDescriptor = new DoubleDescriptor();
		doubleDescriptor.setValue(dis.readDouble());
		
		return doubleDescriptor;
		
	}
	
}
