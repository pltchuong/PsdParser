package com.psdparser.parser.common.descriptor.reference;

import java.io.DataInputStream;

import org.apache.commons.io.input.CountingInputStream;

import com.psdparser.model.common.descriptor.reference.OffsetStructure;
import com.psdparser.parser.common.KernelParser;

public class OffsetStructureParser {

	/**
	 * Offset structure
	 * **/
	
	public static OffsetStructure parse(DataInputStream dis, CountingInputStream cis) throws Exception {

		OffsetStructure offsetStructure = new OffsetStructure();
		offsetStructure.setName(KernelParser.parseUnicodeString(dis, cis));
		offsetStructure.setClassId(KernelParser.parsePsdString(dis, cis));
		offsetStructure.setValue(dis.readInt());
		
		return offsetStructure;
		
	}
	
}
