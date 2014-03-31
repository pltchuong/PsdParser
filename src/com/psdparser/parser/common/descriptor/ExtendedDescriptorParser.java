package com.psdparser.parser.common.descriptor;

import java.io.DataInputStream;

import org.apache.commons.io.input.CountingInputStream;

import com.psdparser.model.common.descriptor.ExtendedDescriptor;
import com.psdparser.parser.common.DescriptorParser;

public class ExtendedDescriptorParser {

	/**
	 * Descriptor structure
	 * **/
	
	public static ExtendedDescriptor parse(DataInputStream dis, CountingInputStream cis) throws Exception {
		
		ExtendedDescriptor extendedDescriptor = new ExtendedDescriptor();
		extendedDescriptor.setDescriptors(DescriptorParser.parse(dis, cis));
		
		return extendedDescriptor;
		
	}
	
}
