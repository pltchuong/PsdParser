package com.psdparser.parser.common.descriptor;

import java.io.DataInputStream;

import org.apache.commons.io.input.CountingInputStream;

import com.psdparser.model.common.descriptor.ClassDescriptor;
import com.psdparser.parser.common.KernelParser;

public class ClassDescriptorParser {

	/**
	 * Class structure
	 * **/
	
	public static ClassDescriptor parse(DataInputStream dis, CountingInputStream cis) throws Exception {
		
		ClassDescriptor classDescriptor = new ClassDescriptor();
		classDescriptor.setName(KernelParser.parseUnicodeString(dis, cis));
		classDescriptor.setClassId(KernelParser.parsePsdString(dis, cis));
		
		return classDescriptor;
		
	}
	
}
