package com.psdparser.parser.layer.additional;

import java.io.DataInputStream;

import org.apache.commons.io.input.CountingInputStream;

import com.psdparser.model.layer.additional.SavingMergedTransparency;

public class SavingMergedTransparencyParser {

	/**
	 * Saving Merged Transparency
	 * **/
	
	public static SavingMergedTransparency parse(DataInputStream dis, CountingInputStream cis, int additionalLayerLength) throws Exception {
		
		SavingMergedTransparency savingMergedTransparency = new SavingMergedTransparency();
		
		return savingMergedTransparency;
		
	}
		
}
