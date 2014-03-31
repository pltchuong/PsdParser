package com.psdparser.parser.common.descriptor.reference;

import java.io.DataInputStream;

import org.apache.commons.io.input.CountingInputStream;

import com.psdparser.model.common.descriptor.reference.IdentifierStructure;

public class IndexStructureParser {

	/**
	 * TODO: Undocumented
	 * **/
	
	public static IdentifierStructure parse(DataInputStream dis, CountingInputStream cis) throws Exception {

		IdentifierStructure identifierStructure = new IdentifierStructure();
		identifierStructure.setValue(dis.readInt());
		
		return identifierStructure;
		
	}
	
}
