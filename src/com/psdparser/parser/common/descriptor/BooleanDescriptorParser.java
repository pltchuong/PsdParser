package com.psdparser.parser.common.descriptor;

import java.io.DataInputStream;

import org.apache.commons.io.input.CountingInputStream;

import com.psdparser.model.common.descriptor.BooleanDescriptor;

public class BooleanDescriptorParser {

	/**
	 * Boolean structure
	 * **/
	
	public static BooleanDescriptor parse(DataInputStream dis, CountingInputStream cis) throws Exception {
		
		BooleanDescriptor booleanDescriptor = new BooleanDescriptor();
		booleanDescriptor.setValue(dis.readBoolean());
		
		return booleanDescriptor;
		
	}
	
}
