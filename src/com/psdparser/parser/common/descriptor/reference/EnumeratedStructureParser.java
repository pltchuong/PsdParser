package com.psdparser.parser.common.descriptor.reference;

import java.io.DataInputStream;

import org.apache.commons.io.input.CountingInputStream;

import com.psdparser.model.common.descriptor.reference.EnumeratedStructure;
import com.psdparser.parser.common.KernelParser;

public class EnumeratedStructureParser {

	/**
	 * Enumerated reference
	 * **/
	
	public static EnumeratedStructure parse(DataInputStream dis, CountingInputStream cis) throws Exception {

		EnumeratedStructure enumeratedStructure = new EnumeratedStructure();
		enumeratedStructure.setName(KernelParser.parseUnicodeString(dis, cis));
		enumeratedStructure.setClassId(KernelParser.parsePsdString(dis, cis));
		enumeratedStructure.setTypeId(KernelParser.parsePsdString(dis, cis));
		enumeratedStructure.setEnumerate(KernelParser.parsePsdString(dis, cis));
		
		return enumeratedStructure;
		
	}
	
}
