package com.psdparser.parser.layer.additional;

import java.io.DataInputStream;

import org.apache.commons.io.input.CountingInputStream;

import com.psdparser.model.layer.additional.ForeignEffectId;

public class ForeignEffectIdParser {

	/**
	 * Foreign effect ID (Photoshop 6.0)
	 * **/
	
	public static ForeignEffectId parse(DataInputStream dis, CountingInputStream cis, int additionalLayerLength) throws Exception {
		
		ForeignEffectId foreignEffectId = new ForeignEffectId();
		foreignEffectId.setId(dis.readInt());
		
		return foreignEffectId;
		
	}
		
}
