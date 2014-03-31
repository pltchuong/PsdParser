package com.psdparser.parser.common.descriptor;

import java.io.DataInputStream;

import org.apache.commons.io.input.CountingInputStream;

import com.psdparser.model.common.descriptor.UnitDoubleDescriptor;
import com.psdparser.parser.common.KernelParser;

public class UnitDoubleDescriptorParser {

	/**
	 * Unit float structure
	 * **/
	
	public static UnitDoubleDescriptor parse(DataInputStream dis, CountingInputStream cis) throws Exception {
		
		UnitDoubleDescriptor unitDoubleDescriptor = new UnitDoubleDescriptor();
		unitDoubleDescriptor.setUnit(KernelParser.parseString(dis, cis, 4));
		unitDoubleDescriptor.setValue(dis.readDouble());
		
		return unitDoubleDescriptor;
		
	}
	
}
