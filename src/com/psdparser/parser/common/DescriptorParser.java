package com.psdparser.parser.common;

import java.io.DataInputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.input.CountingInputStream;

import com.psdparser.model.common.Descriptor;
import com.psdparser.parser.common.descriptor.AliasDescriptorParser;
import com.psdparser.parser.common.descriptor.BooleanDescriptorParser;
import com.psdparser.parser.common.descriptor.ClassDescriptorParser;
import com.psdparser.parser.common.descriptor.DoubleDescriptorParser;
import com.psdparser.parser.common.descriptor.EnumDescriptorParser;
import com.psdparser.parser.common.descriptor.ExtendedDescriptorParser;
import com.psdparser.parser.common.descriptor.IntegerDescriptorParser;
import com.psdparser.parser.common.descriptor.ListDescriptorParser;
import com.psdparser.parser.common.descriptor.ObjectArrayDescriptorParser;
import com.psdparser.parser.common.descriptor.RawDataDescriptorParser;
import com.psdparser.parser.common.descriptor.ReferenceDescriptorParser;
import com.psdparser.parser.common.descriptor.StringDescriptorParser;
import com.psdparser.parser.common.descriptor.UnitDoubleDescriptorParser;
import com.psdparser.parser.common.descriptor.UnitFloatDescriptorParser;

public class DescriptorParser {

	/**
	 * http://www.adobe.com/devnet-apps/photoshop/fileformatashtml/#50577411_21585
	 * **/
	
	private static final String REFERENCE 		= "obj ";
	private static final String DESCRIPTOR 		= "Objc";
	private static final String LIST 			= "VlLs";
	private static final String DOUBLE 			= "doub";
	private static final String UNIT_DOUBLE 	= "UntF";
	private static final String STRING 			= "TEXT";
	private static final String ENUMERATED 		= "enum";
	private static final String INTEGER 		= "long";
	private static final String BOOLEAN 		= "bool";
	private static final String GLOBAL_OBJECT 	= "GlbO";
	private static final String TYPE 			= "type";
	private static final String CLASS 			= "GlbC";
	private static final String ALIAS 			= "alis";
	private static final String RAW_DATA 		= "tdta";
	
	private static final String UNIT_FLOAT 		= "UnFl";
	private static final String OBJECT_ARRAY 	= "ObAr";
	
	public static List<Descriptor> parse(DataInputStream dis, CountingInputStream cis) throws Exception {
	
		String name = KernelParser.parseUnicodeString(dis, cis);
		String classId = KernelParser.parsePsdString(dis, cis);
		
		List<Descriptor> descriptors = new ArrayList<Descriptor>();
		int descriptorCount = dis.readInt();
		for (int i = 0; i < descriptorCount; i++) {
			String key = KernelParser.parsePsdString(dis, cis);
			String type = KernelParser.parseString(dis, cis, 4);
			
			Descriptor descriptor = parse(dis, cis, type);
			descriptor.setName(name);
			descriptor.setClassId(classId);
			descriptor.setKey(key);
			descriptor.setType(type);
			
			descriptors.add(descriptor);
		}
		
		return descriptors;
		
	}

	
	public static Descriptor parse(DataInputStream dis, CountingInputStream cis, String type) throws Exception {
		
		Descriptor descriptor = null;
		
		if(REFERENCE.equals(type)) {
			descriptor = ReferenceDescriptorParser.parse(dis, cis);
		} else if(DESCRIPTOR.equals(type) || GLOBAL_OBJECT.equals(type)) {
			descriptor = ExtendedDescriptorParser.parse(dis, cis);
		} else if(LIST.equals(type)) {
			descriptor = ListDescriptorParser.parse(dis, cis);
		} else if(DOUBLE.equals(type)) {
			descriptor = DoubleDescriptorParser.parse(dis, cis);
		} else if(UNIT_DOUBLE.equals(type)) {
			descriptor = UnitDoubleDescriptorParser.parse(dis, cis);
		} else if(STRING.equals(type)) {
			descriptor = StringDescriptorParser.parse(dis, cis);
		} else if(ENUMERATED.equals(type)) {
			descriptor = EnumDescriptorParser.parse(dis, cis);
		} else if(INTEGER.equals(type)) {
			descriptor = IntegerDescriptorParser.parse(dis, cis);
		} else if(BOOLEAN.equals(type)) {
			descriptor = BooleanDescriptorParser.parse(dis, cis);
		} else if(TYPE.equals(type) || CLASS.equals(type)) {
			descriptor = ClassDescriptorParser.parse(dis, cis);
		} else if(ALIAS.equals(type)) {
			descriptor = AliasDescriptorParser.parse(dis, cis);
		} else if(RAW_DATA.equals(type)) {
			descriptor = new RawDataDescriptorParser().parse(dis, cis);
		} else if(UNIT_FLOAT.equals(type)) {
			descriptor = UnitFloatDescriptorParser.parse(dis, cis);
		} else if(OBJECT_ARRAY.equals(type)) {
			ObjectArrayDescriptorParser.parse(dis, cis);
		} else {
			System.err.println("DescriptorParser: " + type + " is undocumented or not implemented");
		}
		
		return descriptor;
		
	}
}
