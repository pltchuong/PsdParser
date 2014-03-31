package com.psdparser.parser.common.descriptor;

import java.io.DataInputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.input.CountingInputStream;

import com.psdparser.model.common.Descriptor;
import com.psdparser.model.common.descriptor.ListDescriptor;
import com.psdparser.parser.common.DescriptorParser;
import com.psdparser.parser.common.KernelParser;

public class ListDescriptorParser {

	/**
	 * List structure
	 * **/
	
	public static ListDescriptor parse(DataInputStream dis, CountingInputStream cis) throws Exception {
		
		ListDescriptor listDescriptor = new ListDescriptor();
		
		List<Descriptor> descriptors = new ArrayList<Descriptor>();
		int descriptorCount = dis.readInt();
		for (int i = 0; i < descriptorCount; i++) {
			descriptors.add(DescriptorParser.parse(dis, cis, KernelParser.parseString(dis, cis, 4)));
		}
		listDescriptor.setDescriptors(descriptors);
		
		return listDescriptor;
		
	}
	
}
