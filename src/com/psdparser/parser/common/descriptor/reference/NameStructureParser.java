package com.psdparser.parser.common.descriptor.reference;

import java.io.DataInputStream;

import org.apache.commons.io.input.CountingInputStream;

import com.psdparser.model.common.descriptor.reference.NameStructure;
import com.psdparser.parser.common.KernelParser;

public class NameStructureParser {

	/**
	 * TODO: Undocumented
	 * **/
	
	public static NameStructure parse(DataInputStream dis, CountingInputStream cis) throws Exception {

		NameStructure indexStructure = new NameStructure();
		indexStructure.setValue(KernelParser.parseUnicodeString(dis, cis));
		
		return indexStructure;
		
	}
	
}
