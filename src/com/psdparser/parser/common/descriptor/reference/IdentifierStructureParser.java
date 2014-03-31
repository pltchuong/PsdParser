package com.psdparser.parser.common.descriptor.reference;

import java.io.DataInputStream;

import org.apache.commons.io.input.CountingInputStream;

import com.psdparser.model.common.descriptor.reference.IndexStructure;

public class IdentifierStructureParser {

	/**
	 * TODO: Undocumented
	 * **/
	
	public static IndexStructure parse(DataInputStream dis, CountingInputStream cis) throws Exception {

		IndexStructure indexStructure = new IndexStructure();
		indexStructure.setValue(dis.readInt());
		
		return indexStructure;
		
	}
	
}
