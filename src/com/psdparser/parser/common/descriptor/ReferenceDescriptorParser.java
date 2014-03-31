package com.psdparser.parser.common.descriptor;

import java.io.DataInputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.input.CountingInputStream;

import com.psdparser.model.common.descriptor.ReferenceDescriptor;
import com.psdparser.model.common.descriptor.ReferenceStructure;
import com.psdparser.parser.common.KernelParser;
import com.psdparser.parser.common.descriptor.reference.ClassStructureParser;
import com.psdparser.parser.common.descriptor.reference.EnumeratedStructureParser;
import com.psdparser.parser.common.descriptor.reference.IdentifierStructureParser;
import com.psdparser.parser.common.descriptor.reference.IndexStructureParser;
import com.psdparser.parser.common.descriptor.reference.NameStructureParser;
import com.psdparser.parser.common.descriptor.reference.OffsetStructureParser;
import com.psdparser.parser.common.descriptor.reference.PropertyStructureParser;

public class ReferenceDescriptorParser {

	/**
	 * Reference Structure
	 * **/
	
	private static final String PROPERTY 				= "prop";
	private static final String CLASS 					= "Clss";
	private static final String ENUMERATED_REFERENCE 	= "Enmr";
	private static final String OFFSET 					= "rele";
	private static final String IDENTIFIER 				= "Idnt";
	private static final String INDEX 					= "indx";
	private static final String NAME 					= "name";
	
	public static ReferenceDescriptor parse(DataInputStream dis, CountingInputStream cis) throws Exception {

		ReferenceDescriptor referenceDescriptor = new ReferenceDescriptor();
		
		List<ReferenceStructure> referenceStructures = new ArrayList<ReferenceStructure>();
		int referenceDescriptorCount = dis.readInt();
		for (int i = 0; i < referenceDescriptorCount; i++) {
			String type = KernelParser.parseString(dis, cis, 4);
			
			ReferenceStructure referenceStructure = null;
			
			if(PROPERTY.equals(type)) {
				referenceStructure = PropertyStructureParser.parse(dis, cis);
			} else if(CLASS.equals(type)) {
				referenceStructure = ClassStructureParser.parse(dis, cis);
			} else if(ENUMERATED_REFERENCE.equals(type)) {
				referenceStructure = EnumeratedStructureParser.parse(dis, cis);
			} else if(OFFSET.equals(type)) {
				referenceStructure = OffsetStructureParser.parse(dis, cis);
			} else if(IDENTIFIER.equals(type)) {
				referenceStructure = IdentifierStructureParser.parse(dis, cis);
			} else if(INDEX.equals(type)) {
				referenceStructure = IndexStructureParser.parse(dis, cis);
			} else if(NAME.equals(type)) {
				referenceStructure = NameStructureParser.parse(dis, cis);
			} else {
				System.err.println("ReferenceDescriptorParser: " + type + " is undocumented or not implemented");
			}
			
			referenceStructure.setType(type);
			
			referenceStructures.add(referenceStructure);
		}
		referenceDescriptor.setReferenceStructures(referenceStructures);
		
		
		return referenceDescriptor;
		
	}
	
}
