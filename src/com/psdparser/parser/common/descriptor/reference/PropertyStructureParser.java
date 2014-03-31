package com.psdparser.parser.common.descriptor.reference;

import java.io.DataInputStream;

import org.apache.commons.io.input.CountingInputStream;

import com.psdparser.model.common.descriptor.reference.PropertyStructure;
import com.psdparser.parser.common.KernelParser;

public class PropertyStructureParser {

	/**
	 * Property Structure
	 * **/
	
	public static PropertyStructure parse(DataInputStream dis, CountingInputStream cis) throws Exception {

		PropertyStructure propertyStructure = new PropertyStructure();
		propertyStructure.setName(KernelParser.parseUnicodeString(dis, cis));
		propertyStructure.setClassId(KernelParser.parsePsdString(dis, cis));		
		propertyStructure.setKeyId(KernelParser.parsePsdString(dis, cis));
		
		return propertyStructure;
		
	}
	
}
