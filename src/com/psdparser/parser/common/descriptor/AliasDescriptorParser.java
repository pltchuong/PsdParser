package com.psdparser.parser.common.descriptor;

import java.io.DataInputStream;

import org.apache.commons.io.input.CountingInputStream;

import com.psdparser.model.common.descriptor.AliasDescriptor;
import com.psdparser.parser.common.KernelParser;

public class AliasDescriptorParser {

	/**
	 * Alias structure
	 * **/
	
	public static AliasDescriptor parse(DataInputStream dis, CountingInputStream cis) throws Exception {
		
		AliasDescriptor aliasDescriptor = new AliasDescriptor();
		aliasDescriptor.setValue(KernelParser.parseString(dis, cis, dis.readInt()));
		
		return aliasDescriptor;
		
	}
	
}
