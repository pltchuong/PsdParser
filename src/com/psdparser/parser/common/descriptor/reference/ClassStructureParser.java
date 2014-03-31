package com.psdparser.parser.common.descriptor.reference;

import java.io.DataInputStream;

import org.apache.commons.io.input.CountingInputStream;

import com.psdparser.model.common.descriptor.reference.ClassStructure;
import com.psdparser.parser.common.KernelParser;

public class ClassStructureParser {

	/**
	 * Class structure
	 * **/
	
	public static ClassStructure parse(DataInputStream dis, CountingInputStream cis) throws Exception {

		ClassStructure classStructure = new ClassStructure();
		classStructure.setName(KernelParser.parseUnicodeString(dis, cis));
		classStructure.setClassId(KernelParser.parsePsdString(dis, cis));
		
		return classStructure;
		
	}
	
}
