package com.psdparser.parser.common.descriptor;

import java.io.DataInputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.input.CountingInputStream;

import com.psdparser.model.common.descriptor.ObjectArray;
import com.psdparser.parser.common.DescriptorParser;
import com.psdparser.parser.common.KernelParser;

public class ObjectArrayDescriptorParser {

	/**
	 * TODO: Undocumented
	 * **/
	
	public static List<ObjectArray> parse(DataInputStream dis, CountingInputStream cis) throws Exception {

		dis.skipBytes(10); // unknown
		
		String type = KernelParser.parsePsdString(dis, cis);
		
		List<ObjectArray> objectArrays = new ArrayList<ObjectArray>();
		int objectArrayLength = dis.readInt();
		for (int i = 0; i < objectArrayLength; i++) {
			ObjectArray objectArray = new ObjectArray();
			objectArray.setObjectType(type);
			
			dis.skipBytes(4); // unknown
			
			objectArray.setObjectId(KernelParser.parseString(dis, cis, 4));
			objectArray.setValue(DescriptorParser.parse(dis, cis, KernelParser.parseString(dis, cis, 4)));
			objectArray.setData(KernelParser.parseHex(dis, cis, 128)); // unknown
			
			objectArrays.add(objectArray);
		}
		
		
		return objectArrays;
		
	}
	
}
