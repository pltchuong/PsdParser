package com.psdparser.parser.common.descriptor;

import java.io.DataInputStream;

import org.apache.commons.io.input.CountingInputStream;

import com.psdparser.model.common.descriptor.UnitFloatDescriptor;
import com.psdparser.parser.common.KernelParser;

public class UnitFloatDescriptorParser {

	/**
	 * Undocumented
	 * **/
	
	public static UnitFloatDescriptor parse(DataInputStream dis, CountingInputStream cis) throws Exception {
		
		UnitFloatDescriptor unitFloatDescriptor = new UnitFloatDescriptor();
		unitFloatDescriptor.setUnit(KernelParser.parseString(dis, cis, 4));
		unitFloatDescriptor.setValue(dis.readInt());
		
		return unitFloatDescriptor;
		
	}
	
}
