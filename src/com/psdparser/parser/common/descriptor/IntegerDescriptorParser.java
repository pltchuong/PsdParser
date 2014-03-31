package com.psdparser.parser.common.descriptor;

import java.io.DataInputStream;

import org.apache.commons.io.input.CountingInputStream;

import com.psdparser.model.common.descriptor.IntegerDescriptor;

public class IntegerDescriptorParser {

	/**
	 * Integer structure
	 * **/
	
	public static IntegerDescriptor parse(DataInputStream dis, CountingInputStream cis) throws Exception {
		
		IntegerDescriptor integerDescriptor = new IntegerDescriptor();
		integerDescriptor.setValue(dis.readInt());
		
		return integerDescriptor;
		
	}
	
}
