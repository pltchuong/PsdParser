package com.psdparser.model.common.descriptor;

import java.util.List;

import com.psdparser.model.common.Descriptor;

public class ReferenceDescriptor extends Descriptor {

	private List<ReferenceStructure> referenceStructures;
	
	public List<ReferenceStructure> getReferenceStructures() {
		return referenceStructures;
	}
	public void setReferenceStructures(List<ReferenceStructure> referenceStructures) {
		this.referenceStructures = referenceStructures;
	}
	
}
